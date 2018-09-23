class Ball {
  PVector position;
  PVector velocity;
  int size;

  public Ball () {
    position = new PVector();
    position.x = random(0, width);
    position.y = random(0, height);

    velocity = new PVector();
    velocity.x = random(10) - 5;
    velocity.y = random(10) - 5;
  }

  public Ball (int x, int y) {
    position = new PVector(x, y);

    velocity = new PVector();
    velocity.x = random(10) - 5;
    velocity.y = random(10) - 5;
  }

  void update() {
    position.x += velocity.x;
    position.y += velocity.y;

    if (position.x > width  || position.x < 0) {
      velocity.x *= -1;
    }
    if (position.y > height || position.y < 0) {
      velocity.y *= -1;
    }
  }

  void draw() {
    ellipse(position.x - size / 2,position.y - size / 2, size, size);
  }
}
