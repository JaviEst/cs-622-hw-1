package model;

import org.junit.Test;
import org.junit.Assert;

import model.Position;
import model.Paddle;



public class PaddleTest {
  @Test
  public void testPaddleCreation() {
    Position position = new Position(0, 0);
    Paddle paddle = new Paddle(position);

    Assert.assertEquals(position, paddle.getPosition());
  }

  @Test
  public void testPaddleMoveLeft() {
    Position position = new Position(0, 0);
    Paddle paddle = new Paddle(position);

    paddle.moveLeft();
    Assert.assertEquals(paddle.getPosition().getX(), -1);
    Assert.assertEquals(paddle.getPosition().getY(), 0);
  }

  @Test
  public void testPaddleMoveRight() {
    Position position = new Position(0, 0);
    Paddle paddle = new Paddle(position);

    paddle.moveRight();
    Assert.assertEquals(paddle.getPosition().getX(), 1);
    Assert.assertEquals(paddle.getPosition().getY(), 0);
  }
}