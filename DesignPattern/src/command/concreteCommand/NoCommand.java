package command.concreteCommand;

import command.command.ICommand;

public class NoCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("待机");
	}

	@Override
	public void undo() {
		System.out.println("待机");
	}

}
