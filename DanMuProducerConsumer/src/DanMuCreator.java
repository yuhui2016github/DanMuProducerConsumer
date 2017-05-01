public class DanMuCreator implements Runnable {
	DanMuStore danMuStore;

	public DanMuCreator(DanMuStore danMuStore) {
		this.danMuStore = danMuStore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				DanMu danMu = new DanMu(Thread.currentThread() + ": " + i, i
						+ "");
				danMuStore.addDanMu(danMu);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
