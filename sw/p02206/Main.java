package p02206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Node{
	int x,y,distance, force;
	Node(int x, int y, int distance, int force){
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.force = force;
	}
}
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dis = {{0,1},{0,-1},{-1,0},{1,0}};
		int N,M;
		try {
			String line = br.readLine();
			String[] tmp = line.trim().split(" ");
			
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			int[][] data = new int[N][M];
			int[][] checked = new int[N][M];
			
			for(int i=0; i<N; i++) {
				line = br.readLine();
				for(int j=0; j<M; j++) {
					data[i][j] = Character.getNumericValue(line.charAt(j));
					checked[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Queue<Node> qu = new LinkedList<>();
			qu.add(new Node(0,0,1,0));
			checked[0][0] = 0;
			int result = -1;
			
			while(!qu.isEmpty()) {
				Node n = qu.poll();
				
				if(n.x==N-1 && n.y==M-1) {
					result = n.distance;
					break;
				}
				
				for(int i=0; i<4; i++) {
					int newX = n.x+dis[i][0];
					int newY = n.y+dis[i][1];
					
					if(newX<0 || newY<0 || newX>=N || newY >=M) continue;
					if(checked[newX][newY]<=n.force) continue;
					
					if(data[newX][newY]==0) {
						checked[newX][newY] = n.force;
						qu.add(new Node(newX, newY, n.distance+1, n.force));
					} else {
						if(n.force==0) {
							checked[newX][newY] = n.force +1;
							qu.add(new Node(newX, newY, n.distance+1, n.force+1));
						}
					}
				}
			}
			
			if(result == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
