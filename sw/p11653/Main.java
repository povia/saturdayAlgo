package p11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		
		try {
			N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i=2; i*i<=N; i++) {
				System.out.println("-----i = " + i + ", N = " + N);
				while(N%i==0) {
					sb.append(i).append("\n");
					N = N/i;
				}
			}
			if(N!=1)sb.append(N).append("\n");
			System.out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
