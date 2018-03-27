package publish_Subscribe.base;

//发布者
public interface Publisher<E> {
	
	public void publish (E arg);
}
