package command.concreteCommand;

import command.command.ICommand;
import command.receiver.Light;

public class LightOffCommand implements ICommand {

	Light light;
	int prevStatus;
	
	public LightOffCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void execute() {
		prevStatus = light.getStatus();
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
