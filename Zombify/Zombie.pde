class Zombie extends Character {
  float speedFactor = 0.5;

  public Zombie  (float x, float y, float s) {
    super(s);
    position.x = x;
    position.y = y;
    skinColor = color(123,153,105);
    velocity.x *= speedFactor;
    velocity.y *= speedFactor;
  }
}
