package ru.laba.solver.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.laba.solver.Equation;
import ru.laba.solver.Solution;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuadraticEquation implements Equation {
    private double a;
    private double b;
    private double c;

    @Override
    public Solution solvingEquation() {
        double discriminant = b * b - 4 * a * c;
        double[] roots = new double[2];
        int numberOfRoots = 0;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Уравнение имеет бесконечно много решений.");
                } else {
                    System.out.println("Уравнение не имеет решений.");
                }
            } else {
                roots[0] = -c / b;
                numberOfRoots = 1;
                return new Solution(roots, numberOfRoots);
            }
        } else if (discriminant > 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
            numberOfRoots = 2;
            return new Solution(roots, numberOfRoots);
        } else if (discriminant == 0) {
            roots[0] = -b / (2 * a);
            numberOfRoots = 1;
            return new Solution(roots, numberOfRoots);
        } else {
            System.out.println("Уравнение не имеет действительных корней.");
        }
        return new Solution(roots, numberOfRoots);
    }
}
