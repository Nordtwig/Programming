int scanLineDist = 10;
int frames = 0;

void setup() {
  size(640, 480);
  stroke(128, 128, 128, 75);
  strokeWeight(5);
}

void draw() {
  background(0);

  for (int i = 0; i < height; i += scanLineDist) {
    line(0, i + frames % scanLineDist, width, i + frames % scanLineDist);
  }

  frames++;
}
