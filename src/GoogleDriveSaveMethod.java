import java.io.File;
import java.io.InputStream;

public class GoogleDriveSaveMethod implements SaveMethod {
	public void init() {
		System.out.println("GD save method inited");
	}
	public boolean checkConnection() {
		System.out.println("GD is online");
		return true;
	}
	public void save(InputStream imageStream, String filename) {
		System.out.printf("GD saved file:%s", filename);
	}

}
