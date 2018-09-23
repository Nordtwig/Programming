PVector location = new PVector(0, 0);
PVector prevLocation = new PVector(0, 0);
float speed = 1;
float easing = 0.05;
float circleX;
float circleRadius = 24;
float xSpeed = 2;
float currentSpeed;

void setup() {
  size(500,500);
  smooth();
  noStroke();
  fill(0);
  circleX = 0;
  currentSpeed = xSpeed;
}

void draw() {
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
