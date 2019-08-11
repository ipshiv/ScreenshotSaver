import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.users.FullAccount;

public class DropBoxSaveMethod implements SaveMethod {

	public DbxClientV2 client;
	private static final String connectionCheckParameter = "Ivan Shivarev";
	private static final String ACCESS_TOKEN = "-zxqxFOOKX4AAAAAAAAOuY2Q3CGt7_VPMfvXlvoANWymJYHk4Nu8iK8DhmtLihzl";

	public void init() {
		// Create Dropbox client
		DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
		client = new DbxClientV2(config, ACCESS_TOKEN);
		System.out.println("DB save method inited");
	}

	public boolean checkConnection() {
		// Get current account info
		FullAccount account;
		boolean status = false;
		try {
			account = client.users().getCurrentAccount();
			System.out.println(account.getName().getDisplayName());
			status = true;
			System.out.println("DB is online");
		} catch (DbxApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void save(InputStream imageStream, String filename) {
		InputStream in;
		try {
			in = imageStream;
			@SuppressWarnings("unused")
			FileMetadata metadata = this.client.files().uploadBuilder("/" + filename + ".png").uploadAndFinish(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UploadErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf("DB saved file:%s", filename);
	}

}
