package ru.laba.ui;

import ru.laba.io.reader.EquationFileReader;
import ru.laba.solver.Equation;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class EquationUI extends JFrame {

    private JTextField aField, bField, cField;
    private JButton submitButton, fileButton;
    private final EquationFileReader fileReader;

    public EquationUI() {
        setTitle("Equation Input");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fileReader = new EquationFileReader();

        initComponents();
        addComponents();
        attachListeners();
    }

    private void initComponents() {
        aField = new JTextField(10);
        bField = new JTextField(10);
        cField = new JTextField(10);
        submitButton = new JButton("Submit");
        fileButton = new JButton("Select File");
    }

    private void addComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("a:"));
        panel.add(aField);
        panel.add(new JLabel("b:"));
        panel.add(bField);
        panel.add(new JLabel("c:"));
        panel.add(cField);
        panel.add(new JLabel());
        panel.add(fileButton);
        panel.add(new JLabel());
        panel.add(submitButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
    }


    private void attachListeners() {
        submitButton.addActionListener(e -> {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());

            Equation equation = new Equation(a, b, c);

            //TODO: решить уравнение через класс Equation и поместить точки решение в класс Solution для построения графика
        });

        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
            int result = fileChooser.showOpenDialog(EquationUI.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                Equation equation = fileReader.readFromFile(selectedFile);

            }
        });
    }
}