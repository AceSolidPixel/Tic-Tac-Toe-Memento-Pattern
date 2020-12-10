/** Board class handles the game interactions and checks if  
     *  spots are taken or available for x or o to be placed. Board 
     *  class also has functions to get previous state through Memento
     */
public class Board
{
  private char[][] board;//this is the board that is being used in our game

  /** constructor for the Board class
     *  @param no parameters in this method
     *  @return returns nothing since this is a constructor
     */
  public Board()
  {
    board = new char[3][3];
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        board[i][j] = ' ';
      }
    }
  }
  /** placeToken function places x or o and checks if 
     *  the spot is taken or not 
     *  @param char token is the x or o being placed, int row
     *  is the row the token is placed, int col is the column the 
     *  token is being placed in
     *  @return returns a boolean that is true if the spot is 
     *  available and false if the spot is taken
     */
  public boolean placeToken(char token, int row, int col)
  {
    if(board[row][col] == ' ')
    {  
      board[row][col] = token;
      return true;
    }
    else 
    {
      System.out.println("That space is taken!");
      return false;
    }
  }
  /** display function prints the current board
     *  @param no parameters in this method
     *  @return returns nothing as method is void
     */
  public void display()
  {
    System.out.println("  0 1 2");
    System.out.println("0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);  
    System.out.println("  -----");
    System.out.println("1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);  
    System.out.println("  -----");
    System.out.println("2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
  }
  /** save function saves the previous state of the board
     *  @param no parameters in this method
     *  @return returns a memento with the previous board state
     */
  public Memento save()
  {
    return new Memento(board);
  }
  /** restore function loads the saved board from save
     *  @param Memento to call getState function of previous board
     *  @return returns nothing as method is void
     */
  public void restore(Memento m)
  {
    board = m.getState();
  } 
}
