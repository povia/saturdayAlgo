import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	int m,n,k;
	int[][] arr;
	int[][] visited;
	int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
	ArrayList<Integer> sizeList;
	
	class Node{
		int m;
		int n;
		
		Node(int m, int n){
			this.m=m;
			this.n=n;
		}
	}
	private void callDFS(int cur_m, int cur_n) {
		int size = 1;
		Stack<Node> st = new Stack<>();
		st.push(new Node(cur_m, cur_n));
		while (!st.isEmpty()) {
			Node nod = st.pop();
			for (int i = 0; i < 4; i++) {
				int newM = nod.m+direction[i][0];
				int newN = nod.n+direction[i][1];
				
				if(newM<0 || newM>=m || newN<0 || newN>=n) {
					continue;
				}
				if(arr[newM][newN]==0 && visited[newM][newN]==0) {
					visited[newM][newN]++;
					st.push(new Node(newM, newN));
					size++;
				}
			}
		}
		sizeList.add(size);
	}
	
	public static void main(String[] args) {
		sc.init();
		
		new Main().solve();
	}
	
	private void solve() {
		// TODO Auto-generated method stub
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[m][n];
		visited = new int[m][n];
		
		for(int i=0; i<k; i++) {
			int posX = sc.nextInt();
			int posY = sc.nextInt();
			
			int newX = sc.nextInt();
			int newY = sc.nextInt();
			for(int y=posY; y<newY; y++) {
				for(int x = posX; x<newX; x++) {
					arr[y][x] = 1;
				}
			}
		}
		sizeList = new ArrayList<>();
		int cnt=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==0 && visited[i][j] ==0) {
					cnt++;
					visited[i][j]++;
					callDFS(i, j);
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(sizeList);
		for(int res : sizeList) {
			System.out.print(res + " ");
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
