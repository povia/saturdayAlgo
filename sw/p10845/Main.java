package p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] data = new int[10000];
		int head=0, tail = 0;
		try {
			int N = Integer.parseInt(br.readLine().trim());
			for(int i=0; i<N; i++) {
				String cmd = br.readLine().trim();
				String[] set = cmd.split(" ");
				cmd = set[0];
				
				switch(cmd) {
				case "push":
					data[tail++] = Integer.parseInt(set[1]);
					break;
				case "pop":
					if(head==tail) {
						System.out.println(-1);
					} else {
						System.out.println(data[head]);
						head++;
					}
					break;
				case "size":
					System.out.println(tail-head);
					break;
				case "empty":
					System.out.println(tail-head==0?1:0);
					break;
				case "front":
					System.out.println(tail-head==0?-1:data[head]);
					break;
				case "back":
					System.out.println(tail-head==0?-1:data[tail-1]);
					break;
				}
				
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
