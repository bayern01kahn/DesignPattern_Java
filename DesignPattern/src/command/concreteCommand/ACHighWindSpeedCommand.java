package command.concreteCommand;

import command.command.ICommand;
import command.receiver.AirConditioning;

public class ACHighWindSpeedCommand implements ICommand {

	AirConditioning ac;
	int prevSpeed;
	
	public ACHighWindSpeedCommand(AirConditioning ac){
		this.ac = ac;
	}
	
	@Override
	public void execute() {
		prevSpeed = ac.getWindSpeed();
		ac.high();
	}

	@Override
	public void undo() {
		ac.mid();
	}

}
