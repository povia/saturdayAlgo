package p01929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int MAXNUM = 1000001;
		boolean[] isPrimeSet = new boolean[MAXNUM];
		Arrays.fill(isPrimeSet, true);
		isPrimeSet[1] = false;
		for(int i=2; i<MAXNUM; i++) {
			for(int j=(int)Math.pow(i, 2); j<MAXNUM; j+=i) {
				isPrimeSet[j]=false;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			String[] data = br.readLine().split(" ");
			
			int M = Integer.parseInt(data[0]);
			int N = Integer.parseInt(data[1]);
			
			for(int i = M; i<=N; i++) {
				if(isPrimeSet[i]) sb.append(i).append("\n");
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
