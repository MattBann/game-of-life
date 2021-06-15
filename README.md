# The Game of Life
This is a Java based implementation of John Conway's game of life.

# Explanation

In a grid, each cell is either 'alive' (black) or 'dead' (yellow).
What happens to a cell depends on the number of alive neighbours.
If alive:
- The cell survives if there are 2 or 3 neighbours
- Otherwise, it dies

If dead:
- The cell comes to life if there are exactly 3 neighbours

For a better explanation: https://youtu.be/R9Plq-D1gEk

This version allows you to change the closed grid size, randomise the grid and save the grids state.
