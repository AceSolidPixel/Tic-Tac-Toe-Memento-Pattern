/** Memento class allows for us to save a state and 
     *  retrieve it through getState
     */
public class Memento 
{
  private char[][] board;//this is the board that is being used in our game
  /** constructor for the Memento class
     *  @param char[][]b is the new board being passed in
     *  @return returns nothing since this is a constructor
     */
  public Memento(char[][] b) 
  {
    board = new char[3][3];
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        board[i][j] = b[i][j];
      }
    }
  }
  /** getState function returns the char array board
     *  @param no parameters in this method
     *  @return returns char array that is the board being played on
     */
  public char[][] getState() 
  {
    return board;
  }
}
