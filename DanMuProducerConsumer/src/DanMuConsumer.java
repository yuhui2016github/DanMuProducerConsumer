public class DanMuConsumer implements Runnable {
	DanMuStore danMuStore;

	public DanMuConsumer(DanMuStore danMuStore) {
		this.danMuStore = danMuStore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				danMuStore.removeDanMu();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
