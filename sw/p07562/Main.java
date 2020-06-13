package p07562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int m, n,val;
	Node(int m, int n, int val){
		this.m = m;
		this.n = n;
		this.val = val;
	}
	
	@Override
	public String toString() {
		return "Node [m=" + m + ", n=" + n + "]";
	}
	
	
}

class Solution{
	int[][] direction = {{-2,-1},{-2,1},{-1,2},{-1,-2},{1,-2},{1,2},{2,-1},{2,1}};
	int[][] checked;
	int I = 0;
	
	public void solve(int I, Node sP, Node eP) {
		this.I = I;
		Queue<Node> qu= new LinkedList<Node>();
		checked = new int[I][I];
		
		qu.add(sP);
		checked[sP.m][sP.n] = 1;
		
		while(!qu.isEmpty()) {
			Node point = qu.poll();
			if(point.m==eP.m && point.n==eP.n) {
				System.out.println(point.val);
				break;
			}
			int newM, newN;
			for(int i=0;i<8; i++) {
				newM = point.m+direction[i][0];
				newN = point.n+direction[i][1];
				
				if(newM<0 || newN<0 || newM>=I || newN>=I || checked[newM][newN]!=0) {
					
				} else {
					qu.add(new Node(newM, newN,point.val+1));
					checked[newM][newN] = 1;
				}
			}
		}
//		System.out.println(I + ", " + sP.toString() + ", " + eP.toString());
	}
	
		
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String tmp = br.readLine();
			tmp = tmp.trim();
			int N = Integer.parseInt(tmp);
			for(int i=0; i<N; i++) {
				tmp = br.readLine();
				tmp = tmp.trim();
				int I = Integer.parseInt(tmp);
				
				tmp = br.readLine();
				String[] tmpString = tmp.split(" ");
				int m = Integer.parseInt(tmpString[0]);
				int n = Integer.parseInt(tmpString[1]);
				Node startPoint = new Node(m,n,0);
				tmp = br.readLine();
				tmpString = tmp.split(" ");
				m = Integer.parseInt(tmpString[0]);
				n = Integer.parseInt(tmpString[1]);
				Node endPoint = new Node(m,n,999999);
				new Solution().solve(I, startPoint, endPoint);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
