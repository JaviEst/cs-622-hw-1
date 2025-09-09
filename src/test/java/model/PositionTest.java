package model;

import org.junit.Test;
import org.junit.Assert;

import model.Position;



public class PositionTest {
  @Test
  public void testCreateAndGetPosition() {
    Position position = new Position(0, 0);

    Assert.assertEquals(position.getX(), 0);
    Assert.assertEquals(position.getY(), 0);
  }

  @Test
  public void testSetPosition() {
    Position position = new Position(0, 0);

    int newXPos = 10;
    int newYPos = 5;
    position.setX(newXPos);
    position.setY(newYPos);

    Assert.assertEquals(position.getX(), newXPos);
    Assert.assertEquals(position.getY(), newYPos);
  }
}