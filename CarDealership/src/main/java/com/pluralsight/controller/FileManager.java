package com.pluralsight.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileManager<T> implements DataManager<T> {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    protected List<String> readFile() {
        System.out.println("Looking for file at: " + new File(this.fileName).getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    protected void writeFile(List<String> lines, String delimiter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line.replace(delimiter, System.lineSeparator()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving to file: " + this.fileName + e.getMessage());
        }
    }
}
