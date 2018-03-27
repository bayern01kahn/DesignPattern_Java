package publish_Subscribe.promoted;

import java.util.ArrayList;
import java.util.List;

import publish_Subscribe.base.Echo;
import publish_Subscribe.base.Quit;
import publish_Subscribe.base.Response;
import publish_Subscribe.base.Subscriber;
import publish_Subscribe.base.Url;

public class PromotedMainTest {

	public static void main(String args[]){
		
		PromotedInputLoop il = PromotedInputLoop.create();
		List<Subscriber<String>> subscribers =new ArrayList<Subscriber<String>>();
		
		SubscriberPublisherControlCenterInstance controlC =new SubscriberPublisherControlCenterInstance(il, subscribers);
		
		controlC.addSubScriber(Echo.create());
		controlC.addSubScriber(Quit.create());
		controlC.addSubScriber(Response.create("foo","bar"));
		controlC.addSubScriber(Response.create("1+1","2"));
		controlC.addSubScriber(Url.create());
		
		il.publish(controlC);
	}
}


