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
    private Button saveStateButton = new Button("Save State");
    private Button resetButton = new Button("Reset to saved");
    private Button clearGridButton = new Button("Clear Grid");
    private JPanel panel = new JPanel();

    public GameFrame(int w, int h, boolean isRandom) {
        super();
        gridWidth = w;
        gridHeight = h;
        graphics = new GraphicsPanel(gridWidth,gridHeight, isRandom);

        startStopButton.addActionListener(this);
        stepButton.addActionListener(this);
        saveStateButton.addActionListener(this);
        resetButton.addActionListener(this);
        clearGridButton.addActionListener(this);


        panel.add(startStopButton);
        panel.add(stepButton);
        panel.add(saveStateButton);
        panel.add(resetButton);
        panel.add(clearGridButton);

        add(graphics, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Game of life");
        pack();
        setResizable(false);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (startStopButton.equals(source)) {
            if (graphics.active) {
                graphics.active = false;
                graphics.autoCycle();
            } else {
                graphics.active = true;
                graphics.autoCycle();
            }
        } else if (stepButton.equals(source)) {
            graphics.Cycle();
        } else if (saveStateButton.equals(source)) {
            graphics.savedState = graphics.grid;
        } else if (resetButton.equals(source)) {
            graphics.loadSaved();
        } else if (clearGridButton.equals(source)){
            graphics.ClearGrid();
        }
    }


}
