package p02579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		int[] data;
		int[][] dp;
		try {
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			dp = new int[N][2];
			for(int i=0; i<N; i++) {
				data[i] = Integer.parseInt(br.readLine());
			}
			
			if(N==1) {
				System.out.println(data[0]);
				return;
			}
			dp[0][0] = data[0];
			dp[0][1] = 0;
			dp[1][0] = data[1];
			dp[1][1] = data[0]+data[1];
			
			for(int i = 2; i<N; i++) {
				dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1])+data[i];
				dp[i][1] = dp[i-1][0]+data[i];
			}
			
			System.out.println(Math.max(dp[N-1][0],dp[N-1][1]));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
