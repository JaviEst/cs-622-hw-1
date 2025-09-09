package model;

import model.GameObject;
import model.Position;

/*
 * Paddle is a game object moved by the user. Therefore, the position is only
 * updated as part of the game when the user moves right or left. In order to allow
 * the paddle to move right or left, the paddle class provides a moveLeft and
 * moveRight methods. However, it does not provide moveUp or moveDown as one can
 * not move the paddle accross the y axis.
 */
public class Paddle extends GameObject {

  public Paddle(Position position) {
    super(position);
  }

  @Override
  public void render() {
    System.out.println("Paddle at position: " + position.getX() + ", " + position.getY());
  }

  public void moveLeft() {
    position.setX(position.getX() - 1);
  }

  public void moveRight() {
    position.setX(position.getX() + 1);
  }
}
