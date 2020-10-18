package rps;

public class ComputerPlayer extends Player{
	public ComputerPlayer(String name) {
		super(name);
		this.hand =  new java.util.Random().nextInt(3);
	}
}
