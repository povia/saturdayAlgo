package p01074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int r,c, cnt=0;
	
	public static void calc(int size, int x, int y) {
//		System.out.println("calc(" + size + "," + x + "," + y + ")");
		if(size==2) {
			if(x==r && y==c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(x==r && y+1==c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(x+1==r && y==c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(x+1==r && y+1==c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			return;
		}
		
		calc(size/2, x,y);
		calc(size/2, x,y+size/2);
		calc(size/2, x+size/2,y);
		calc(size/2, x+size/2,y+size/2);
	}
	
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] lineData = br.readLine().trim().split(" ");
			int N = Integer.parseInt(lineData[0]);
			r = Integer.parseInt(lineData[1]);
			c = Integer.parseInt(lineData[2]);
			
			calc((int)Math.pow(2, N), 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
