package command.invoker;

import command.command.ICommand;
import command.concreteCommand.ACAutoTurnDownWindSpeedCommond;
import command.concreteCommand.ACHighWindSpeedCommand;
import command.concreteCommand.ACLowWindSpeedCommand;
import command.concreteCommand.ACMidWindSpeedCommand;
import command.concreteCommand.ACOffCommand;
import command.concreteCommand.LightOffCommand;
import command.concreteCommand.LightOnCommand;
import command.concreteCommand.NoCommand;
import command.receiver.AirConditioning;
import command.receiver.Light;

/**
 * 带有多功能的遥控器
 * 空调部分 为 5个按键
 * 灯光部分 2个按键
 * @author justin
 *
 */
public class SuperRemoteControlWithUndo {
	ICommand[] command;
	ICommand undoCommand;
	int ac_status;
	int light_status;
	
	
	public SuperRemoteControlWithUndo(){
		command = new ICommand[7];
		ICommand noCommand = new NoCommand();
		undoCommand = noCommand; //默认处于待机
	}
	
	public void setACCommand(AirConditioning ac){
		ac_status = ac.getWindSpeed();
		ACHighWindSpeedCommand acH = new ACHighWindSpeedCommand(ac);
		ACMidWindSpeedCommand acM = new ACMidWindSpeedCommand(ac);
		ACLowWindSpeedCommand acL = new ACLowWindSpeedCommand(ac);
		ACAutoTurnDownWindSpeedCommond acATD = new ACAutoTurnDownWindSpeedCommond(ac);
		ACOffCommand  acO = new ACOffCommand(ac);
		
//		//直接调用模式 ，无接收者
//		acL.execute();//单独命令模式
//		
//		//宏命令模式
//		ICommand[] sleepMode = {acL, acM, acH, acATD };
//		MacroCommand mc = new MacroCommand(sleepMode);
//		mc.execute();
		
		command[0] = acO;
		command[1] = acL;
		command[2] = acM;
		command[3] = acH;
		command[4] = acATD;
	}

	public void setLightCommand(Light light){
		light_status = light.getStatus();
		LightOnCommand lightOnC = new LightOnCommand(light);
		LightOffCommand lightOffC = new LightOffCommand(light);
		
		command[5] = lightOnC;
		command[6] = lightOffC;
	}
	
	public void onButtonClick(int  slot){
		command[slot].execute();
		undoCommand = command[slot]; 
	}

	public void undoButtonClick(Object obj) {
		undoCommand.undo();
	}
}
