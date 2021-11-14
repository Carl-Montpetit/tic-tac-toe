package game;

/**
 * Player class that define objects player of the tic-tac-toe game program
 */
public class Player {

  // Fields of the objets of type Player
  private String name;
  private char symbol;
  private int score;
  private boolean firstPlayer;

  // Default constructor for Player objects
  public Player() {
    this.name = "";
    this.symbol = ' ';
    this.score = 0;
    this.firstPlayer = false;
  }

  // Constructor of an object of type Player
  public Player(String name, char symbol, int score, boolean firstPlayer) {
    this.name = name;
    this.symbol = symbol;
    this.score = score;
    this.firstPlayer = firstPlayer;
  }

  //----------------------------------------------------------------------------
  // Functions for objects of type Player ⬇︎
  //----------------------------------------------------------------------------
  /**
   * Validate the name format for a player
   * @param name : the name of the player
   * @return true if the name format is valid, false otherwise
   */
  public boolean validateName(String name) {
    boolean valid = true;
    for (int i = 0; i < name.length(); i++) {
      if (
        !(
          (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') ||
          (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') &&
          (name.length() <= 20)
        )
      ) {
        valid = false;
        break;
      }
    }
    return valid;
  }

  /**
   * Validate if char is X or x or O or o for the symbol
   * @param symbol : Symbol used for the game
   * @return true if the symbol is X or x or O or o, false otherwise
   */
  public boolean validateSymbol(char symbol) {
    boolean valid = true;
    if (!(symbol == 'X' || symbol == 'x' || symbol == 'O' || symbol == 'o')) {
      valid = false;
    }
    return valid;
  }

  /**
   * Return the name of the Player
   * @return name : the name of the player
   */
  public String getName() {
    return this.name;
  }

  /**
   * Update the field name of an objet player
   * @param newName : New name of the player
   */
  public boolean setName(String newName) {
      boolean valid = true;
      if (validateName(newName)) {
          this.name = newName;
      } else {
          System.err.println("Error, please enter a valid name!");
          valid = false;
      }
    return valid;
  }

  /**
   * Return the symbol used by the Player
   * @return symbol : 'X' or 'O'
   */
  public char getSymbol() {
    return this.symbol;
  }

  /**
   * Set the new symbol for the Player
   * @param newSymbol : 'X' or 'x' or 'O' or 'o'
   */
  public void setSymbol(char newSymbol) {
    if (validateSymbol(newSymbol)) {
      if (newSymbol == 'X' || newSymbol == 'x') {
        this.symbol = 'X';
      } else if (newSymbol == 'O' || newSymbol == 'o') {
        this.symbol = 'O';
      }
    } else {
      System.err.println("Error, please enter a valid symbol!");
    }
  }

  /**
   * Return the current score of the Player
   * @return score : the score of the Player
   */
  public int getScore() {
    return this.score;
  }

  /**
   * Update the score of the player
   * @param newScore
   */
  public void setScore() {
    this.score++;
  }

  /**
   * Return true if the Player have been chosen to be the first to play
   * @return true : If the Player as been chosen to be the first to play
   *         false : Otherwise
   */
  public boolean getFirstPlayer() {
    return this.firstPlayer;
  }

  /**
   * Change the state if the player play first or second
   * @param newState : true to set the Player to be the first to play
   *                   false otherwise
   */
  public void setFirstPlayer() {
    this.firstPlayer = !this.firstPlayer;
  }
}
