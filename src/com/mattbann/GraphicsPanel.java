package com.mattbann;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GraphicsPanel extends JPanel implements MouseInputListener, ActionListener {

    private final int GRIDWIDTH, GRIDHEIGHT;
    public boolean[][] grid;
    public boolean[][] savedState;
    private final int SPACING = 15;
    public boolean active = false;

    public Timer timer = new Timer(500,this);

    public GameGrid game;

    public GraphicsPanel(int w, int h, boolean isRandom) {
        super();
        GRIDWIDTH = w;
        GRIDHEIGHT = h;
        game = new GameGrid(GRIDWIDTH,GRIDHEIGHT,false, isRandom);
        grid = game.getGrid();
        savedState = new boolean[GRIDWIDTH][GRIDHEIGHT];
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
                if (grid[x][y]) {
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
        grid = game.getGrid();
        repaint();
    }

    public void ClearGrid() {
        game.InitialiseGrid();
        grid = game.getGrid();
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (int) Math.floor(e.getX()/SPACING);
        int y = (int) Math.floor(e.getY()/SPACING);
        game.flipCoordinate(x,y);
        grid = game.getGrid();
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
        grid = game.getGrid();
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
}
