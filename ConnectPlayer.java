
abstract class ConnectPlayer 
{
	char piece;
	
	ConnectPlayer( char piece )
	{
		this.piece = piece;
	}
	
	abstract int chooseColumn();

}
