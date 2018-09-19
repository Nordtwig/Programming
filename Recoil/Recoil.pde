int gameState = 0;

color ballColor = color(0);
int ballX, ballY;
int ballSize = 20;

color racketColor = color(0);
float racketWidth = 100;
float racketHeight = 10;

float gravity = 1;
float ballSpeedVert = 0;
float airFriction = 0.0002;
float friction = 0.15;

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
  drawRacket();
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

void drawRacket() {
  fill(racketColor);
  rectMode(CENTER);
  rect(mouseX, mouseY, racketWidth, racketHeight);
}

void applyGravity() {
  ballSpeedVert += gravity;
  ballY += ballSpeedVert;
  ballSpeedVert -= (ballSpeedVert * airFriction);
}

void keepInScreen() {
  if (ballY + (ballSize / 2) > height) {
    ballY = height - (ballSize / 2);
    ballSpeedVert *= -1;
    ballSpeedVert -= (ballSpeedVert * friction);
  }
  if (ballY + (ballSize / 2) < 0) {
    ballY = 0 + (ballSize / 2);
    ballSpeedVert *= -1;
    ballSpeedVert -= (ballSpeedVert * friction);
  }
}
