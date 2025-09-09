package model;

import model.GameObject;
import model.Position;

/*
 * Ball is a game object that moves depending on bouncing against a brick,
 * the paddle or walls. The position is updated based on the speed the ball
 * travels at as well as the direction the ball is traveling.
 * Finally, the ball needs to be able to bounce when it hits a brick.
 */
public class Ball extends GameObject {
  private int dx = 1;
  private int dy = 1;

  public Ball(Position position) {
    super(position);
  }

  public void updatePos() {
    position.setX(position.getX() + dx);
    position.setY(position.getY() + dy);

    // Bounce on walls inverts the speed of the ball.
    if (position.getX() <= 0 || position.getX() >= 10) {
      this.dx = -dx;
    }
    if (position.getY() >= 10) {
      this.dy = -dy;
    }
  }

  @Override
  public void render() {
    System.out.println("Ball at position: " + position.getX() + ", " + position.getY());
  }

  public void bounce() {
    this.dy = -dy;
  }
}
