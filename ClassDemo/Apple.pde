class Apple extends Ball {


  public Apple () {
    super();
  }

  public Apple (int x, int y) {
    super(x, y);
  }

  void draw() {
    fill(255, 0, 0);
    super.draw();
  }
}
