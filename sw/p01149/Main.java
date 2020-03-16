package p01149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Cost{
	int r,g,b;
}


public class Main {
	public static void main(String[] args){
		sc.init();
		
		int n = sc.nextInt();
		Cost[] dp = new Cost[n];
		int r=0,g=0,b=0;
		
		for(int i=0; i<n; i++){
			r = sc.nextInt();
			g = sc.nextInt();
			b = sc.nextInt();
			dp[i] = new Cost();
			if(i==0){
				
				dp[i].r = r;
				dp[i].g = g;
				dp[i].b = b;
			} else {
				dp[i].r = Math.min(dp[i-1].g, dp[i-1].b)+r;
				dp[i].g = Math.min(dp[i-1].r,dp[i-1].b)+g;
				dp[i].b = Math.min(dp[i-1].r,dp[i-1].g)+b;
			}
		}
		
		System.out.println(Math.min(Math.min(dp[n-1].r,dp[n-1].g),dp[n-1].b));
	}
	
	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException IOe) {
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replace("\\s+", "");
			} catch (IOException IOe) {

			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		static boolean hasNext() {
			return st.hasMoreTokens();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
