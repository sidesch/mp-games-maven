package edu.grinnell.csc207;

import edu.grinnell.csc207.util.Direction;

/**
 * Class containing the logic of the game. This class
 * manipulates a provided Board
 */
public class GameLogic {

  /**
   * The current direction of travel for the snake.
   */
  Direction headingDir;

  /**
   * The game Board storing state of game
   */
  Board board;

  /**
   * GameLogic constructor.
   * @param gameBoard Board to be acted on using logic of game.
   */
  public GameLogic(Board gameBoard) {
    board = gameBoard;
    headingDir = Direction.RIGHT;
  }

  /**
   * Changes the heading of the snake.
   * @param dir Direction the snake's head will be set to
   */
  public void setDir(Direction dir) {
    switch (dir) {
      case UP:
        headingDir = Direction.UP;
        break;
      case DOWN:
        headingDir = Direction.DOWN;
        break;
      case LEFT:
        headingDir = Direction.LEFT;
        break;
      case RIGHT:
        headingDir = Direction.UP;
        break;
      default:
        break;
    }
  }


//
}
