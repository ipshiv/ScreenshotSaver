import java.io.File;
import java.io.InputStream;

public class HddSaveMethod implements SaveMethod {
	public void init() {
		System.out.println("HDD save method inited");
	}
	public boolean checkConnection() {
		System.out.println("No need to check, pass");
		return true;
	}
	public void save(InputStream imageStream, String filename) {
		System.out.printf("HDD saved file:%s", filename);
	}
}
