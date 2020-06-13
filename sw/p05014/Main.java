package p05014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = -1;
		try {
			String data = br.readLine();
			String[] tmp = data.trim().split(" ");
			int F = Integer.parseInt(tmp[0]);
			int S = Integer.parseInt(tmp[1]);
			int G = Integer.parseInt(tmp[2]);
			int U = Integer.parseInt(tmp[3]);
			int D = Integer.parseInt(tmp[4]);

			Queue<Integer> qu = new LinkedList<Integer>();
			int[] checkLoc = new int[1000001];
			checkLoc[S] = 1;
			qu.offer(S);

			while (!qu.isEmpty()) {
				int loc = qu.poll();
				if (loc == G) {
					result+=checkLoc[loc];
					break;
				}
				if (F >= (loc + U)) {
					if (checkLoc[loc + U] == 0) {
						qu.offer(loc + U);
						checkLoc[loc + U] = checkLoc[loc] + 1;
					}
				}

				if (0 < (loc - D)) {
					if (checkLoc[loc - D] == 0) {
						qu.offer(loc - D);
						checkLoc[loc - D] = checkLoc[loc] + 1;
					}
				}
			}
			
			if(result==-1){
				System.out.println("use the stairs");
			} else {
				System.out.println(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
