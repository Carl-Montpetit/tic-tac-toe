package game;

import java.util.Scanner;

/**
 * Main class for tic-tac-toe game program
 */
class Main extends Player {

  //----------------------------------------------------------------------------
  // ★ CONSTANTS ★
  //----------------------------------------------------------------------------
  public static final String MSG_WELCOME = "Welcome to Tic-Tac-Toe game!😀";
  public static final String MSG_INPUT_PROMPT =
    "Please, enter <OK> to start (good option) or enter <QUIT> to exit the game(don't do that)!";
  public static final String MSG_CONFIRMATION = "Thank you, let's play!🤪";
  public static final String MSG_EXIT = "Thank you see you next time!😊";
  public static final String ERR_WRONG_INPUT =
    "Error, please enter the right thing!🙈";
  public static final String LINE1_LINE2_GAME = "___|___|___";
  public static final String LINE3_GAME = "   |   |   ";

  //----------------------------------------------------------------------------
  // MAIN ENTRY OF PROGRAM EXECUTION
  //----------------------------------------------------------------------------
  public static void main(String[] args) {
    //--------------------------------------------------------------------------
    // VARIABLES
    //--------------------------------------------------------------------------
    double random = Math.random();
    Player player1 = new Player();
    Player player2 = new Player();
    Scanner scanner = new Scanner(System.in);
    char[][] gameTab = {
      { '-', '-', '-', '|', '-', '-', '-', '|', '-', '-', '-' },
      { '-', '-', '-', '|', '-', '-', '-', '|', '-', '-', '-' },
      { ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ' },
    };
    boolean gameOn = true;
    //--------------------------------------------------------------------------
    // Before the game start
    //--------------------------------------------------------------------------
    introductionPrompt(scanner);

    System.out.println("Player #1, please enter your name!");
    promptPlayerName(player1, scanner);
    System.out.println("Player #2, please enter your name!");
    promptPlayerName(player2, scanner);

    setTheFirstPlayerToPlay(random, player1, player2);

    if (player1.getFirstPlayer()) {
      setSymbolsForPlayers(player1, player2, scanner);
    } else {
      setSymbolsForPlayers(player2, player1, scanner);
    }

    printPlayersSymbol(player1, player2);
    //--------------------------------------------------------------------------
    // BEGINNING OF THE GAME
    //--------------------------------------------------------------------------
    instructionBeginningOfTheGame();

    while (gameOn) {
      boolean player1Valid = false;
      boolean player2Valid = false;
      boolean player1Win = false;

      while (!player1Valid) {
        System.out.println(
          player1.getName() +
          ", it's your turn to play! Choose the place you want to add your " +
          player1.getSymbol() +
          "!"
        );
        String play1 = scanner.nextLine();

        if (play1.equals("1,1") && gameTab[0][1] == '-') {
          gameTab[0][1] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("1,2") && gameTab[0][5] == '-') {
          gameTab[0][5] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("1,3") && gameTab[0][9] == '-') {
          gameTab[0][9] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("2,1") && gameTab[1][1] == '-') {
          gameTab[1][1] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("2,2") && gameTab[1][5] == '-') {
          gameTab[1][5] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("2,3") && gameTab[1][9] == '-') {
          gameTab[1][9] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("3,1") && gameTab[2][1] == ' ') {
          gameTab[2][1] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("3,2") && gameTab[2][5] == ' ') {
          gameTab[2][5] = player1.getSymbol();
          player1Valid = true;
        } else if (play1.equals("3,3") && gameTab[2][9] == ' ') {
          gameTab[2][9] = player1.getSymbol();
          player1Valid = true;
        } else if (
          (
            gameTab[0][1] == player1.getSymbol() ||
            gameTab[0][1] == player2.getSymbol()
          ) &&
          (
            gameTab[0][5] == player1.getSymbol() ||
            gameTab[0][5] == player2.getSymbol()
          ) &&
          (
            gameTab[0][9] == player1.getSymbol() ||
            gameTab[0][9] == player2.getSymbol()
          ) &&
          (
            gameTab[1][1] == player1.getSymbol() ||
            gameTab[1][1] == player2.getSymbol()
          ) &&
          (
            gameTab[1][5] == player1.getSymbol() ||
            gameTab[1][5] == player2.getSymbol()
          ) &&
          (
            gameTab[1][9] == player1.getSymbol() ||
            gameTab[1][9] == player2.getSymbol()
          ) &&
          (
            gameTab[2][1] == player1.getSymbol() ||
            gameTab[2][1] == player2.getSymbol()
          ) &&
          (
            gameTab[2][5] == player1.getSymbol() ||
            gameTab[2][5] == player2.getSymbol()
          ) &&
          (
            gameTab[2][9] == player1.getSymbol() ||
            gameTab[2][9] == player2.getSymbol()
          )
        ) {
          System.out.println(
            "There's no winner for this round! Let's play another round!"
          );
          gameOn = true;
          player1Win = true;
          gameTab[0][1] = '-';
          gameTab[0][5] = '-';
          gameTab[0][9] = '-';
          gameTab[1][1] = '-';
          gameTab[1][5] = '-';
          gameTab[1][9] = '-';
          gameTab[2][1] = ' ';
          gameTab[2][5] = ' ';
          gameTab[2][9] = ' ';
        } else {
          System.err.println(
            "Error, please enter something that is valid to play your turn!"
          );
          player1Valid = false;
        }
      }

      System.out.print('\n');
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 11; j++) {
          System.out.print(gameTab[i][j]);
        }
        System.out.print("\n");
      }

      if (
        (
          gameTab[0][1] == player1.getSymbol() &&
          gameTab[1][5] == player1.getSymbol() &&
          gameTab[2][9] == player1.getSymbol()
        ) ||
        (
          gameTab[0][1] == player1.getSymbol() &&
          gameTab[0][5] == player1.getSymbol() &&
          gameTab[0][9] == player1.getSymbol()
        ) ||
        (
          gameTab[1][1] == player1.getSymbol() &&
          gameTab[1][5] == player1.getSymbol() &&
          gameTab[1][9] == player1.getSymbol()
        ) ||
        (
          gameTab[2][1] == player1.getSymbol() &&
          gameTab[2][5] == player1.getSymbol() &&
          gameTab[2][9] == player1.getSymbol()
        ) ||
        (
          gameTab[0][1] == player1.getSymbol() &&
          gameTab[1][1] == player1.getSymbol() &&
          gameTab[2][1] == player1.getSymbol()
        ) ||
        (
          gameTab[0][5] == player1.getSymbol() &&
          gameTab[1][5] == player1.getSymbol() &&
          gameTab[2][5] == player1.getSymbol()
        ) ||
        (
          gameTab[0][9] == player1.getSymbol() &&
          gameTab[1][9] == player1.getSymbol() &&
          gameTab[2][9] == player1.getSymbol()
        ) ||
        (
          gameTab[0][9] == player1.getSymbol() &&
          gameTab[1][5] == player1.getSymbol() &&
          gameTab[2][1] == player1.getSymbol()
        )
      ) {
        player1.setScore();
        System.out.println(
          "Congrats " + player1.getName() + " you won this round!"
        );
        gameOn = false;
        player1Win = true;
        gameTab[0][1] = '-';
        gameTab[0][5] = '-';
        gameTab[0][9] = '-';
        gameTab[1][1] = '-';
        gameTab[1][5] = '-';
        gameTab[1][9] = '-';
        gameTab[2][1] = ' ';
        gameTab[2][5] = ' ';
        gameTab[2][9] = ' ';
        boolean valid1 = false;
        while (!valid1) {
          System.out.println("Do you want to play another round? (enter Y/N)");
          String confirmation = scanner.nextLine();
          char confirm = confirmation.charAt(0);
          if (confirm == 'Y' || confirm == 'y') {
            gameOn = true;
            valid1 = true;
          } else if (confirm == 'N' || confirm == 'n') {
            gameOn = false;
            valid1 = true;
          } else {
            System.err.println("Error, please enter Y or N!");
          }
        }
      }

      if (!player1Win) {
        while (!player2Valid) {
          System.out.println(
            player2.getName() +
            ", it's your turn to play! Choose the place you want to add your " +
            player2.getSymbol() +
            "!"
          );
          String play2 = scanner.nextLine();

          if (play2.equals("1,1") && gameTab[0][1] == '-') {
            gameTab[0][1] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("1,2") && gameTab[0][5] == '-') {
            gameTab[0][5] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("1,3") && gameTab[0][9] == '-') {
            gameTab[0][9] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("2,1") && gameTab[1][1] == '-') {
            gameTab[1][1] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("2,2") && gameTab[1][5] == '-') {
            gameTab[1][5] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("2,3") && gameTab[1][9] == '-') {
            gameTab[1][9] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("3,1") && gameTab[2][1] == ' ') {
            gameTab[2][1] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("3,2") && gameTab[2][5] == ' ') {
            gameTab[2][5] = player2.getSymbol();
            player2Valid = true;
          } else if (play2.equals("3,3") && gameTab[2][9] == ' ') {
            gameTab[2][9] = player2.getSymbol();
            player2Valid = true;
          } else if (
            (
              gameTab[0][1] == player1.getSymbol() ||
              gameTab[0][1] == player2.getSymbol()
            ) &&
            (
              gameTab[0][5] == player1.getSymbol() ||
              gameTab[0][5] == player2.getSymbol()
            ) &&
            (
              gameTab[0][9] == player1.getSymbol() ||
              gameTab[0][9] == player2.getSymbol()
            ) &&
            (
              gameTab[1][1] == player1.getSymbol() ||
              gameTab[1][1] == player2.getSymbol()
            ) &&
            (
              gameTab[1][5] == player1.getSymbol() ||
              gameTab[1][5] == player2.getSymbol()
            ) &&
            (
              gameTab[1][9] == player1.getSymbol() ||
              gameTab[1][9] == player2.getSymbol()
            ) &&
            (
              gameTab[2][1] == player1.getSymbol() ||
              gameTab[2][1] == player2.getSymbol()
            ) &&
            (
              gameTab[2][5] == player1.getSymbol() ||
              gameTab[2][5] == player2.getSymbol()
            ) &&
            (
              gameTab[2][9] == player1.getSymbol() ||
              gameTab[2][9] == player2.getSymbol()
            )
          ) {
            System.out.println(
              "There's no winner for this round! Let's play another round!"
            );
            gameOn = true;
            gameTab[0][1] = '-';
            gameTab[0][5] = '-';
            gameTab[0][9] = '-';
            gameTab[1][1] = '-';
            gameTab[1][5] = '-';
            gameTab[1][9] = '-';
            gameTab[2][1] = ' ';
            gameTab[2][5] = ' ';
            gameTab[2][9] = ' ';
          } else {
            System.err.println(
              "Error, please enter something that is valid to play your turn!\n"
            );
            player2Valid = false;
          }
        }

        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 11; j++) {
            System.out.print(gameTab[i][j]);
          }
          System.out.print("\n");
        }

        if (
          (
            gameTab[0][1] == player2.getSymbol() &&
            gameTab[1][5] == player2.getSymbol() &&
            gameTab[2][9] == player2.getSymbol()
          ) ||
          (
            gameTab[0][1] == player2.getSymbol() &&
            gameTab[0][5] == player2.getSymbol() &&
            gameTab[0][9] == player2.getSymbol()
          ) ||
          (
            gameTab[1][1] == player2.getSymbol() &&
            gameTab[1][5] == player2.getSymbol() &&
            gameTab[1][9] == player2.getSymbol()
          ) ||
          (
            gameTab[2][1] == player2.getSymbol() &&
            gameTab[2][5] == player2.getSymbol() &&
            gameTab[2][9] == player2.getSymbol()
          ) ||
          (
            gameTab[0][1] == player2.getSymbol() &&
            gameTab[1][1] == player2.getSymbol() &&
            gameTab[2][1] == player2.getSymbol()
          ) ||
          (
            gameTab[0][5] == player2.getSymbol() &&
            gameTab[1][5] == player2.getSymbol() &&
            gameTab[2][5] == player2.getSymbol()
          ) ||
          (
            gameTab[0][9] == player2.getSymbol() &&
            gameTab[1][9] == player2.getSymbol() &&
            gameTab[2][9] == player2.getSymbol()
          ) ||
          (
            gameTab[0][9] == player2.getSymbol() &&
            gameTab[1][5] == player2.getSymbol() &&
            gameTab[2][1] == player2.getSymbol()
          )
        ) {
          player2.setScore();
          System.out.println(
            "Congradulation " + player2.getName() + " you won this round!\n"
          );
          gameOn = false;
          gameTab[0][1] = '-';
          gameTab[0][5] = '-';
          gameTab[0][9] = '-';
          gameTab[1][1] = '-';
          gameTab[1][5] = '-';
          gameTab[1][9] = '-';
          gameTab[2][1] = ' ';
          gameTab[2][5] = ' ';
          gameTab[2][9] = ' ';
          boolean valid2 = false;
          while (!valid2) {
            System.out.println(
              "Do you want to play another round? (enter Y/N)"
            );
            String confirmation = scanner.nextLine();
            char confirm = confirmation.charAt(0);
            if (confirm == 'Y' || confirm == 'y') {
              gameOn = true;
              valid2 = true;
            } else if (confirm == 'N' || confirm == 'n') {
              gameOn = false;
              valid2 = true;
            } else {
              System.err.println("Error, please enter Y or N!");
            }
          }
        }
      }
    }
    //--------------------------------------------------------------------------
    // END OF THE GAME
    //--------------------------------------------------------------------------
    System.out.println(
      "The score of " + player1.getName() + " is " + player1.getScore()
    );
    System.out.println(
      "The score of " + player2.getName() + " is " + player2.getScore()
    );
    if (player1.getScore() > player2.getScore()) {
      System.out.println(
        player1.getName() + " is the big winner!!Let's celebrate! 🍾🍻🥳👏"
      );
    } else if (player1.getScore() == player2.getScore()) {
      System.out.println("Both are winners, let's celebrate! 🍾🍻🥳👏");
    } else {
      System.out.println(
        player2.getName() + " is the big winner!!Let's celebrate! 🍾🍻🥳👏"
      );
    }
    System.out.println(
      "Thank you to play Tic-Tac-Toe game! Hope you had fun! See you another time! 😊"
    );
    scanner.close();
  }

  //----------------------------------------------------------------------------
  // FUNCTIONS FOR THE CLASS MAIN
  //----------------------------------------------------------------------------
  /**
   * Validate the name of a player
   * @param player : the player
   * @param scanner : a scanner to read the input of the user
   * @return true if the name format is valid, false otherwise
   */
  private static boolean validatePlayerName(Player player, Scanner scanner) {
    boolean validPlayerName;
    String namePlayer = scanner.nextLine();
    if (player.validateName(namePlayer)) {
      player.setName(namePlayer);
      validPlayerName = true;
    } else {
      System.err.println("Error, please enter a valid name!");
      validPlayerName = false;
    }
    return validPlayerName;
  }

  /**
   * Validate if the user entered OK or QUIT as input
   * @param scanner : a scanner to get the input of the user
   * @param okay : helper for the logic of the function
   * @return true if the user enter the right thing, false otherwise
   */
  private static boolean validateOKorQUIT(Scanner scanner, boolean okay) {
    String input = scanner.nextLine();
    if (input.equals("OK") || input.equals("ok")) {
      System.out.println(MSG_CONFIRMATION);
      okay = true;
    } else if (input.equals("QUIT") || input.equals("quit")) {
      System.out.println(MSG_EXIT);
      System.exit(0);
    } else {
      System.err.println(ERR_WRONG_INPUT);
      okay = false;
    }
    return okay;
  }

  /**
   * Randomly set the first player to play
   * @param random : the number that determine who's the first player
   * @param player1 : a player
   * @param player2 : the other player
   */
  private static void setTheFirstPlayerToPlay(
    double random,
    Player player1,
    Player player2
  ) {
    if (random > 0 && random < 0.5) {
      player1.setFirstPlayer();
      System.out.println(
        player1.getName() + " is the first player to play! Because, why not!?\n"
      );
    } else {
      player2.setFirstPlayer();
      System.out.println(
        player2.getName() + " is the first player to play! Because, why not!?\n"
      );
    }
  }

  /**
   * Let the player choose a symbol they want to use to play the game (X or O)
   * @param playerX : a player
   * @param playerY : the other player
   * @param scanner : a scanner to get the input of the user
   */
  private static void setSymbolsForPlayers(
    Player playerX,
    Player playerY,
    Scanner scanner
  ) {
    System.out.println(
      playerX.getName() + ", please choose your symbol to play (X or O)!"
    );
    String symbolPlayer1Line = scanner.nextLine();
    char symbolPlayer1 = symbolPlayer1Line.charAt(0);
    playerX.setSymbol(symbolPlayer1);

    if (playerX.getSymbol() == 'X') {
      playerY.setSymbol('O');
    } else if (playerX.getSymbol() == 'O') {
      playerY.setSymbol('X');
    }
  }

  /**
   * Print the symbol that have been choose by the players
   * @param player1 
   * @param player2
   */
  private static void printPlayersSymbol(Player player1, Player player2) {
    System.out.println(
      player1.getName() + ", your symbol is " + player1.getSymbol() + "!"
    );
    System.out.println(
      player2.getName() + ", your symbol is " + player2.getSymbol() + "!"
    );
  }

  /**
   * Show a introduction message and prompt the user to continue or quit
   * @param scanner : to get the input of the user (OK or QUIT)
   */
  private static void introductionPrompt(Scanner scanner) {
    System.out.println(MSG_WELCOME);
    System.out.println(MSG_INPUT_PROMPT);
    boolean okay = false;
    while (!okay) {
      okay = validateOKorQUIT(scanner, okay);
    }
  }

  /**
   * 
   * @param player
   * @param scanner
   */
  private static void promptPlayerName(Player player, Scanner scanner) {
    boolean validPlayer1Name = false;
    while (!validPlayer1Name) {
      validPlayer1Name = validatePlayerName(player, scanner);
    }
    System.out.println(
      "Hi " + player.getName() + ", welcome to tic-tac-toe game!\n"
    );
  }

  private static void instructionBeginningOfTheGame() {
    System.out.println("The game is on, let the fun begin!!😎");
    System.out.println("Here's the game board state of the game!🤯\n");

    System.out.println(LINE1_LINE2_GAME);
    System.out.println(LINE1_LINE2_GAME);
    System.out.println(LINE3_GAME + '\n');

    System.out.println("Listen carefuly because I won't repeat it!");
    System.out.println("The instruction of the game is the follow :");
    System.out.println(
      "Choose the place you want to put your symbol where x is the line number between 1 and 3 and y is the column number between 1 and 3 separate by a coma!"
    );
    System.out.println("Ex: x,y\n");
  }
}
