package p11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, K;
		int[] data;
		try {
			String[] line = br.readLine().trim().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			data = new int[N];
			
			int result=0, remain=K;
			for(int i=0; i<N; i++) {
				data[i] = Integer.parseInt(br.readLine().trim());
			}
			
			for(int i=N-1; i>=0; i--) {
				result += remain/data[i];
				remain = remain%data[i];
			}
			
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
