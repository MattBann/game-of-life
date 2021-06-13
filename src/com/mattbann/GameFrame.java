package com.mattbann;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    private final int gridWidth, gridHeight;

    private GraphicsPanel graphics;
    private Button startStopButton = new Button("Start/Stop");
    private Button stepButton = new Button("Step");
    private Button resetButton = new Button("Reset");
    private Button clearGridButton = new Button("Clear Grid");
    private JPanel panel = new JPanel();

    public GameFrame(int w, int h) {
        super();
        gridWidth = w;
        gridHeight = h;
        graphics = new GraphicsPanel(gridWidth,gridHeight);

        startStopButton.addActionListener(this);
        stepButton.addActionListener(this);
        resetButton.addActionListener(this);
        clearGridButton.addActionListener(this);


        panel.add(startStopButton);
        panel.add(stepButton);
        panel.add(resetButton);
        panel.add(clearGridButton);

        add(graphics, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Game of life");
        pack();
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (startStopButton.equals(source)) {
            return;
        } else if (stepButton.equals(source)) {
            graphics.Cycle();
        } else if (resetButton.equals(source)) {
            return;
        } else if (clearGridButton.equals(source)){
            graphics.ClearGrid();
        }
    }


}