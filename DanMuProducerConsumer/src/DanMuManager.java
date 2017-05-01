public class DanMuManager {

	public static void main(String[] args) {
		DanMuStore danMuStore = new DanMuStore();
		Runnable danMuCreator = new DanMuCreator(danMuStore);
		// Runnable danMuCreator2 = new DanMuCreator(danMuStore);
		// Runnable danMuCreator3 = new DanMuCreator(danMuStore);
		Runnable danMuConsumer = new DanMuConsumer(danMuStore);

		Thread thread_Creator_1 = new Thread(danMuCreator);
		thread_Creator_1.start();

		Thread thread_Creator_2 = new Thread(danMuCreator);
		thread_Creator_2.start();

		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread thread_Creator_3 = new Thread(danMuCreator);
		thread_Creator_3.start();

		Thread thread_Consumer_1 = new Thread(danMuConsumer);
		thread_Consumer_1.start();
		
		Thread thread_Consumer_2 = new Thread(danMuConsumer);
		thread_Consumer_2.start();

	}
}
