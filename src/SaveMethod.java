import java.io.InputStream;

public interface SaveMethod {
	public void init();
	public boolean checkConnection();
	public void save(InputStream imageStream, String filename);
}
