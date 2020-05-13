package p06064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solve() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		
		try {
			T = Integer.parseInt(br.readLine());
			
			for(int i=0; i<T; i++) {
				int M,N,x,y;
				String[] data = br.readLine().split(" ");
				M = Integer.parseInt(data[0]);
				N = Integer.parseInt(data[1]);
				x = Integer.parseInt(data[2]);
				y = Integer.parseInt(data[3]);
				
				boolean finished = false;
				if(x==M) x = 0;
				if(y==N) y=0;
				for(int j=x; j<=M*N; j+=M) {
					if(j%N==y) {
						sb.append(j).append("\n");
						finished=true;
						break;
					} 
				}
				if(!finished) sb.append(-1).append("\n"); 
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		solve();
	}
}
