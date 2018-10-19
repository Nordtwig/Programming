int[][] cells;
int columns;
int rows;
int cellSize = 10;

void setup() {
  size(650, 650);
  ellipseMode(CORNER);
  frameRate(30);

  columns = width / cellSize;
  rows = height / cellSize;

  cells = new int[columns][rows];
  for (int i = 0; i < columns; i++) {
    for (int j = 0; j < rows; j++) {
      cells[i][j] = floor(random(2));
    }
  }
}

void draw() {
  background(70);
  drawCells();
  checkState();
}

void drawCells() {
  for (int i = 0; i < columns; i++) {
    for (int j = 0; j < rows; j++) {
      int xPos = i * cellSize;
      int yPos = j * cellSize;

      if (cells[i][j] == 1) {
        fill(72, 131, 210);
        stroke(50);
        ellipse(xPos, yPos, cellSize, cellSize);
      }
    }
  }
}

void checkState() {
  int[][] nextCell = new int[columns][rows];
  for (int i = 0; i < columns; i++) {
    for (int j = 0; j < rows; j++) {
      int count = 0;
      int cellState = cells[i][j];
      int neighbours = checkNeighbours(cells, i, j);

      if (cellState == 0 && neighbours == 3) {
        nextCell[i][j] = 1;
      } else if (cellState == 1 && (neighbours < 2 || neighbours > 3)) {
        nextCell[i][j] = 0;
      } else {
        nextCell[i][j] = cellState;
      }
    }
  }

  cells = nextCell;
}

int checkNeighbours(int [][]cells, int x, int y) {
  int count = 0;

  for (int i = -1; i < 2; i++) {
    for (int j = -1; j < 2; j++) {
      int column = (x + i + columns) % columns;
      int row = (y + j + rows) % rows;
      count += cells[column][row];
    }
  }

  count -= cells[x][y];
  return count;
}
