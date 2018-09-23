float posX;
float posY;

float v = 5;
float direction = 0;

void setup() {
  size(800, 600);
  posX = width / 2;
  posY = height / 2;
}

void draw() {
  background(255);
  
  float dX = (float) (Math.cos(direction)) * v;
  float dY = (float) (Math.sin(direction)) * v;
  
  posX += dX;
  posY -= dY;
  
  ellipse(posX, posY, 10, 10);
}
