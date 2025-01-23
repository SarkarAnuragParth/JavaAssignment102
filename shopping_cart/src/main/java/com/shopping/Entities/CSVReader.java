package com.shopping.Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVReader {
    public static Map<String, Product> readProducts(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().skip(1).map(line -> line.split(","))
                .collect(Collectors.toMap(
                    data -> data[0].trim(),
                    data -> new Product(data[0].trim(), data[1].trim(), Integer.parseInt(data[2].trim()), Integer.parseInt(data[3].trim()))
                ));
        }
    }

    public static Map<String, Customer> readCustomers(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().skip(1).map(line -> line.split(","))
                .collect(Collectors.toMap(
                    data -> data[0].trim(),
                    data -> new Customer(data[0].trim(), data[1].trim())
                ));
        }
    }
}