import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Recoil extends PApplet {

int gameState = 0;
int ballX, ballY;
int ballSize = 20;
int ballColor = color(0);


float gravity = 1;
float ballSpeedVert = 0;
float airFriction = 0.0001f;
float friction = 0.1f;

public void setup() {
  
  ballX = width / 4;
  ballY = height / 5;
}

public void draw() {
  if (gameState == 0) {
    initScreen();
  } else if (gameState == 1) {
    gameScreen();
  } else if (gameState == 2) {
    gameOverScreen();
  }
}

public void initScreen() {
  background(0);
  textAlign(CENTER);
  textSize(20);
  text("Click to Start", height / 2, width / 2);
}
public void gameScreen() {
  background(255);
  drawBall();
  applyGravity();
  keepInScreen();
}
public void gameOverScreen() {

}

public void mousePressed() {
  if (gameState == 0) {
    startGame();
  }
}

public void startGame() {
  gameState = 1;
}

public void drawBall() {
  fill(ballColor);
  ellipse(ballX, ballY, ballSize, ballSize);
}

public void applyGravity() {
  ballSpeedVert += gravity;
  ballY += ballSpeedVert;
  ballSpeedVert -= (ballSpeedVert * airFriction);
}

public void keepInScreen() {
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
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Recoil" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
