class Human extends Character {
  int[] colors;

  public Human (float s) {
    super(s);
    colors = new int[4];
    colors[0] = color(234, 189, 157);
    colors[1] = color(217, 145, 100);
    colors[2] = color(56, 0, 0);
    colors[3] = color(226, 185, 143);

    skinColor = colors[int(random(0, colors.length))];
  }
}
