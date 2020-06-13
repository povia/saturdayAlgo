package p11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		int N, M;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] tmp = br.readLine().split(" ");
			
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<M; i++) {
				tmp = br.readLine().split(" ");
				int a = Integer.parseInt(tmp[0]);
				int b = Integer.parseInt(tmp[1]);
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			int result = 0;
			Stack<Integer> st = new Stack<Integer>();
			boolean[] visited = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				result++;
				st.push(i);
				visited[i] = true;
				while(!st.isEmpty()) {
					int cursor = st.pop();
					for(int j=0; j<list.get(cursor).size(); j++) {
						int nxt = list.get(cursor).get(j);
						if(visited[nxt]) continue;
						st.push(nxt);
						visited[nxt] = true;
					}
					
				}
			}
			
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
