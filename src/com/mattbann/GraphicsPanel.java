package com.mattbann;

import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {

    private final int GRIDWIDTH, GRIDHEIGHT;
    private boolean[][] grid;

    public GameGrid game = new GameGrid(100,50,false);

    public GraphicsPanel(int w, int h) {
        super();
        GRIDWIDTH = w;
        GRIDHEIGHT = h;
        grid = game.getGrid();
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
}
