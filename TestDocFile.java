package FileRead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDocFile {
	public static void main(String[] args) {
        
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Runnable df1 = new DocFile();
		Runnable df2 = new DocFile();
		Runnable df3 = new DocFile();
		
		executor.execute(df1);
		executor.execute(df2);
		executor.execute(df3);
		
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
        System.out.println("Finished all threads");
	}
}
