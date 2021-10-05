package BaiTap;

import java.util.Scanner;

public class SoNgto {
	public void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n:");
		n = sc.nextInt();
		if(n > 0) {
			if( ktsonguyento(n) == 1)
				System.out.println(n + "la so nguyen to");
			else
				System.out.println(n + "khong phai la so nguyen to");
		}
	}
	
	public static int ktsonguyento( int n) {
		int dem = 0;
		for( int i = 1; i < n; i++) {
			if( n % i == 0)
				dem++;
		}
		if( dem == 2)
			return 1;
		return 0;
	}
}
