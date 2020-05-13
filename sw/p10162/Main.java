package p10162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] data = {600, 60, 10};
		
		int N;
		
		try {
			N = Integer.parseInt(br.readLine());
			int[] result = new int[data.length];
			for(int i=0; i<data.length; i++) {
				result[i] = N/data[i];
				N %= data[i];
			}
			
			if(N==0) {
				for(int num : result) {
					System.out.print(num + " ");
				}
			} else {
				System.out.println(-1);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
