package edu.grinnell.csc207.util;

/**
 * Thrown to indicate that the coord provided is not valid for array dimension.
 */
public class CoordinateOutOfBoundsException extends Exception {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new exception with default message.
   */
  public CoordinateOutOfBoundsException() {
    super("Invalid coordinate");
  }

  /**
   * Build a new exception with custom message.
   */
  public CoordinateOutOfBoundsException(String message) {
    super(message);
  }
}
