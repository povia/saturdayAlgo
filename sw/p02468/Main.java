package p02468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	int m, n;
	
	Node(int m, int n){
		this.m = m;
		this.n = n;
	}
}

class Solution{
	
	int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
	int N;
	int depth;
	int[][] checked;
	int[][] arr;
	int cnt = 0;
	
	private void calc(int cur_m, int cur_n) {
		for(int i=0; i<4; i++) {
			int newM = cur_m + direction[i][0];
			int newN = cur_n + direction[i][1];
			
			if(newM<0 || newM>=N || newN<0 || newN>=N) {
				continue;
			}
			if(checked[newM][newN]==0 && arr[newM][newN]>depth) {
				checked[newM][newN] =cnt;
				calc(newM, newN);
			}
		}
		
	}

	public int solve(int N, int[][] arr, int depth){
		this.N = N;
		this.arr = arr;
		this.depth = depth;
		checked = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(checked[i][j]==0 && arr[i][j]>depth) {
					cnt++;
					checked[i][j] = cnt;
					calc(i,j);
				}
			}
		}
		
		return cnt;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr;
		int max = 0;
		try {
			int N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				String temp = br.readLine();
				String[] tempArr = temp.split(" ");
				
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(tempArr[j]);
				}
			}
			for(int i=0; i<100; i++) {
				int res = new Solution().solve(N, arr, i);
				if(res>=max) max = res;
			}
			System.out.println(max);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
