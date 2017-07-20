package command.concreteCommand;

import command.command.ICommand;
import command.receiver.Light;

public class LightOnCommand implements ICommand {

	Light light;
	int prevStatus;
	
	public LightOnCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void execute() {
		prevStatus = light.getStatus();
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
