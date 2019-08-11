public class Main {

	public static void main(String args[]) {

		boolean status = false;
		long millisChoice = 0;
		ScreenshotSaver saverChoise = null;
		String[] saverTypes = { "dropbox", "yandex", "google", "hdd" };
		if (args.length >= 3) {
			status = true;
			switch (args[0]) {

			case ("run"):
				millisChoice = Long.parseLong(args[2]);
				System.out.println(millisChoice);
				switch (args[1]) {
				case ("dropbox"):
					System.out.println("dropbox");
					saverChoise = new DropBoxSaver();
					break;
				case ("yandex"):
					System.out.println("yandex");
					saverChoise = new YandexDiskSaver();
					break;
				case ("google"):
					System.out.println("google");
					saverChoise = new GoogleDriveSaver();
					break;
				case ("hdd"):
					System.out.println("hdd");
					saverChoise = new HddSaver();
					break;
				default:
					status = false;
					break;
				}
				break;
			case ("help"):
			default:
				status = false;
				break;

			}
		}
		if (status) {
			// TODO rewrite
			final ScreenshotSaver saver = saverChoise;
			final long millis = millisChoice;
			
			saver.init();
			boolean connected = saver.checkConnection();
			if(connected) {
				Thread t1 = new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	for(int i = 0; i<20; i++) {
				    		try {
				    			saver.runThread();
								Thread.sleep(millis);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    	}
				    }
				});  
				t1.start();
			}
			
		} else {
			System.out.printf("To start program pass arguments: \n " + "run 'SaverType' 'DelayInMs'\n "
					+ "SaverType - dropbox, yandex, google or hdd\n" + "DelayInMs - delay in milliseconds\n");
		}

	}

}
