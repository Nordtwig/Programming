int gameState (0);

void setup() {
  size(500, 500);
}

void draw() {
  if (gameState == 0) {
    initState();
  } else if (gameState == 1) {
    gameState();
  } else if (gameState == 2) {
    gameOverState();
  }
}

void initState() {

}
void gameState() {

}
void gameOverState() {

}

public void mousePressed() {
  if (gameState == 0) {

  }
}

void startGame() {
  gameState = 1;
}
