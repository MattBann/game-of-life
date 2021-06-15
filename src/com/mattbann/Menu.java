package com.mattbann;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener, ChangeListener {
     int currentWidth = 100, currentHeight = 50;

     GameFrame GUIGame;

     JFrame pane = new JFrame();
     JPanel menu = new JPanel(new GridBagLayout());
     GridBagConstraints c = new GridBagConstraints();
     JPanel widthPanel = new JPanel();
     JPanel heightPanel = new JPanel();
     JPanel randomPanel = new JPanel();
     SpinnerModel modelW = new SpinnerNumberModel(currentWidth,50,190,1);
     JSpinner widthChoice = new JSpinner(modelW);
     SpinnerModel modelH = new SpinnerNumberModel(currentHeight,25,100,1);
     JSpinner heightChoice = new JSpinner(modelH);
     JLabel widthLabel = new JLabel("Width:");
     JLabel heightLabel = new JLabel("Height:");
     JButton startButton = new JButton("Start");
     JCheckBox randomCheckBox = new JCheckBox("Randomise?");

    public Menu() {

        startButton.addActionListener(this);
        widthChoice.addChangeListener(this);

        randomCheckBox.setSelected(true);

        // widthPanel.add(widthLabel);
        // widthPanel.add(widthChoice);
        // heightPanel.add(heightLabel);
        // heightPanel.add(heightChoice);
        // randomPanel.add(randomCheckBox);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; c.gridy = 0;
        menu.add(widthLabel,c);
        c.gridx = 1;
        menu.add(widthChoice,c);
        c.gridx = 0; c.gridy = 1;
        menu.add(heightLabel,c);
        c.gridx = 1;
        menu.add(heightChoice,c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        menu.add(randomCheckBox,c);
        c.gridy = 3;
        menu.add(startButton,c);
        
        // menu.add(widthPanel);
        // menu.add(heightPanel);
        // menu.add(randomPanel);
        // menu.add(startButton);
        pane.add(menu);
        pane.setMinimumSize(new Dimension(200,120));
        pane.setResizable(false);
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.setVisible(false);
        boolean isRandom = randomCheckBox.isSelected();

        GUIGame = new GameFrame(currentWidth,currentHeight,isRandom);

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
