import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public abstract class ScreenshotSaver {

	SaveMethod saveMethod;

	public ScreenshotSaver() {
	}

	public void init() {
		saveMethod.init();
	}

	public boolean checkConnection() {
		return saveMethod.checkConnection();
		
	}

	public void save(InputStream imageStream, String filename) {
		saveMethod.save(imageStream, filename);
	}

	public String generateFielName() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String filename = format.format( new Date()   );
		// String filename = "New";
		System.out.printf("New File Name:%s\n", filename);
		return filename;
	}

	public InputStream captureScreen() {
		Robot r;
		InputStream fis = null;
		try {
			r = new Robot();
			Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			@SuppressWarnings("unused")
			BufferedImage Image = r.createScreenCapture(capture);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(Image,"png", os); 
			fis = new ByteArrayInputStream(os.toByteArray());
			System.out.println("Screenshot saved");
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fis;

	}
	
	public void runThread() {
		String filename = generateFielName();
		InputStream screen = captureScreen();
		if (screen != null) {
			save(screen, filename);
		}

	}

}
