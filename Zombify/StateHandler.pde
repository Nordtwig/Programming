class StateHandler {
  int gameState;

  public StateHandler () {

  }

  void initScreen() {
    actualTime = millis();
    background(0);
    textSize(32);
    textAlign(CENTER);
    fill(123,153,105);
    text("Zombify", width / 2, height / 2 - 20);
    fill(255);
    textSize(15);
    text("Click to Continue", width / 2, height / 2 + 10);
  }

  void gameScreen() {
    currentTime = millis() - actualTime;
    background(128);
    manager.collisionHandler();
    manager.draw();
    if (manager.humanCount <= 0) {
      gameState = 2;
    }
  }

  void endScreen() {
    background(0);
    textSize(32);
    textAlign(CENTER);
    fill(123,153,105);
    text("Game Over!", width / 2, height / 2 - 30);
    fill(255);
    textSize(15);
    text("It took " + round(currentTime * 0.001f) + " seconds for all humans to get infected.", width / 2, height / 2 );
    text("Click to Restart", width / 2, height / 2 + 25);
  }
}
