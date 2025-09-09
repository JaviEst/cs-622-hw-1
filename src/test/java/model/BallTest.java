package model;

import org.junit.Test;
import org.junit.Assert;

import model.Position;
import model.Ball;



public class BallTest {
  @Test
  public void testBallCreation() {
    Position position = new Position(0, 0);
    Ball ball = new Ball(position);

    Assert.assertEquals(position, ball.getPosition());
  }

  @Test
  public void testBallUpdatePos() {
    Position position = new Position(1, 1);
    Ball ball = new Ball(position);

    ball.updatePos();
    Assert.assertEquals(ball.getPosition().getX(), 2);
    Assert.assertEquals(ball.getPosition().getY(), 2);
  }
}