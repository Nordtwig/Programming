int frame = 0;
float multiplier = 0.002;
int numberOfPoints = 320;

void setup()
{
  size(640, 480);
  strokeWeight(5);
}

void draw()
{
  translate(0,height / 2);
  background(255);

  for (float angle = 0.0; angle < PI * 2; angle += .01) {
    float x = angle * 100,
          y = -sin(angle) * 100;
    float x2 = angle * 100,
          y2 = cos(angle) * 100;
    // float x3 = angle * 100,
    //       y3 = tan(angle) * 100;
    if (frame == 50) {
      point(x, y);
      point(x2, y2);
      // point(x3, y3);
      frame = 0;
    }
    frame++;
  }
}
