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

public class Intro extends PApplet {

int scanLineDist = 10;
int frames = 0;

public void setup() {
  
  stroke(128, 128, 128, 75);
  strokeWeight(5);
}

public void draw() {
  background(0);

  for (int i = 0; i < height; i += scanLineDist) {
    line(0, i + frames % scanLineDist, width, i + frames % scanLineDist);
  }

  frames++;
}
  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Intro" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
