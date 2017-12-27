import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer
{
	C4HumanPlayer( char piece )
	{
		super( piece );
	}

	public int chooseColumn() 
	{
		int column = -1;
		boolean validInput = false;
		Scanner scan = new Scanner( System.in );

		while ( !validInput )
		{
			try
			{
				System.out.println( "Which column would you like to choose? (0-6)" );
				column = Integer.parseInt( scan.nextLine() );
				if ( column >= 0 && column <= 6 )
					validInput = true;
				else
					System.out.println( "This is not a valid number. Please try again." );

			}
			catch ( NumberFormatException exception )
			{ System.out.println( "This is not a valid number. Please try again." ); }

		}
		return column;
	}	
}
