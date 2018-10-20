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
