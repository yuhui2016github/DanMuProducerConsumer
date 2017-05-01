import java.util.ArrayList;
import java.util.List;

public class DanMuStore {

	final static int MAX_LENGTH = 10;
	List<DanMu> danMuList = new ArrayList<>(MAX_LENGTH);

	public void addDanMu(DanMu danMu) {
		synchronized (danMuList) {
			if (danMuList.size() < MAX_LENGTH) {
				danMuList.notify();
				System.out.println("add : " + danMu.id);
				danMuList.add(danMu);
			} else {
				System.out.println("drop : " + danMu.id);
			}
		}
	}

	public DanMu removeDanMu() {
		synchronized (danMuList) {
			if (danMuList.size() > 0) {
				DanMu danMu = danMuList.get(0);
				System.out.println("remove : " + danMu.id);
				danMuList.remove(0);
				return danMu;
			} else {
				try {
					System.out.println("remove : " + null);
					danMuList.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}
	}

	public synchronized int getSize() {
		return danMuList.size();
	}
}
