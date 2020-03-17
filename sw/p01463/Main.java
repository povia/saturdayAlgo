package p01463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int num, cnt;
	Point(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	Point (int num){
		this.num = num;
	}
}

class BFS{
	int solve(int n){
		int result = 0;
		Queue<Point> qu = new LinkedList<Point>();
		qu.add(new Point(n, 0));
		System.out.println("==================BPS=====================");
		System.out.print(n+","+0);
		while(!qu.isEmpty()){
			System.out.print(" => ");
			Point tmp = qu.poll();
			System.out.print(tmp.num+","+tmp.cnt);

			if(tmp.num%3==0){
				qu.add(new Point(tmp.num/3, tmp.cnt+1));
			}
			if(tmp.num%2==0){
				qu.add(new Point(tmp.num/2, tmp.cnt+1));
			}
			if(tmp.num==1) {
				System.out.println();
				System.out.println("==========================================");
				return tmp.cnt;
			}
			if(tmp.num!=1){
				qu.add(new Point(tmp.num-1, tmp.cnt+1));
			}
		}
		return result;
	}
}

class DP{
	int[] dp = new int[1000001];
	int solve(int n){
		System.out.println("==================DP======================");
		dp[1] = 0;
		System.out.print(dp[1]);
		for(int i=2; i<=n; i++){
			System.out.print(" => ");
			dp[i] = dp[i-1] +1;
			if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1);
			if(i%3==0) dp[i] = Math.min(dp[i],dp[i/3]+1);
			System.out.print(dp[i]);
		}
		System.out.println();
		System.out.println("==========================================");
		return dp[n];
	}
}

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println("BFS = " + new BFS().solve(n));
			System.out.println("DP = " + new DP().solve(n));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}