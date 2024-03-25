package ru.laba.io.reader;

import ru.laba.solver.Equation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EquationFileReader implements Reader {
    @Override
    public Equation readFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    double a = Double.parseDouble(values[0].trim());
                    double b = Double.parseDouble(values[1].trim());
                    double c = Double.parseDouble(values[2].trim());
                    return new Equation(a, b, c);
                } else {
                    System.err.println("Incorrect number of values in the file.");
                }
            } else {
                System.err.println("File is empty.");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
}
