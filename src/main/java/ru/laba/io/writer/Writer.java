package ru.laba.io.writer;

import org.jfree.chart.JFreeChart;
import ru.laba.solver.Solution;

public interface Writer {
    void writeToFile(String result, String filePath);
    void writeGraphToPath(Solution solution, JFreeChart chart);
    String createResultString(Solution solution);
}
