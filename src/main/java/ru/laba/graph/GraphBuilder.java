package ru.laba.graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.function.Function2D;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ru.laba.solver.Solution;

import java.awt.*;

public class GraphBuilder {

    public static JFreeChart buildGraph(Solution solution) {
        double[] roots = solution.getRoots();

        XYSeries series = new XYSeries("График функции");

        double a = 0, b = 0, c = 0;
        if (roots.length == 2) {
            a = 1;
            b = -roots[0] - roots[1];
            c = roots[0] * roots[1];
        } else if (roots.length == 1) {
            a = 1;
            b = -2 * roots[0];
        }

        final double finalA = a;
        final double finalB = b;
        final double finalC = c;
        Function2D function = new Function2D() {
            @Override
            public double getValue(double x) {
                return finalA * x * x + finalB * x + finalC;
            }
        };

        for (double x = roots[0] - 10; x <= roots[roots.length - 1] + 10; x += 0.1) {
            series.add(x, function.getValue(x));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "График функции",  // Заголовок графика
                "x",               // Подпись оси X
                "y",               // Подпись оси Y
                dataset,           // Данные для графика
                PlotOrientation.VERTICAL,
                false,             // Включаем/выключаем легенду
                true,              // Включаем/выключаем подсказки
                false              // Включаем/выключаем URL
        );

        chart.setBackgroundPaint(Color.white);

        return chart;
    }
}
