import java.util.*;
/** Main class contains the main and getIntRange methods
 *  that allow for user input and error check the input
 */
 //Prince Angulo and Alan Van
class Main 
{
    /** main method runs the whole of the program by calling methods
     *  from other classes to allow user to play the tic tac toe game
     *  @param array of Strings as default parameter for main method
     *  @return none since the main is void
     */
  public static void main(String[] args) 
  {
    Stack<Memento> history = new Stack<Memento>();
    Board b = new Board();
    history.add(b.save());
    int input = 0;
    char currentToken = 'x';
    int counter = 1;
    while(input != 3)
    {
      b.display();
      System.out.println("1. Place Token\n2. Revert\n3. Quit");
      input = getIntRange(1, 3);
      if(input == 1)
      {
        System.out.print("Place an ");
        if(counter % 2 == 1)
        {
          currentToken = 'x';
          System.out.println("x");
        }
        else
        {
          currentToken = 'o';
          System.out.println("o");
        }
        System.out.print("Row: ");
        int row = getIntRange(0,2);
        System.out.print("Col: ");
        int col = getIntRange(0,2);
        System.out.println();
        if(b.placeToken(currentToken, row, col))
        {
          history.push(b.save());
          counter++;
        }
      }
      else if(input == 2)
      {
        try
        {
          b.restore(history.pop());
          counter--;
        } catch(EmptyStackException e)
        {
          System.out.println("There are no moves to revert!");
        }
      }
    }
  }

  /**
	 * Checks if the inputted value is an integer and 
	 * within the specified range (ex: 1-10)
	 * @param low lower bound of the range.
	 * @param high upper bound of the range.
	 * @return the valid input.
	 */
	public static int getIntRange( int low, int high ) 
  {
		Scanner in = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) 
    {
			if( in.hasNextInt() ) 
      {
				input = in.nextInt();
				if( input <= high && input >= low ) 
        {
					valid = true;
				} 
        else 
        {
					System.out.println( "Invalid Range." );
				}
			} else 
      {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}
}