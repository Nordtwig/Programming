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

public class trigTest extends PApplet {

int numberOfLines = 32;

public void setup () {
  
}

public void draw() {
  background(255);
  lineCord xAxis = new lineCord(100, 10, 5, 420);
  lineCord yAxis = new lineCord(5, 420, 600, 300);

  drawCurve(xAxis, yAxis);
}

public void drawCurve(lineCord xAxis, lineCord yAxis) {
  stroke(1);
  for (int i = 0; i < numberOfLines; ++i) {

    if (i % 3 == 0) {
      stroke(0);
    } else {
      stroke(128);
    }

    float lineX1 = xAxis.x1 + (i * (xAxis.x2 - xAxis.x1) / numberOfLines);
    float lineY1 = xAxis.y1 + (i * (xAxis.y2 - xAxis.y1) / numberOfLines);

    float lineX2 = yAxis.x1 + (i * (yAxis.x2 - yAxis.x1) / numberOfLines);
    float lineY2 = yAxis.y1 + (i * (yAxis.y2 - yAxis.y1) / numberOfLines);

    line(lineX1, lineY1, lineX2, lineY2);
  }

  stroke(0);
  strokeWeight(3);

  line(xAxis.x1, xAxis.y1, xAxis.x2, xAxis.y2);
  line(yAxis.x1, yAxis.y1, yAxis.x2, yAxis.y2);

}

class lineCord {
  float x1;
  float y1;
  float x2;
  float y2;

  lineCord(float x1, float y1, float x2, float y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
}
  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "trigTest" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
