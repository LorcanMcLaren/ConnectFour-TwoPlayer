
public class Connect4Game 
{

	public static void main( String[] args )
	{
		Connect4Grid2DArray grid = new Connect4Grid2DArray();
		grid.emptyGrid();	// grid must be emptied to set elements to BLANK value
		
		C4HumanPlayer player1 = new C4HumanPlayer( 'X' );
		C4RandomAIPlayer player2 = new C4RandomAIPlayer( '0' );
		
		boolean isWinner = false;
		
		while ( !isWinner )
		{
			if ( isWinnerAfterRound( grid, player1, player2 ) )
				isWinner = true;
		}
		
	}
	
	public static boolean isWinnerAfterRound( Connect4Grid2DArray grid, ConnectPlayer player1, ConnectPlayer player2 )
	{
		if ( grid.isGridFull() )
		{
			System.out.println( "Grid is full" );
			return true;
		}
		
		boolean isValid = false;
		System.out.println( "Player 1's Turn: " );
		while ( !isValid )
		{
			int columnP1 = player1.chooseColumn();
			if ( grid.isValidColumn( columnP1 ) && !grid.isColumnFull( columnP1 ) )
			{
				grid.dropPiece( player1, columnP1 );
				isValid = true;
			}
			else
				System.out.println( "This column is unavailable. Please try again." );
		}
		
		System.out.println( grid.toString() );
		
		if ( grid.didLastPieceConnect4() == false )
		{
			boolean isValid2 = false;
			System.out.println( "Player 2's Turn:" );
			while ( !isValid2 )
			{
				int columnP2 = player2.chooseColumn();
				if ( grid.isValidColumn( columnP2 ) && !grid.isColumnFull( columnP2 ) )
				{
					grid.dropPiece( player2, columnP2 );
					isValid2 = true;
				}
				else
					System.out.println( "This column is unavailable. Please try again." );
			}
			System.out.println( grid.toString() );
			
			if ( grid.didLastPieceConnect4() == true )
			{
				System.out.println( "WINNER: Player 2" );
				return true;
			}
		}
		else
		{
			System.out.println( "WINNER: Player 1" );
			return true;
		}
		return false;
	}
}
