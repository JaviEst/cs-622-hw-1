package model;

/*
 * The Position class implements a position object to allow all game objects to
 * simply track their position on a 2D board (x, y).
 */
public class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
  
  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }
}
