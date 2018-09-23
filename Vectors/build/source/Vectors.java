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

public class Vectors extends PApplet {

PVector location = new PVector(0, 0);
PVector prevLocation = new PVector(0, 0);
float speed = 1;
float easing = 0.05f;
float circleX;
float circleRadius = 24;
float xSpeed = 2;
float currentSpeed;

public void setup() {
  
  
  noStroke();
  fill(0);
  circleX = 0;
  currentSpeed = xSpeed;
}

public void draw() {
  background(255);

  ellipse(circleX, 180, circleRadius, circleRadius);
    circleX = circleX + currentSpeed;

    if (circleX >= width - (circleRadius / 2)) {
      currentSpeed = -xSpeed;
    } else if (circleX <= 0 + (circleRadius / 2)) {
      currentSpeed = xSpeed;
    }

  location.x = (speed-easing) * prevLocation.x + easing * mouseX;
  location.y = (speed-easing) * prevLocation.y + easing * mouseY;

  ellipse(location.x,location.y,50,50);

  prevLocation.x = location.x;
  prevLocation.y = location.y;
}
  public void settings() {  size(500,500);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Vectors" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
