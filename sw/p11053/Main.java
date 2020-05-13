package p11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		int[] data;
		int[] dp;
		try {
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			dp = new int[N];
			int result=0;
			int curData = 0;
			String[] line = br.readLine().trim().split(" ");
			
			dp[0] = 1;
			for(int i=0; i<N; i++){
				int d = Integer.parseInt(line[i]);
				data[i] = d;
				dp[i] = 1;
				for(int j=0; j<i; j++){
					if(data[j]<data[i]) dp[i] = Math.max(dp[i], dp[j]+1);
				}
				
				if(dp[i]>result) result = dp[i];
			}
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
