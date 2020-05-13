package p10816;

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
	static ArrayList<Integer> list;
	
	private static int lower_idx(int target){
		int st = 0;
		int en = list.size();
		while(st<en){
			int mid = (st+en)/2;
			if(target<=list.get(mid)){
				en = mid;
			} else {
				st = mid+1;
			}
		}
		return st;
	}
	
	private static int upper_idx(int target){
		int st = 0;
		int en = list.size();
		while(st<en){
			int mid = (st+en)/2;
			if(list.get(mid)>target){
				en = mid;
			} else {
				st = mid+1;
			}
		}
		return st;
	}
	
	public static void main(String[] args){
		int N = CustomizedScanner.nextInt();
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		for(int i=0; i<N; i++){
			list.add(CustomizedScanner.nextInt());
		}
		Collections.sort(list);
		int M = CustomizedScanner.nextInt();
		
		for(int i=0; i<M; i++){
			int K = CustomizedScanner.nextInt();
			
			sb.append(upper_idx(K)-lower_idx(K)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
