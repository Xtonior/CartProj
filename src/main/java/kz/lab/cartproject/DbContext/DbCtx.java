package kz.lab.cartproject.DbContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kz.lab.cartproject.Product;

import kz.lab.cartproject.Repository;

public class DbCtx implements Repository {
    private final String PATH = "db.json";

    private List<DbItem> readAll() {
        List<DbItem> list = new ArrayList<>();
        try {
            String content = Files.readString(Paths.get(PATH));

            content = content.trim();

            if (content.length() <= 2)
                return list;

            content = content.substring(1, content.length() - 1);
            String[] chunks = content.split("\\},\\{");

            for (String chunk : chunks) {

                String raw = chunk.replace("{", "").replace("}", "").replace("\"", "");

                String[] fields = raw.split(",");

                String name = fields[0].split(":")[1];
                String category = fields[1].split(":")[1];
                double price = Double.parseDouble(fields[2].split(":")[1]);

                list.add(new DbItem(name, category, price));
            }
        } catch (Exception e) {
            // Если файла нет или он битый, возвращаем пустой список
        }
        return list;
    }

    private void saveAll(List<DbItem> list) {
        String json = list.stream()
                .map(DbItem::toJson)
                .collect(Collectors.joining(",", "[", "]"));
        try {
            Files.writeString(Paths.get(PATH), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean writeProduct(Product product) {
        List<DbItem> all = readAll();

        all.removeIf(p -> p.getName().equalsIgnoreCase(product.getName()));

        all.add(new DbItem(product.getName(), product.getCategory(), product.getPrice()));
        saveAll(all);
        return true;
    }

    @Override
    public boolean removeProduct(Product product) {
        List<DbItem> all = readAll();
        if (all.removeIf(p -> p.getName().equalsIgnoreCase(product.getName()))) {
            saveAll(all);
            return true;
        }
        return false;
    }

    @Override
    public Product selectProduct(String name) {
        return readAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}