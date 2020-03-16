package p02667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
class Node{
	int m, n;
	
	Node(int m, int n ){
		this.m = m;
		this.n = n;
	}
}
public class Main {
	
	
	static int N = 0; 
	static int cnt = 0;
	static int fullCnt = 0;
	static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] dataSet; 
	static int[][] checkLoc;
	
	private static void calc(int cur_m, int cur_n){
		for(int i=0; i<4;i++){
			int newM = cur_m+direction[i][0];
			int newN = cur_n+direction[i][1];
			
			if(newM<0 || newM>=N || newN<0 || newN>=N) {
				continue;
			}
			if(checkLoc[newM][newN]==0 && dataSet[newM][newN]!=0 ) {
				checkLoc[newM][newN] = fullCnt;
				cnt = cnt+1;
				calc(newM, newN);
			}
		}
	}
	
	public static void main(String[] args){
		sc.init();
		N= sc.nextInt();
		dataSet = new int[N][N];
		checkLoc = new int[N][N];
		Stack<Node> st = new Stack<Node>();
		for(int i=0; i<N; i++){
			String tmp = sc.next();
			for(int j=0; j<N; j++){
				dataSet[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
//		int fullCnt = 0;
		ArrayList<Integer> cntList = new ArrayList<>(); 
		cnt = 0;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(dataSet[i][j]!=0 && checkLoc[i][j]==0){
					fullCnt++;
					cnt++;
					checkLoc[i][j] = fullCnt;
					calc(i,j);
					cntList.add(cnt);
					cnt = 0;
				}
			}
		}
		
		Collections.sort(cntList);
		System.out.println(fullCnt);
		for(int res : cntList){
			System.out.println(res);
		}
		
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
