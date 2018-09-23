int lineDistance = 10;

void setup() {
  size(600, 600);
}

void draw() {
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

void createParabola (int xOrigin, int yPos, int xEnding, int lineDistance) {

}
