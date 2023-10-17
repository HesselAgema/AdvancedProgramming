package maumau;

public class MultiThread {
private static int NUMBER_OF_THREADS = 4;
private final static int NUMBER_OF_GAMES = 10000000;
private static int NUMBER_OF_PLAYERS = 3;

//	public static void main(String[] args) {
//
//		//DiceRoller[] rollers = new DiceRoller[NUMBER_OF_THREADS];
//		//PlayMauMau[] games = new PlayMauMau[NUMBER_OF_THREADS];
//		long start = System.currentTimeMillis();
//		//int n = 2; // number of Threads
//		int gamesPerThread = NUMBER_OF_GAMES/NUMBER_OF_THREADS;
//		int numberOfPlayers = 2;	
//		
//		Thread [] threads = new Thread[NUMBER_OF_THREADS];
//		for(int i = 0 ; i < NUMBER_OF_THREADS; i++) {
//			threads[i] = new Thread(new PlayMauMau(gamesPerThread, numberOfPlayers));
//			
//			
//			
//			threads[i].start();
//			System.out.printf("Thread %d started\n", i);
//		}
//		
//		for(int i = 0 ; i < NUMBER_OF_THREADS; i++) {
//			try {
//				threads[i].join();
//				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		long end = System.currentTimeMillis();
//		long time = end-start;
//		System.out.println(time);
//		
//	}

public static void main(String[] args) {

	//DiceRoller[] rollers = new DiceRoller[NUMBER_OF_THREADS];
	PlayMauMau[] games = new PlayMauMau[NUMBER_OF_THREADS];
	long start = System.currentTimeMillis();
	int gamesPerThread = NUMBER_OF_GAMES/NUMBER_OF_THREADS;

	for(int i = 0 ; i < NUMBER_OF_THREADS; i++) {
		games[i] = new PlayMauMau(gamesPerThread, NUMBER_OF_PLAYERS);
	}
	
	Thread[] threads = new Thread[NUMBER_OF_THREADS];
	
	for (int i = 0; i < NUMBER_OF_THREADS; i++) {
		threads[i] = new Thread(games[i]);
		threads[i].start();
		}
	
	try {
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
		threads[i].join();
		}
	} catch (InterruptedException e) {
		System.out.print("Interrupted, exiting\n");
		System.exit(-1);
		}
	
	
	long end = System.currentTimeMillis();
	long time = end-start;
	System.out.println(time);
	
	for(PlayMauMau game : games) {
		try {
			int [] result = game.getResults();
		} catch (Exception e) {
			System.out.printf("PlayMauMau wasn't finished\n");
		}
	}
}

}
