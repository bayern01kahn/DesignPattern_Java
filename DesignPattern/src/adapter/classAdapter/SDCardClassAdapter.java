package adapter.classAdapter;

public class SDCardClassAdapter extends SDCardAdaptee implements IMiniSDCardReader {

	public void read(){
		super.readSDCard();
	}
}
