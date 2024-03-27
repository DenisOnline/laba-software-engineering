package ru.laba.io.reader;

import ru.laba.solver.impl.QuadraticEquation;

import java.io.File;

public interface Reader {
    QuadraticEquation readFromFile(File filePath);
}
