package edu.grinnell.csc207;

import edu.grinnell.csc207.util.Direction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Class containing the logic of the game. This class
 * manipulates a provided Board
 */
public class GameLogic extends JFrame implements KeyListener, ActionListener {

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
  // public GameLogic(Board gameBoard) {
  //   board = gameBoard;
  //   headingDir = Direction.RIGHT;
  // }

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

  public GameLogic() {
    this.board = new Board(5); // replace with new size
    this.headingDir = Direction.RIGHT;

    Timer timer = new Timer(150, this);
    timer.start();

    java.util.Timer drawBoard = new java.util.Timer();
    drawBoard.schedule(this.board, 0, 3000);

    setTitle("Snake Game");
    setSize(5 * 25, 5 * 25); // replace with value from user
    this.addKeyListener(this);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } // Main()

  @Override
  public void keyTyped(KeyEvent e) {
    // null
  } // keyTyped(KeyEvent)

  @Override
  public void keyReleased(KeyEvent e) {
    // null
  } // keyReleased(KeyEvent)

  @Override
  public void keyPressed(KeyEvent e) {
    int c = e.getKeyCode();

    if (c == 39 && !this.headingDir.equals(Direction.LEFT)) {
      this.headingDir = Direction.RIGHT;
    } else if (c == 37 && !this.headingDir.equals(Direction.RIGHT)) {
      this.headingDir = Direction.LEFT;
    } else if (c == 38 && !this.headingDir.equals(Direction.DOWN)) {
      this.headingDir = Direction.UP;
    } else if (c == 40 && !this.headingDir.equals(Direction.UP)) {
      this.headingDir = Direction.DOWN;
    } // if-else
  } // keyPressed(KeyEvent)

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  } // actionPerformed(ActionEvent)

  public static void main(String[] args) {
    EventQueue.invokeLater(GameLogic::new);
  } // main(String[])
}
