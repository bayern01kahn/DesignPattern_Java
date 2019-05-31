package publish_Subscribe;

import java.util.ArrayList;
import java.util.List;

import publish_Subscribe.base.Echo;
import publish_Subscribe.base.Quit;
import publish_Subscribe.base.Response;
import publish_Subscribe.base.Subscriber;
import publish_Subscribe.base.Url;
import publish_Subscribe.promoted.PromotedInputLoop;
import publish_Subscribe.promoted.SubscriberPublisherControlCenterInstance;

public class MainTest {

	public static void main(String args[]){
//		InputLoop il = InputLoop.create();
//		il.subscriber(Echo.create());
//		il.subscriber(Quit.create());
//		il.subscriber(Response.create("foo","bar"));
//		il.subscriber(Response.create("1+1","2"));
//		il.subscriber(Url.create());
//		il.loop();
		
		PromotedInputLoop il = PromotedInputLoop.create();
		List<Subscriber<String>> subscribers =new ArrayList<Subscriber<String>>();
		
		SubscriberPublisherControlCenterInstance controlC =new SubscriberPublisherControlCenterInstance(il, subscribers);
		
		controlC.addSubScriber(Echo.create());
		controlC.addSubScriber(Quit.create());
		controlC.addSubScriber(Response.create("foo","bar"));
		controlC.addSubScriber(Response.create("1+1","2"));
		controlC.addSubScriber(Url.create());
		
		controlC.dispatcherEvent();
	}
}


