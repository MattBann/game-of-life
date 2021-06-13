package com.mattbann;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener, ChangeListener {
     int currentWidth = 100, currentHeight = 50;

     JFrame menu = new JFrame();
     SpinnerModel modelW = new SpinnerNumberModel(currentWidth,50,190,1);
     JSpinner widthChoice = new JSpinner(modelW);
     SpinnerModel modelH = new SpinnerNumberModel(currentHeight,25,100,1);
     JSpinner heightChoice = new JSpinner(modelH);
     JLabel widthLabel = new JLabel("Width:");
     JLabel heightLabel = new JLabel("Height:");
     JButton startButton = new JButton("Start");

    public Menu() {

        startButton.addActionListener(this);
        widthChoice.addChangeListener(this);

        menu.add(widthLabel, BorderLayout.NORTH);
        menu.add(widthChoice, BorderLayout.NORTH);
        menu.add(heightLabel, BorderLayout.WEST);
        menu.add(heightChoice, BorderLayout.EAST);
        menu.add(startButton, BorderLayout.SOUTH);
        menu.pack();
        menu.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.setVisible(false);
        GameFrame GUIGame = new GameFrame(currentWidth,currentHeight);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (widthChoice.equals(e.getSource())) {
            currentWidth = (int) widthChoice.getValue();
        } else {
            currentHeight = (int) heightChoice.getValue();
        }
    }
}
