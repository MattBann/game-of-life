package com.mattbann;

import java.util.Scanner;
import java.util.Random;

public class GameGrid {

    private int gridWidth, gridHeight;
    private boolean[][] grid;

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public GameGrid(int w, int h, Boolean console) {

        gridWidth = w;
        gridHeight = h;

        // Initialise grid
        grid = new boolean[gridWidth][gridHeight];
        Random rand = new Random();
        InitialiseGrid(rand);

        if (console) {
            try {
                PlayOnConsole();
            } catch (InterruptedException e) {
                System.out.println("Something went wrong: ");
                e.printStackTrace();
            }
        }

    }

    public void InitialiseGrid() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                grid[i][j] = false;
            }
        }
    }
    public void InitialiseGrid(Random rand) {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                grid[i][j] = rand.nextBoolean();
            }
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    private void PlayOnConsole() throws InterruptedException {
        // Populate grid (using coordinates)
        System.out.println("Enter coordinates to populate game grid (space seperated x and y, one per line, type enter nothing to end): ");
        Scanner scanner = new Scanner(System.in);
        do {
            String input = scanner.nextLine();
            if (input.equals("")) break;
            try {
                String[] coords = input.split("\s");
                int x = Integer.parseInt(coords[0]), y = Integer.parseInt(coords[1]);
                PopulateGrid(x, y);
                DisplayGrid();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinate requires 2 numbers, try again");
            }
        } while (true);

        while (true) {
            String input = scanner.nextLine();
            if (input == "x") break;
            Cycle();
            DisplayGrid();
            Thread.sleep(500);
        }

    }

    public void Cycle() {
        boolean[][] temp = new boolean[gridWidth][gridHeight];
        int neighbourCount;
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {

                neighbourCount = CountNeighbours(x,y);

                if (grid[x][y]) {
                    switch (neighbourCount) {
                        case 2, 3 -> temp[x][y] = true;
                        default -> temp[x][y] = false;
                    }
                } else {
                    temp[x][y] = neighbourCount == 3;
                }

            }
        }
        grid = temp;
    }

    private int CountNeighbours(int x, int y) {
        int count = 0;
        if (!(x-1<0) && grid[x - 1][y]) count++;
        if (!(x-1<0) && !(y-1<0) && grid[x - 1][y-1]) count++;
        if (!(y-1<0) && grid[x][y - 1]) count++;
        if (!(y-1<0) && !(x+1>gridWidth-1) && grid[x + 1][y - 1]) count++;
        if (!(x+1>gridWidth-1) && grid[x + 1][y]) count++;
        if (!(x+1>gridWidth-1) && !(y+1>gridHeight-1) && grid[x + 1][y + 1]) count++;
        if (!(y+1>gridHeight-1) && grid[x][y + 1]) count++;
        if (!(y+1>gridHeight-1) && !(x-1<0) && grid[x - 1][y + 1]) count++;

        return count;
    }

    private void PopulateGrid(int x, int y) {
        if (x > gridWidth || y > gridHeight) {
            System.out.println("Invalid coordinate");
        }
        else {
            grid[x][y] = true;
        }
    }

    private void DisplayGrid() {
        for (int i = 0; i < gridWidth; i++) System.out.print("_");
        System.out.println();
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                System.out.print(grid[x][y] ? "⬛" : "⬜");
            }
            System.out.println();
        }
    }

}
