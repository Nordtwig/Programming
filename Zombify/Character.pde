class Character {
  PVector position;
  PVector velocity;
  float size;
  int skinColor;

  public Character (float s) {
    position = new PVector(random(0, width), random(0, height));
    velocity = new PVector();
    size = s;

    velocity.x = random(-3, 3);
    velocity.y = random(-3, 3);
  }

  void show() {
    fill(skinColor);
    ellipse(position.x, position.y, size, size);
  }

  void move() {
    position.x += velocity.x;
    position.y += velocity.y;

    if (position.x > width || position.x < 0) {
      // velocity.x *= -1;
     if (position.x > width + (size / 2)) {
       position.x = 0 - (size / 2);
     } else if (position.x < 0 - (size / 2)) {
       position.x = width + (size / 2);
     }
    }
    if (position.y > height - (size / 2) || position.y < 0 + (size / 2)) {
      // velocity.y *= -1;
      if (position.y > height + (size / 2)) {
        position.y = 0 - (size / 2);
      } else if (position.y < 0 - (size / 2)) {
        position.y = height + (size / 2);
      }
    }
  }
}
