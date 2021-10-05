package FileRead;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class DocFile implements Runnable{
	public void run() {
		for( int i = 0; i < 10; i++) {
			System.out.print(Thread.currentThread().getName() + ":" + i + "\n");
		}
	}
	
	public void readfile(){
		try
		{
			int x;
			FileInputStream fis = new FileInputStream("vidu.txt");
			DataInputStream dis = new DataInputStream(fis);
			while((x=dis.read())!=-1)
			{
				x=(int)dis.read();
				System.out.println(x);
			}
		}
		catch(IOException e)
		{
			
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
