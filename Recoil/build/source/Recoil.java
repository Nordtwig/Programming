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

int ballColor = color(0);
float ballX, ballY;
int ballSize = 20;

int racketColor = color(0);
float racketWidth = 100;
float racketHeight = 10;
int racketBounceRate = 20;

int wallSpeed = 5;
int wallInterval = 1000;
float lastAddTime = 0;
int minGapHeight = 200;
int maxGapHeight = 300;
int wallWidth = 80;
int wallColors = color(0);

ArrayList<int[]> walls = new ArrayList<int[]>();

float gravity = 1;
float ballSpeedVert = 0;
float ballSpeedHorizon = 10;
float airFriction = 0.0002f;
float friction = 0.15f;

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
  noCursor();
  drawBall();
  drawRacket();
  watchRacketBounce();
  wallAdder();
  wallHandler();
  applyGravity();
  applyHorizontalSpeed();
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

public void drawRacket() {
  fill(racketColor);
  rectMode(CENTER);
  rect(mouseX, mouseY, racketWidth, racketHeight);
}

public void wallAdder() {
  if (millis() - lastAddTime > wallInterval) {
    int randHeight = round(random(minGapHeight, maxGapHeight));
    int randY = round(random(0, height - randHeight));

    int[] randWall = {width, randY, wallWidth, randHeight};
    walls.add(randWall);
    lastAddTime = millis();
  }
}
public void wallHandler() {
  for (int i = 0; i < walls.size(); i++) {
  wallRemover(i);
  wallMover(i);
  wallDrawer(i);
  }
}
public void wallDrawer(int index) {
  int[] wall = walls.get(index);
  int gapWallX = wall[0];
  int gapWallY = wall[1];
  int gapWallWidth = wall[2];
  int gapWallHeight = wall[3];
  rectMode(CORNER);
  fill(wallColors);
  rect(gapWallX, 0, gapWallWidth, gapWallY);
  rect(gapWallX, gapWallY + gapWallHeight, gapWallWidth, height - (gapWallY + gapWallHeight));
}
public void wallMover(int index) {
  int[] wall = walls.get(index);
  wall[0] -= wallSpeed;
}
public void wallRemover(int index) {
  int[] wall = walls.get(index);
  if (wall[0] + wall [2] <= 0) {
    walls.remove(index);
  }
}

public void applyGravity() {
  ballSpeedVert += gravity;
  ballY += ballSpeedVert;
  ballSpeedVert -= (ballSpeedVert * airFriction);
}

public void applyHorizontalSpeed() {
  ballX += ballSpeedHorizon;
  ballSpeedHorizon -= (ballSpeedHorizon * airFriction);
}

public void keepInScreen() {
  if (ballY + (ballSize / 2) > height) {
    makeBounceBottom(height);
  }
  if (ballY + (ballSize / 2) < 0) {
    makeBounceTop(0);
  }
  if (ballX - (ballSize / 2) < 0) {
    makeBounceLeft(0);
  }
  if (ballX + (ballSize / 2) > width) {
    makeBounceRight(width);
  }
}

public void makeBounceBottom(float surface) {
  ballY = surface - (ballSize / 2);
  ballSpeedVert *= -1;
  ballSpeedVert -= (ballSpeedVert * friction);
}

public void makeBounceTop(float surface) {
  ballY = surface + (ballSize / 2);
  ballSpeedVert *= -1;
  ballSpeedVert -= (ballSpeedVert * friction);
}

public void makeBounceLeft(float surface) {
  ballX = surface + (ballSize / 2);
  ballSpeedHorizon *= -1;
  ballSpeedHorizon -= (ballSpeedHorizon * friction);
}

public void makeBounceRight(float surface) {
  ballX = surface - (ballSize / 2);
  ballSpeedHorizon *= -1;
  ballSpeedHorizon -= (ballSpeedHorizon * friction);
}

public void watchRacketBounce() {
  float overhead = mouseY - pmouseY;
  if ((ballX + (ballSize / 2) > mouseX - (racketWidth / 2)) && (ballX - (ballSize /2) < mouseX + (racketWidth / 2))) {
    if (dist(ballX, ballY, ballX, mouseY) <= (ballSize / 2) + abs(overhead)) {
      makeBounceBottom(mouseY);
      if (overhead < 0) {
        ballY += overhead;
        ballSpeedHorizon = (ballX - mouseX) / 10;
        ballSpeedVert += overhead;
      }
    }
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
