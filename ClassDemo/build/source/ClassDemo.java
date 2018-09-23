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

public class ClassDemo extends PApplet {

Ball[] balls;
int numberOfBalls = 100;

public void setup() {
  
  balls = new Ball[numberOfBalls];

  for (int i = 0; i < numberOfBalls; ++i) {
   if (random(0,1) < 0.5f) {
     balls[i] = new Ball();
   } else {
     balls[i] = new Apple();
   }
  }
}

public void draw() {
  background(0);
  for (int i = 0; i < numberOfBalls; ++i) {
    for (int j = i + 1; j < numberOfBalls; ++j) {
      boolean hasCollided = collision(
                              balls[i].position.x,
                              balls[i].position.y,
                              balls[i].size / 2,
                              balls[j].position.x,
                              balls[j].position.y,
                              balls[j].size / 2);
      if (hasCollided) {
        balls[i].velocity.x = 0;
        balls[j].velocity.x = 0;
        balls[i].velocity.y = 0;
        balls[j].velocity.y = 0;
      }
    }
   balls[i].update();
  }
  for (int i = 0; i < numberOfBalls; ++i) {
   balls[i].draw();
  }
}
class Apple extends Ball {


  public Apple () {
    super();
  }

  public Apple (int x, int y) {
    super(x, y);
  }

  public void draw() {
    fill(255, 0, 0);
    super.draw();
  }
}
class Ball {
  PVector position;
  PVector velocity;
  int size;

  public Ball () {
    position = new PVector();
    position.x = random(0, width);
    position.y = random(0, height);

    velocity = new PVector();
    velocity.x = random(10) - 5;
    velocity.y = random(10) - 5;
  }

  public Ball (int x, int y) {
    position = new PVector(x, y);

    velocity = new PVector();
    velocity.x = random(10) - 5;
    velocity.y = random(10) - 5;
  }

  public void update() {
    position.x += velocity.x;
    position.y += velocity.y;

    if (position.x > width  || position.x < 0) {
      velocity.x *= -1;
    }
    if (position.y > height || position.y < 0) {
      velocity.y *= -1;
    }
  }

  public void draw() {
    ellipse(position.x - size / 2,position.y - size / 2, size, size);
  }
}
public boolean collision(float x1, float y1, int size1, float x2, float y2, int size2) {

  float maxDistance = size1 + size2;

  if (abs(x1 - x2) >= maxDistance || abs(y1 - y2) >= maxDistance) {
    return false;
  } else if (dist(x1, y1, x2, y2) > maxDistance) {
    return false;
  } else {
    return true;
  }
}
  public void settings() {  size(512, 512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ClassDemo" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
