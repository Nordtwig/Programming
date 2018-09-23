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

public class Trigonometry extends PApplet {

int frame = 0;
float multiplier = 0.002f;
int numberOfPoints = 320;

public void setup()
{
  
  strokeWeight(5);
}

public void draw()
{
  translate(0,height / 2);
  background(255);

  for (float angle = 0.0f; angle < PI * 2; angle += .01f) {
    float x = angle * 100,
          y = -sin(angle) * 100;
    float x2 = angle * 100,
          y2 = cos(angle) * 100;
    float x3 = angle * 100,
          y3 = tan(angle) * 100;
    if (frame == 50) {
      point(x, y);
      point(x2, y2);
      point(x3, y3);
      frame = 0;
    }
    frame++;
  }
}
  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Trigonometry" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
