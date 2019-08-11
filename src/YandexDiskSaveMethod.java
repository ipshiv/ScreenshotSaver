import java.io.File;
import java.io.InputStream;

public class YandexDiskSaveMethod implements SaveMethod {
	public void init() {
		System.out.println("YD save method inited");
	}
	public boolean checkConnection() {
		System.out.println("YD is online");
		return true;
		
	}
	public void save(InputStream imageStream, String filename) {
		System.out.printf("YD saved file:%s", filename);
	}

}
