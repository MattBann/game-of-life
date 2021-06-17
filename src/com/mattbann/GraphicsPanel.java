package com.mattbann;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GraphicsPanel extends JPanel implements MouseInputListener, ActionListener {

    private final int GRIDWIDTH, GRIDHEIGHT;
    private int currentSpeed;
    public boolean[][] savedState;
    private final int SPACING = 15;
    public boolean active = false;

    public Timer timer;

    public GameGrid game;

    public GraphicsPanel(int w, int h, boolean isRandom, int speed) {
        super();
        GRIDWIDTH = w;
        GRIDHEIGHT = h;
        currentSpeed = speed;
        timer = new Timer(1000/currentSpeed,this);
        game = new GameGrid(GRIDWIDTH,GRIDHEIGHT,false, isRandom);
        savedState = new boolean[GRIDWIDTH][GRIDHEIGHT];
        saveState();
        addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GRIDWIDTH*SPACING+1,GRIDHEIGHT*SPACING+1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        for (int y = 0; y < GRIDHEIGHT; y++) {
            for (int x = 0; x < GRIDWIDTH; x++) {
                if (game.getGrid()[x][y]) {
                    g.setColor(Color.black);
                }
                else {
                    g.setColor(Color.orange);
                }
                g.fillRect(x*SPACING,y*SPACING,SPACING,SPACING);
                g.setColor(Color.lightGray);
                g.drawRect(x*SPACING,y*SPACING,SPACING,SPACING);
            }
        }
    }

    public void Cycle() {
        game.Cycle();
        repaint();
    }

    public void ClearGrid() {
        game.InitialiseGrid();
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (int) Math.floor(e.getX()/SPACING);
        int y = (int) Math.floor(e.getY()/SPACING);
        game.flipCoordinate(x,y);
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void loadSaved() {
        game.loadSavedState(savedState);
        repaint();
    }
    
    public void autoCycle() {
        if (active) timer.start();
        else timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cycle();
    }

    public void saveState() {
        boolean[][] grid = game.getGrid();
        for (int y = 0; y < GRIDHEIGHT; y++) {
            for (int x = 0; x < GRIDWIDTH; x++) {
                savedState[x][y] = grid[x][y];
            }
        }
    }
}
