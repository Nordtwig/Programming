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

public class straightParabola extends PApplet {

int lineDistance = 10;

public void setup() {
  
}

public void draw() {
  background(0);
  for (int i = 0; i < width; i += lineDistance) {
    line(0, i, i, height);
    if (i % 3 == 0) {
      stroke(255, 0, 0);
    } else {
      stroke(0, 255, 255);
    }
  }
}
public class parabolaConstructor {
  public void createParabola () {
    
  }
}
  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "straightParabola" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
