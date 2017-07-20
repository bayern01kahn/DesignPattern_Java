package command.concreteCommand;

import command.command.ICommand;
import command.receiver.AirConditioning;

public class ACOffCommand implements ICommand {

	AirConditioning ac;
	int prevSpeed;
	
	public ACOffCommand(AirConditioning ac){
		this.ac = ac;
	}
	
	@Override
	public void execute() {
		prevSpeed = ac.getWindSpeed();
		ac.off();
	}

	@Override
	public void undo() {
		ac.low();
	}

}
