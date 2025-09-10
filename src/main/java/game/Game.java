package game;

import java.util.ArrayList;
import java.util.Scanner;

import model.Ball;
import model.Brick;
import model.GameObject;
import model.Paddle;
import model.Position;


/*
 * The game class implements a simplified version of the breakout arcade game.
 * It uses the models defined in the package model to allow the user to play
 * the game.
 */
public class Game {
  public static final int NUM_BRICKS_DEFAULT = 10;
  private String playerName;

  private ArrayList<GameObject> objects = new ArrayList<>();
  private Ball ball;
  private Paddle paddle;
  private ArrayList<Brick> bricks = new ArrayList<>();

  public Game() {
    this.ball = new Ball(new Position(5, 1));
    this.paddle = new Paddle(new Position(5, 0));
  }

  private void addObject(GameObject... objs) {
    for (GameObject obj : objs) {
      objects.add(obj);
    }
  }

  private String addObject(String name, GameObject... objs) {
    this.playerName = name;
    for (GameObject obj : objs) {
      objects.add(obj);
    }
    return name;
  }

  public void play() {
    String userInput = null;
    Scanner nameScanner = new Scanner(System.in);
    if (playerName == null) {
      System.out.println("What is your name? ");
      userInput = nameScanner.nextLine();
    }

    if (userInput != null) {
      addObject(userInput, ball, paddle);
    } else {
      addObject(ball, paddle);
    }

    for (int i = 0; i < NUM_BRICKS_DEFAULT; i++) {
      Brick brick = new Brick(new Position(i, 9));
      bricks.add(brick);
      addObject(brick);
    }
    Scanner scanner = new Scanner(System.in);

    while (true) {
      ball.updatePos();
      for (GameObject obj : objects) {
        obj.render();
      }

      for (Brick brick : bricks) {
        if (!brick.isDestroyed()
            && brick.getPosition().getX() == ball.getPosition().getX()
            && brick.getPosition().getY() == ball.getPosition().getY()) {

          brick.destroy();
          ball.bounce();
          System.out.println("Brick destroyed!!");
        }
      }

      if (paddle.getPosition().getX() == ball.getPosition().getX()
          && paddle.getPosition().getY() == ball.getPosition().getY()) {

        ball.bounce();
      }

      System.out.println("Move paddle (a=left, d=right, enter=stay): ");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("a")) {
        paddle.moveLeft();
      } else if (input.equalsIgnoreCase("d")) {
        paddle.moveRight();
      }

      // Game win check
      boolean allDestroyed = true;
      for (Brick brick : bricks) {
        if (!brick.isDestroyed()) {
          allDestroyed = false;
          break;
        }
      }
      if (allDestroyed) {
        System.out.println("All bricks have been destroyed! You win!");
        break;
      }

      // Game over check
      if (ball.getPosition().getY() < 0) {
        System.out.println("Game Over! \nPlay again? Yes / No");
        String replay = scanner.nextLine();
        if (replay.equalsIgnoreCase("yes")) {
          // Resetting the game
          this.bricks.clear();
          this.objects.clear();
          this.ball = new Ball(new Position(5, 1));
          this.paddle = new Paddle(new Position(5, 0));
          System.out.println("Here we go again, " + playerName);
          play();
        }
        break;
      }

    }
    nameScanner.close();
    scanner.close();
  }
}
