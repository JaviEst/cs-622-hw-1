package model;

import model.GameObject;
import model.Position;

/*
 * Brick is a game object that does not move but can be destroyed.
 * Therefore, it needs a destroyed field for the game to know if the brick has been
 * destoyed and therefore act as if it was not in play.
 */
public class Brick extends GameObject {
  private boolean destroyed = false;

  public Brick(Position position) {
    super(position);
  }

  @Override
  public void render() {
    if (!isDestroyed()) {
      System.out.println("Brick at position: " + position.getX() + ", " + position.getY());
    }
  }

  public void destroy() {
    destroyed = true;
  }

  public boolean isDestroyed() {
    return destroyed;
  }
}
