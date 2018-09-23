CharacterManager manager;
StateHandler stateHandler;

int gameState;
float actualTime;
float currentTime;

int maxHumans = 100;

void setup() {
  size(600, 600);

  stateHandler = new StateHandler();
  stateHandler.gameState = 0;

  manager = new CharacterManager(maxHumans);
  manager.populate();
}

void draw() {
  if (stateHandler.gameState == 0) {
    stateHandler.initScreen();
  } else if (stateHandler.gameState == 1) {
    stateHandler.gameScreen();
  } else {
    stateHandler.endScreen();
  }
}

void mousePressed() {
  if (stateHandler.gameState == 0) {
    stateHandler.gameState = 1;
  } else if (stateHandler.gameState == 2) {
    resetGame();
  }
}

void resetGame() {
  currentTime = 0;
  manager.populate();
  stateHandler.gameState = 0;
}
