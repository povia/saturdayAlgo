package p02501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void solveA() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] target = br.readLine().split(" ");
			int N = Integer.parseInt(target[0]);
			int K = Integer.parseInt(target[1]);

			int mid = N / 2 + 1;

			int cnt = 0;
			int targetNum = 0;

			for (int i = 1; i <= mid; i++) {
				if (K == cnt)
					break;
				if (N % i == 0) {
					targetNum = i;
					cnt++;
				}
			}

			if (K == (cnt + 1)) {
				targetNum = N;
				cnt++;
			}

			System.out.println(K == cnt ? targetNum : 0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void solveB() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] target = br.readLine().split(" ");
			int N = Integer.parseInt(target[0]);
			int K = Integer.parseInt(target[1]);
			
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=1; i*i<=N; i++) {
				if(N%i==0) list.add(i);
			}
			for(int i=list.size()-1; i>=0; i--) {
				if(list.get(i)*list.get(i)==N) continue;
				list.add(N/list.get(i));
			}
			
			if(list.size()>=K) {
				System.out.println(list.get(K-1));
			} else {
				System.out.println(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
//		solveA();
		solveB();
	}
}
