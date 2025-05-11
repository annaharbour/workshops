package com.pluralsight.controller;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class FileManager<T> implements DataManager<T> {
    private String path;
    private String fileName;

    public FileManager(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    protected List<String> readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            System.err.println("Error reading from file: " + this.path + "/" + this.fileName + " - " + e.getMessage());
            return new ArrayList<>();
        }
    }

    protected void writeFile(List<String> lines, String delimiter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(path, fileName).toString()))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving to file: " + this.path + "/" + this.fileName + e.getMessage());
        }
    }
}
