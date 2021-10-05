package FileWrite;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestGhiFile {
	public static void main(String[] args) {
        
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Runnable gf1 = new GhiFile1();
		Runnable gf2 = new GhiFile1();
		Runnable gf3 = new GhiFile1();
		
		executor.execute(gf1);
		executor.execute(gf2);
		executor.execute(gf3);
		
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
        System.out.println("Finished all threads");
	}
}
