package p02225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,K;
		
		try {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			
			int[][] dp = new int[K+1][N+1];
			
			for(int i=0; i<=N; i++) {
				dp[1][i] = 1;
			}
			
			for(int i=1; i<=K; i++) {
				for(int j=1; j<=N; j++) {
					for(int l=1; l<=j; l++) {
						dp[i][j] += dp[i-1][j-1];
						dp[i][j] %= 1000000000;
					}
				}
			}
			
			System.out.println(dp[K][N]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
