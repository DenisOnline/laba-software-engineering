package ru.laba.io.writer.impl;

import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import ru.laba.io.writer.Writer;
import ru.laba.solver.Solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SolutionFileWriter implements Writer {
    @Override
    public void writeToFile(String result, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeGraphToPath(Solution solution, JFreeChart chart) {
        Writer writer = new SolutionFileWriter();
        String resultWrit = writer.createResultString(solution);
        writer.writeToFile(resultWrit, "solution.txt");

        String imagePath = "graph.png";
        try {
            File imageFile = new File(imagePath);
            ChartUtils.saveChartAsPNG(imageFile, chart, 800, 600);
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        StringBuilder description = new StringBuilder("График функции ax^2 + bx + c, где a = 1, b = -1, c = 0\n");
        description.append("Корни уравнения: ");
        for (double root : solution.getRoots()) {
            description.append(root).append(", ");
        }
        description = new StringBuilder(description.substring(0, description.length() - 2)); // Удаляем последнюю запятую
        description.append("\n");

        description.append("График сохранен в файле: ").append(imagePath);

        writer.writeToFile(description.toString(), "solution.txt");
    }

    @Override
    public String createResultString(Solution solution) {
        StringBuilder sb = new StringBuilder();
        sb.append("Корни уравнения: ");
        double[] roots = solution.getRoots();
        for (double root : roots) {
            sb.append(root).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Удаляем лишнюю запятую и пробел в конце
        sb.append("\n");
        sb.append("График функции: ");
        return sb.toString();
    }
}
