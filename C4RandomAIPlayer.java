import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer
{
	private static final int NUMBER_OF_COLUMNS = 7;
	
	C4RandomAIPlayer( char piece ) 
	{
		super(piece);
	}

	public int chooseColumn() 
	{
		Random generator = new Random();
		int column = generator.nextInt( (NUMBER_OF_COLUMNS - 1) );
		return column;
	}	
}
