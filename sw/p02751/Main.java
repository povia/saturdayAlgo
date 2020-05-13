package p02751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] data;
	static int[] tmpSet;
	static int N;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine().trim());
			data = new int[N + 1];
			tmpSet = new int[N + 1];
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(br.readLine());
			}
			calc(0, N);
			for(int i=0; i<N; i++)System.out.println(data[i]);
		} catch (IOException ioe) {

		}
	}

	private static void calc(int st, int en) {
		if (en - st == 1)
			return;
		if (en - st == 2) {
			if (data[st] > data[st + 1]) {
				int tmp = data[st];
				data[st] = data[st + 1];
				data[st + 1] = tmp;
			}
			return;
		}
		int mid = (st + en) / 2;
		calc(st, mid);
		calc(mid, en);
		merge(st, en);
	}

	private static void merge(int st, int en) {
		int mid = (st + en) / 2;
		int idxFull = st;
		int idxSource = st;
		int idxDest = en;

		while (idxSource < mid && idxDest < en) {
			if (data[idxSource] <= data[idxDest]) {
				tmpSet[idxFull++] = data[idxSource++];
			} else {
				tmpSet[idxFull++] = data[idxDest++];
			}
		}
		while(idxSource < mid) tmpSet[idxFull++] = data[idxSource++];
		while(idxDest < en) tmpSet[idxFull++] = data[idxDest++];
		
		for(int i = st; i<en; i++) data[i] = tmpSet[i];
	}
}
