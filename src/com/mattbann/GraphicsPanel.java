package com.mattbann;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GraphicsPanel extends JPanel implements MouseInputListener {

    private final int GRIDWIDTH, GRIDHEIGHT;
    public boolean[][] grid;
    public boolean[][] savedState;

    public GameGrid game;

    public GraphicsPanel(int w, int h) {
        super();
        GRIDWIDTH = w;
        GRIDHEIGHT = h;
        game = new GameGrid(GRIDWIDTH,GRIDHEIGHT,false);
        grid = game.getGrid();
        savedState = new boolean[GRIDWIDTH][GRIDHEIGHT];
        addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GRIDWIDTH*10+1,GRIDHEIGHT*10+1);
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
                g.fillRect(x*10,y*10,10,10);
                g.setColor(Color.lightGray);
                g.drawRect(x*10,y*10,10,10);
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
        int x = (int) Math.floor(e.getX()/10);
        int y = (int) Math.floor(e.getY()/10);
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
}
