package model;

import org.junit.Test;
import org.junit.Assert;

import model.Brick;
import model.Position;



public class BrickTest {
  @Test
  public void testBrickCreation() {
    Position position = new Position(0, 0);
    Brick brick = new Brick(position);

    Assert.assertEquals(position, brick.getPosition());
    Assert.assertFalse(brick.isDestroyed());
  }

  @Test
  public void testBrickDestroy() {
    Position position = new Position(0, 0);
    Brick brick = new Brick(position);

    brick.destroy();
    Assert.assertTrue(brick.isDestroyed());
  }
}
