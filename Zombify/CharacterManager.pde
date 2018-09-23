class CharacterManager {
  ArrayList<Character> characters;
  int humanCount = 0;
  float size;

  public CharacterManager (int h) {
    int maxHumans = h;
    size = random(12, 35);
    characters = new ArrayList<Character>();
  }

  void populate() {
    characters.clear();
    for (int i = 0; i < maxHumans; i++) {
     size = random(12, 35);
     characters.add(new Human(size));
     humanCount++;
    }
    characters.add(new Zombie(width / 2, height / 2, size));
  }

  void collisionHandler() {
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
                humanCount--;
              }
            }
          }
        }
      }
    }
  }

  void draw() {
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
