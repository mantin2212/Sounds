package trying;

public class TryingThreads {
	private Thread t1 = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {
				System.out.println("fashwashwa");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	private Thread t2 = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {
				System.out.println("abulebulebule");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	public void makeThemSleep(long millis) throws InterruptedException {
		Thread.currentThread().wait(millis);
	}

	public TryingThreads() {
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new TryingThreads();
	}

}
