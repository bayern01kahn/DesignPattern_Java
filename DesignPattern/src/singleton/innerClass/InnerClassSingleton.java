package singleton.innerClass;

public class InnerClassSingleton {

	private InnerClassSingleton(){}
	
	private static class SingletonHelp {
        static InnerClassSingleton instance = new InnerClassSingleton();
	}

	public static InnerClassSingleton getInstance() {
	        return SingletonHelp.instance;
	}
}
