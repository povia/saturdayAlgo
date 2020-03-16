package p09095;

import java.util.Scanner;

public class Main {
	static int[] dp;
	static int calc(int n){
		if(n==1) return 1;
		else if(n==2) return 2;
		else if(n==3) return 4;
		if(dp[n]>0) return dp[n];
		else dp[n] = calc(n-1) + calc(n-2) + calc(n-3);
		return dp[n];
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			System.out.println(calc(sc.nextInt()));
		}
	}
}