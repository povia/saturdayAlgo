package p10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	
	class Node{
		int m, n;
		Node(int m, int n){
			this.m=m;
			this.n=n;
		}
	}
	
	int n;
	char[][] gridSet;
	int[][] visited;
	int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
 
	private void callDFS(int cur_m, int cur_n, ArrayList<Character> testSet){
		Stack<Node> st = new Stack<>();
		st.push(new Node(cur_m,cur_n));
		while(!st.empty()){
			Node nod = st.pop();
			for(int i=0; i<4; i++){
				int newM = nod.m+direction[i][0];
				int newN = nod.n+direction[i][1];
				
				if(newM<0 || newM>=n || newN<0 ||newN>=n){
					continue;
				}
				if(testSet.contains(gridSet[newM][newN]) && visited[newM][newN]==0){
					visited[newM][newN]++;
					st.push(new Node(newM, newN));
					
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		sc.init();
		
		new Main().solve();
	}
	private void solve() {
		n = sc.nextInt();
		
		gridSet = new char[n][n];
		visited = new int[n][n];
		for(int i=0; i<n; i++){
			String tmp = sc.next();
			for(int j=0; j<n; j++){
				gridSet[i][j] = tmp.charAt(j);
			}
		}
		
		// get All Testset
		int cnt=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(visited[i][j]==0){
					cnt++;
					ArrayList<Character> testSet = new ArrayList<>();
					testSet.add(gridSet[i][j]);
					callDFS(i, j, testSet);
				}
			}
		}
		
		System.out.print(cnt + " ");
		
		visited = new int[n][n];
		
		// For R,G
		cnt=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(visited[i][j]==0){
					cnt++;
					ArrayList<Character> testSet = new ArrayList<>();
					if(gridSet[i][j]=='R' || gridSet[i][j]=='G'){
						testSet.add('R');
						testSet.add('G');
					} else {
						testSet.add(gridSet[i][j]);
					}
					callDFS(i, j, testSet);
				}
			}
		}
		
		System.out.print(cnt + " ");
		
		
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
			}catch(IOException IOe) {
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
			while(!st.hasMoreTokens()) {
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
