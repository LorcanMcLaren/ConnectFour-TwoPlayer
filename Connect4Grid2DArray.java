
public class Connect4Grid2DArray implements Connect4Grid
{
	private static final int NUMBER_OF_COLUMNS = 7;
	private static final int NUMBER_OF_ROWS = 6;
	private char[][] connect4Grid;
	private static final char BLANK = ' ';
	private static final char PIECE_X = 'X';
	private static final char PIECE_O = 'O';
	private static final int PIECES_IN_A_ROW_TO_WIN = 4;
	
	Connect4Grid2DArray()
	{
		connect4Grid = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	}

	
	public void emptyGrid() 
	{
		for ( int i = 0; i < NUMBER_OF_ROWS; i++ )
		{
			for ( int j = 0; j < NUMBER_OF_COLUMNS; j++ )
			{
				connect4Grid[i][j] = BLANK;
			}
		}
	}

	public String toString()
	{
		String grid = "";
		for ( int i = 0; i < NUMBER_OF_ROWS; i++ )
		{
			for ( int j = 0; j < NUMBER_OF_COLUMNS; j++ )
			{
				grid += "|";
				grid += connect4Grid[i][j];
				
				if ( j + 1 >= NUMBER_OF_COLUMNS )
					grid += "|";
			}
			grid += "\r\n";
		}
		grid += "---------------\r\n";
		for (  int k = 0; k < NUMBER_OF_COLUMNS; k++)
		{
			grid += " " + k;
		}
		return grid;
	}
	
	public boolean isValidColumn( int column ) 
	{
		if ( column >= 0 && column < NUMBER_OF_COLUMNS)
			return true;
		else	
			return false;
	}

	
	public boolean isColumnFull( int column ) 
	{
		for ( int i = 0; i < NUMBER_OF_ROWS; i++ )
		{
			if ( connect4Grid[i][column] == BLANK )
				return false;
		}
		return true;
	}

	
	public void dropPiece( ConnectPlayer player, int column ) 
	{
		for ( int i = NUMBER_OF_ROWS; i > 0; i-- )
		{
			if ( connect4Grid[i-1][column] == BLANK )
			{
				connect4Grid[i-1][column] = player.piece;
				break;
			}
		}
		
	}

	
	public boolean didLastPieceConnect4() 
	{ 
		char currentPlayerPiece = PIECE_X; 
		int playersChecked = 0;
		int connectCount = 0;

		while( playersChecked < 2 ) 
		{
			// CHECKING HORIZONTALLY
			for( int row = NUMBER_OF_ROWS - 1; row >= 0 ; row-- )
			{
				connectCount = 0;
				for( int column = NUMBER_OF_COLUMNS - 1; column >= 0; column-- ) 
				{					

					if( connect4Grid[row][column] == currentPlayerPiece )
						connectCount++;
					else
						connectCount = 0;
					if( connectCount == PIECES_IN_A_ROW_TO_WIN )
					{
						System.out.println( "Horizontal row made!" );
						return true;
					}
				}
			}	

			// CHECKING VERTICALLY
			for ( int column = NUMBER_OF_COLUMNS - 1; column >= 0; column-- )
			{
				connectCount = 0;
				for( int row = NUMBER_OF_ROWS - 1; row >= 0; row-- )
				{

					if( connect4Grid[row][column] == currentPlayerPiece )
						connectCount++;
					else
						connectCount = 0;
					if( connectCount == PIECES_IN_A_ROW_TO_WIN )
					{
						System.out.println( "Vertical row made!" );
						return true;
					}
				}
			}
			
			// CHECKING DIAGONALLY UPWARDS (LEFT --> RIGHT)
			for ( int column = 3; column < NUMBER_OF_COLUMNS; column++ )
			{
				for ( int row = 0; row < NUMBER_OF_ROWS - 3; row++ )
				{
					if ( connect4Grid[row][column] == currentPlayerPiece && connect4Grid[row + 1][column - 1] == currentPlayerPiece && connect4Grid[row + 2][column - 2] == currentPlayerPiece && connect4Grid[row + 3][column - 3] == currentPlayerPiece )
					{
						System.out.println( "Ascending diagonal row made!" );
						return true;
					}
				}
			}
			
			
			// CHECKING DIAGONALLY DOWNWARDS (LEFT --> RIGHT)
			for ( int column = 3; column < NUMBER_OF_COLUMNS; column++ )
			{
				for ( int row = 3; row < NUMBER_OF_ROWS; row++ )
				{
					if ( connect4Grid[row][column] == currentPlayerPiece && connect4Grid[row - 1][column - 1] == currentPlayerPiece && connect4Grid[row - 2][column - 2] == currentPlayerPiece && connect4Grid[row - 3][column - 3] == currentPlayerPiece )
					{ 
						System.out.println( "Descending diagonal row made!" );
						return true;
					}
				}
			}
			playersChecked++;
			currentPlayerPiece = PIECE_O;
		}
		

		return false;

	}
	

	public boolean isGridFull() 
	{
		for ( int i = 0; i < NUMBER_OF_ROWS; i++ )
		{
			for ( int j = 0; j < NUMBER_OF_COLUMNS; j++ )
			{
				if ( connect4Grid[i][j] == BLANK )
					return false;
			}
		}
		return true;
	}
}
