package p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	public static void func(int[] arr, boolean[] isused, int k){
		if(k==M){
			for(int i=0; i<M; i++){
				System.out.print((arr[i]+1) + " " );
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++){
			if(!isused[i]){
				arr[k] = i;
				isused[i] = true;
				func(arr, isused, k+1);
				isused[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] line = br.readLine().trim().split(" ");
			
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);

			func(new int[M], new boolean[N], 0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
