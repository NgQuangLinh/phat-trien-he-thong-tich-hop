package FileWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;

public class GhiFile1 implements Runnable{
	public void run() {
		for( int i = 0; i < 10; i++) {
			System.out.print(Thread.currentThread().getName() + ":" + i + "\n");
		}
	}
	
	public void write2file(int i)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("vidu.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(i);
			fos.close();
			dos.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.print("Loi khong tim thay file!");
		}
		catch(IOException e)
		{
			System.out.print("Loi !");
		}
	}
	
	public void process(){
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
