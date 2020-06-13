package p01920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class CustomizedScanner {
	private static BufferedReader br;
	private static StringTokenizer st;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer("");
	}

	static String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
		}
		return null;
	}

	static String readLineReplace() {
		try {
			return br.readLine().replace("\\s+", "");
		} catch (IOException IOe) {

		}
		return null;
	}

	static String next() {
		while (!st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	static boolean hasNext() {
		return st.hasMoreTokens();
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
	}
}

public class Main {
	static ArrayList<Integer> dataSet;
	
	public static void main(String[] args) {
		int N = CustomizedScanner.nextInt();
		dataSet = new ArrayList<>(); 
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			dataSet.add(CustomizedScanner.nextInt());
		}
		
		Collections.sort(dataSet);
		int M = CustomizedScanner.nextInt();
		for(int i=0; i<M; i++) {
			int target = CustomizedScanner.nextInt();
			sb.append(solve(0, N-1, target)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int solve(int st, int en, int target) {
		while(st<=en) {
			int mid = (st+en)/2;
			if(dataSet.get(mid)>target) {
				en = mid-1;
			} else if(dataSet.get(mid)<target) {
				st = mid+1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
