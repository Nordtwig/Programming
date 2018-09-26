import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Zombify extends PApplet {

CharacterManager manager;
StateHandler stateHandler;

int gameState;
float actualTime;
float currentTime;

int maxHumans = 100;

public void setup() {
  

  stateHandler = new StateHandler();
  stateHandler.gameState = 0;

  manager = new CharacterManager(maxHumans);
  manager.populate();
}

public void draw() {
  if (stateHandler.gameState == 0) {
    stateHandler.initScreen();
  } else if (stateHandler.gameState == 1) {
    stateHandler.gameScreen();
  } else {
    stateHandler.endScreen();
  }
}

public void mousePressed() {
  if (stateHandler.gameState == 0) {
    stateHandler.gameState = 1;
  } else if (stateHandler.gameState == 2) {
    resetGame();
  }
}

public void resetGame() {
  currentTime = 0;
  manager.populate();
  stateHandler.gameState = 0;
}
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

  public void show() {
    fill(skinColor);
    ellipse(position.x, position.y, size, size);
  }

  public void move() {
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
class CharacterManager {
  ArrayList<Character> characters;
  int humanCount = 0;
  float size;

  public CharacterManager (int h) {
    int maxHumans = h;
    size = random(12, 35);
    characters = new ArrayList<Character>();
  }

  public void populate() {
    characters.clear();
    for (int i = 0; i < maxHumans; i++) {
     size = random(12, 35);
     characters.add(new Human(size));
     humanCount++;
    }
    characters.add(new Zombie(width / 2, height / 2, size));
  }

  public void collisionHandler() {
    for (int i = 0; i < characters.size(); ++i) {
      if (characters.get(i) instanceof Human) {
        Human human = (Human)characters.get(i);
        for (int j = 0; j < characters.size(); j++) {
          if (characters.get(j) instanceof Zombie) {
            Zombie zombie = (Zombie)characters.get(j);
            boolean hasCollided = collision(human.position.x,
                                            human.position.y,
                                            human.size / 2,
                                            zombie.position.x,
                                            zombie.position.y,
                                            zombie.size / 2);
            if (hasCollided) {
              if (human.size > 0) {
                characters.add(new Zombie(human.position.x, human.position.y, human.size));
                human.size = 0;
                // characters.remove(characters.get(i));
                humanCount--;
              }
            }
          }
        }
      }
    }
  }

  public void draw() {
    for (int i = 0; i < characters.size(); i++) {
      if (characters.get(i) instanceof Human) {
        Human human = (Human)characters.get(i);
        human.move();
        human.show();
      } else if (characters.get(i) instanceof Zombie) {
        Zombie zombie = (Zombie)characters.get(i);
        zombie.show();
        zombie.move();
      }
    }
  }
}
public boolean collision(float x1, float y1, float size1, float x2, float y2, float size2) {

  float maxDistance = size1 + size2;

  if (abs(x1 - x2) >= maxDistance || abs(y1 - y2) >= maxDistance) {
    return false;
  } else if (dist(x1, y1, x2, y2) > maxDistance) {
    return false;
  } else {
    return true;
  }
}
class Human extends Character {
  int[] colors;

  public Human (float s) {
    super(s);
    colors = new int[4];
    colors[0] = color(234, 189, 157);
    colors[1] = color(217, 145, 100);
    colors[2] = color(56, 0, 0);
    colors[3] = color(226, 185, 143);

    skinColor = colors[PApplet.parseInt(random(0, colors.length))];
  }
}
class StateHandler {
  int gameState;

  public StateHandler () {

  }

  public void initScreen() {
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

  public void gameScreen() {
    currentTime = millis() - actualTime;
    background(128);
    manager.collisionHandler();
    manager.draw();
    if (manager.humanCount <= 0) {
      gameState = 2;
    }
  }

  public void endScreen() {
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
class Zombie extends Character {
  float speedFactor = 0.5f;

  public Zombie  (float x, float y, float s) {
    super(s);
    position.x = x;
    position.y = y;
    skinColor = color(123,153,105);
    velocity.x *= speedFactor;
    velocity.y *= speedFactor;
  }
}
  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Zombify" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
