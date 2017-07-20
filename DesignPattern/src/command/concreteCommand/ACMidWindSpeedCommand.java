package command.concreteCommand;

import command.command.ICommand;
import command.receiver.AirConditioning;

public class ACMidWindSpeedCommand implements ICommand {

	AirConditioning ac;
	int prevSpeed;
	
	public ACMidWindSpeedCommand(AirConditioning ac){
		this.ac = ac;
	}
	
	@Override
	public void execute() {
		prevSpeed = ac.getWindSpeed();
		ac.mid();
	}

	@Override
	public void undo() {
		ac.low();
	}

}
