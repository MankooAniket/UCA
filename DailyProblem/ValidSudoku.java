import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A class to validate a 9x9 Sudoku board.
 * It checks whether the board is valid according to Sudoku rules:
 * Each row, column, and 3x3 sub-box must contain digits 1-9 without repetition,
 * considering only the filled cells.
 */
public class ValidSudoku {
  /**
    * Checks if a given Sudoku board is valid.
    *
    * @param board a 9x9 character array representing the Sudoku board.
    *              Empty cells are denoted by '.'.
    * @return true if the board is valid according to Sudoku rules; false otherwise.
    */
  public boolean isValidSudoku(char[][] board) {
    List<HashSet<Character>> rows = new ArrayList<>();
    List<HashSet<Character>> cols = new ArrayList<>();
    List<HashSet<Character>> boxes = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      rows.add(new HashSet<>());
      cols.add(new HashSet<>());
      boxes.add(new HashSet<>());
    }
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num == '.') {
          continue;
        }
        if (rows.get(i).contains(num)) {
          return false;
        }
        rows.get(i).add(num);
        if (cols.get(j).contains(num)) {
          return false;
        }
        cols.get(j).add(num);
        int boxIndex = (i / 3) * 3 + (j / 3);
        if (boxes.get(boxIndex).contains(num)) {
          return false;
        }
        boxes.get(boxIndex).add(num);
      }
    }
    return true;
  }

  /**
    * Main method to test the isValidSudoku method with example boards.
    *
    * @param args command line arguments (not used).
    */
  public static void main(String[] args) {
    ValidSudoku validator = new ValidSudoku();
    char[][] board1 = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    char[][] board2 = {
      {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    char[][] board3 = {
      {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
      {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
      {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
      {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
      {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
      {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
      {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
    };


    System.out.println("Board 1 is valid?: " + validator.isValidSudoku(board1));
    System.out.println("Board 2 is valid?: " + validator.isValidSudoku(board2));
    System.out.println("Board 3 is valid?: " + validator.isValidSudoku(board3));

  }
}
