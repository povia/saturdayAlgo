package p01931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
class Node implements Comparable<Node>{
	int st, en;
	Node(int st, int en){
		this.st = st;
		this.en = en;
	}
	
	@Override
	public int compareTo(Node b) {
		if(this.en == b.en)return Integer.compare(this.st, b.st);
		else return Integer.compare(this.en, b.en);
	}
} 

public class Main {
	public static boolean cmp(Node a, Node b) {
		if(a.en==b.en) return a.st<b.st;
		else return a.en<b.en;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		Node[] dataSet;
		try {
			N = Integer.parseInt(br.readLine());
			dataSet = new Node[N];
			for(int i=0; i<N; i++) {
				String[] data = br.readLine().split(" ");
				Node d = new Node(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
				dataSet[i] = d;
			}
			
			Arrays.sort(dataSet);
			
			int timer = 0;
			int result = 0;
			
			for(int i=0; i<N; i++) {
				if(timer<=dataSet[i].st) {
					timer = dataSet[i].en;
					result++;
				}
			}
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
