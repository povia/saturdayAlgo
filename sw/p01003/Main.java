package p01003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	int zeroCnt;
	int oneCnt;

	Node(int zeroCnt, int oneCnt) {
		this.zeroCnt = zeroCnt;
		this.oneCnt = oneCnt;
	}
}

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node[] datas = new Node[41];
		int N, T;
		datas[0] = new Node(1, 0);
		datas[1] = new Node(0, 1);

		for (int i = 2; i <= 40; i++) {
			datas[i] = new Node(datas[i - 1].zeroCnt + datas[i - 2].zeroCnt, datas[i - 1].oneCnt + datas[i - 2].oneCnt);
		}

		try {
			T = Integer.parseInt(br.readLine());

			for (int i = 0; i < T; i++) {
				N = Integer.parseInt(br.readLine());

				System.out.println(datas[N].zeroCnt + " " + datas[N].oneCnt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
