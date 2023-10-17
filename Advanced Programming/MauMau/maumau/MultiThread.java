package maumau;

public class MultiThread {
private static int NUMBER_OF_THREADS = 1;

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int n = 2; // number of Threads
		
		Thread [] threads = new Thread[NUMBER_OF_THREADS];
		for(int i = 0 ; i < NUMBER_OF_THREADS; i++) {
			threads[i] = new Thread(new PlayMauMau());
			
			
			threads[i].start();
			System.out.printf("Thread %d started\n", i);
		}
		
		for(int i = 0 ; i < NUMBER_OF_THREADS; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println(time);
		
	}

}
