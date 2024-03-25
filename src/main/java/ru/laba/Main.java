package ru.laba;

import ru.laba.ui.EquationUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EquationUI equationInputGUI = new EquationUI();
            equationInputGUI.setVisible(true);
        });
    }
}
