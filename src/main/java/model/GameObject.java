package model;

import model.Position;

/*
 * The GameObject class is an abstraction for the different objects the game has.
 * It still provides a common background like the position of each object.
 */
public abstract class GameObject {
  protected Position position;

  public GameObject(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public abstract void render();   
}
