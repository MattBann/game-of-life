package com.mattbann;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener, ChangeListener {
     int currentWidth = 100, currentHeight = 50, currentSpeed = 2, currentDensity = 5;

     GameFrame GUIGame;

     JFrame pane = new JFrame();
     JPanel menu = new JPanel(new GridBagLayout());
     GridBagConstraints c = new GridBagConstraints();
    //  JPanel widthPanel = new JPanel();
    //  JPanel heightPanel = new JPanel();
    //  JPanel randomPanel = new JPanel();
     SpinnerModel modelW = new SpinnerNumberModel(currentWidth,40,190,1);
     JSpinner widthChoice = new JSpinner(modelW);
     SpinnerModel modelH = new SpinnerNumberModel(currentHeight,20,100,1);
     JSpinner heightChoice = new JSpinner(modelH);
     JLabel widthLabel = new JLabel("Width:");
     JLabel heightLabel = new JLabel("Height:");
     JButton startButton = new JButton("Start");
     JCheckBox randomCheckBox = new JCheckBox("Randomise?");
     JLabel densityLabel = new JLabel("Pop. Density:");
     SpinnerModel modelD = new SpinnerNumberModel(currentDensity,1,10,1);
     JSpinner densitySpinner = new JSpinner(modelD);
     SpinnerModel modelS = new SpinnerNumberModel(currentSpeed,1,10,1);
     JSpinner speedSpinner = new JSpinner(modelS);
     JLabel speedLabel = new JLabel("Game speed:");

    public Menu() {

        startButton.addActionListener(this);
        widthChoice.addChangeListener(this);
        heightChoice.addChangeListener(this);
        speedSpinner.addChangeListener(this);
        densitySpinner.addChangeListener(this);

        randomCheckBox.setSelected(true);

        // widthPanel.add(widthLabel);
        // widthPanel.add(widthChoice);
        // heightPanel.add(heightLabel);
        // heightPanel.add(heightChoice);
        // randomPanel.add(randomCheckBox);
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 5;
        c.gridx = 0; c.gridy = 0;
        menu.add(widthLabel,c);
        c.gridx = 1;
        menu.add(widthChoice,c);
        c.gridx = 0; c.gridy = 1;
        menu.add(heightLabel,c);
        c.gridx = 1;
        menu.add(heightChoice,c);
        c.gridx = 0; c.gridy = 2;
        menu.add(speedLabel,c);
        c.gridx = 1;
        menu.add(speedSpinner,c);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        menu.add(randomCheckBox,c);
        c.gridx = 0; c.gridy = 4;
        menu.add(densityLabel,c);
        c.gridx = 1;
        menu.add(densitySpinner,c);
        c.gridx = 0; c.gridy = 5;
        menu.add(startButton,c);
        
        // menu.add(widthPanel);
        // menu.add(heightPanel);
        // menu.add(randomPanel);
        // menu.add(startButton);
        pane.add(menu);
        pane.setMinimumSize(new Dimension(200,200));
        pane.pack();
        pane.setResizable(false);
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pane.setVisible(false);
        boolean isRandom = randomCheckBox.isSelected();

        GUIGame = new GameFrame(currentWidth,currentHeight,isRandom,currentSpeed,currentDensity);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();
        if (widthChoice.equals(source)) {
            currentWidth = (int) widthChoice.getValue();
        } else if (heightChoice.equals(source)) {
            currentHeight = (int) heightChoice.getValue();
        } else if (speedSpinner.equals(e.getSource())) {
            currentSpeed = (int) speedSpinner.getValue();
        } else if (densitySpinner.equals(e.getSource())){
            currentDensity = (int) densitySpinner.getValue();
        }
    }
}
