package p02493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
	int data;
	int pos;
	
	public Node(int data,int pos){
		this.data = data;
		this.pos = pos;
	}
	
	public String toString() {
		return "data=" + data + ", pos = " + pos;
	}
}

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Stack<Node> stack = new Stack<Node>();
			for(int i=0; i<N; i++) {
				int data = Integer.parseInt(st.nextToken());
				
				while(!stack.isEmpty()) {
					Node tmp2 = stack.peek();
					if(tmp2.data>=data) {
						System.out.print((tmp2.pos+1) + " ");
						break;
					}
					stack.pop();
				}
				
				if(stack.isEmpty()) System.out.print("0 ");
				stack.push(new Node(data,i));
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
