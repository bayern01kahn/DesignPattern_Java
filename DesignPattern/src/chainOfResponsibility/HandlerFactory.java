package chainOfResponsibility;

import chainOfResponsibility.handler.CEO;
import chainOfResponsibility.handler.Director;
import chainOfResponsibility.handler.Lead;
import chainOfResponsibility.handler.Manager;
import chainOfResponsibility.handler.Sales;
import chainOfResponsibility.handler.VP;

public class HandlerFactory {

	public static Sales createHandlerFactory(){
		
		Sales sales = new Sales();
		Lead lead = new Lead();
		Manager mgr = new Manager();
		Director director = new Director();
		VP vp = new VP();
		CEO ceo = new CEO();
		
		sales.setSuccessor(lead);
		lead.setSuccessor(mgr);
		mgr.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return sales;
	}
}
