int gameState = 0;
int ballX, ballY;
int ballSize = 20;
int ballColor = color(0);
float gravity = 1;
float ballSpeedVert = 0;

void setup() {
  size(500, 500);
  ballX = width / 4;
  ballY = height / 5;
}

void draw() {
  if (gameState == 0) {
    initScreen();
  } else if (gameState == 1) {
    gameScreen();
  } else if (gameState == 2) {
    gameOverScreen();
  }
}

void initScreen() {
  background(0);
  textAlign(CENTER);
  textSize(20);
  text("Click to Start", height / 2, width / 2);
}
void gameScreen() {
  background(255);
  drawBall();
  applyGravity();
  keepInScreen();
}
void gameOverScreen() {

}

public void mousePressed() {
  if (gameState == 0) {
    startGame();
  }
}

void startGame() {
  gameState = 1;
}

void drawBall() {
  fill(ballColor);
  ellipse(ballX, ballY, ballSize, ballSize);
}

void applyGravity() {
  ballSpeedVert += gravity;
  ballY += ballSpeedVert;
}

void keepInScreen() {
  if (ballY + (ballSize / 2) > height) {
    ballY = height - (ballSize / 2);
    ballSpeedVert *= -1;
  }
  if (ballY + (ballSize / 2) < 0) {
    ballY = 0 + (ballSize / 2);
    ballSpeedVert *= -1;
  }
}
