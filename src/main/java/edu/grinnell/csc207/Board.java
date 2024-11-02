package edu.grinnell.csc207;

import edu.grinnell.csc207.util.CoordinateOutOfBoundsException;
import edu.grinnell.csc207.util.MatrixV0;
import java.util.Random;

/**
 * Game board for snake game, storing the state of the game.
 *
 * @author Grant Sackmann
 * @author Sarah Deschamps
 */
public class Board {
//  Fields
  /**
   * 2d array of chars encoding state of game for animation. Char States: 'E' - empty 'B' - body of
   * snake 'H' - head of snake 'T' - tail of snake 'A' - apple
   */
  MatrixV0<Character> gameBoard;
  /**
   * Boolean for whether player has lost/died.
   */
  Boolean isAlive;
  /**
   * Coordinates for the head of snake.
   */
  int headX, headY;
  /**
   * Coordinates for the tail of snake.
   */
  int tailX, tailY;
  /**
   * The size of game board.
   */
  int size;
  /**
   * Count of number of apples eaten.
   */
  int score;
  /**
   * Random object for spawning apples.
   */
  Random rand;

  //  Constructors
  public Board(int n) {
    this.size = n;
    this.gameBoard = new MatrixV0<>(this.size, this.size, 'E');
    try {
      setHead(n / 2, n / 2);
      setTail(n / 2 - 1, n / 2);
    } catch (Exception e) {
      // do nothing
    } // try-catch
    this.isAlive = true;
    score = 0;
    rand = new Random();
  } // Board()

//  Methods

  /**
   * Sets the coordinate of the snake head.
   *
   * @param x x value of coordinate
   * @param y y value of coordinate
   * @throws Exception Coordinate out of bounds
   */
  public void setHead(int x, int y) throws Exception {
    if (x < size && y < size) {
      this.headX = x;
      this.headY = y;
    } else {
      throw new CoordinateOutOfBoundsException();
    } // if
  } // setHead()

  /**
   * Sets the coordinate of the snake tail.
   *
   * @param x x value of coordinate
   * @param y y value of coordinate
   * @throws Exception Coordinate out of bounds
   */
  public void setTail(int x, int y) throws Exception {
    if (x < size && y < size) {
      this.tailX = x;
      this.tailY = y;
    } else {
      throw new CoordinateOutOfBoundsException();
    } // if
  } // setTail()

  /**
   * Getter for the snake head coordinate.
   *
   * @return int array containing x and y coordinates
   */
  public int[] getHead() {
    return new int[]{this.headX, this.headY};
  } // getHead()

  /**
   * Getter for ths snake tail coordinate.
   *
   * @return int array containing x and y coordinates
   */
  public int[] getTail() {
    return new int[]{this.tailX, this.tailY};
  } // getTail()

  /**
   * Spawns a new apple on game board.
   */
  public void newApple() {
    int x = rand.nextInt(size);
    int y = rand.nextInt(size);
    while (!isEmptyCoord(x, y)) {
      x = rand.nextInt(size);
      y = rand.nextInt(size);
    } // while
    gameBoard.set(x, y, 'A');
  } // newApple()

  /**
   * Checks if the provided coordinate is an empty space.
   *
   * @param x x value of coordinate
   * @param y y value of coordinate
   * @return whether the coordinate is an empty space on game borad.
   */
  private boolean isEmptyCoord(int x, int y) {
    return this.gameBoard.get(x, y) == 'E';
  } // isEmptyCoord()

  /**
   * Sets the game status to end of game.
   */
  public void lostGame() {
    isAlive = false;
  } // lostGame()
} // Board Class
