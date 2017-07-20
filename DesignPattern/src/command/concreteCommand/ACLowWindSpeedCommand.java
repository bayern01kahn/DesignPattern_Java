package command.concreteCommand;

import command.command.ICommand;
import command.receiver.AirConditioning;

public class ACLowWindSpeedCommand implements ICommand {

	AirConditioning ac;
	int prevSpeed;
	
	public ACLowWindSpeedCommand(AirConditioning ac){
		this.ac = ac;
	}
	
	@Override
	public void execute() {
		prevSpeed = ac.getWindSpeed();
		ac.low();
	}

	@Override
	public void undo() {
		ac.off();
	}

}
