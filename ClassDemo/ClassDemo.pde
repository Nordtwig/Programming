Ball[] balls;
int numberOfBalls = 100;

void setup() {
  size(512, 512);
  balls = new Ball[numberOfBalls];

  for (int i = 0; i < numberOfBalls; ++i) {
   if (random(0,1) < 0.5) {
     balls[i] = new Ball();
   } else {
     balls[i] = new Apple();
   }
  }
}

void draw() {
  background(0);
  for (int i = 0; i < numberOfBalls; ++i) {
    for (int j = i + 1; j < numberOfBalls; ++j) {
      boolean hasCollided = collision(
                              balls[i].position.x,
                              balls[i].position.y,
                              balls[i].size / 2,
                              balls[j].position.x,
                              balls[j].position.y,
                              balls[j].size / 2);
      if (hasCollided) {
        balls[i].size = 0;
        balls[j].size = 0;
      }
    }
   balls[i].update();
  }
  for (int i = 0; i < numberOfBalls; ++i) {
   balls[i].draw();
  }
}
