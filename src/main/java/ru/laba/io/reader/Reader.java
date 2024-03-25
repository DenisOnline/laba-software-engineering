package ru.laba.io.reader;

import ru.laba.solver.Equation;

import java.io.File;

public interface Reader {
    Equation readFromFile(File filePath);
}
