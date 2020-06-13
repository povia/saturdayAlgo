package p02293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		int[] dp1, dp2;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		int[] data;
		int N, K;
		
		try {
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			
			data = new int[N];
			dp1 = new int[K+1];
			dp2 = new int[K+1];
			
			for(int i=0; i<N; i++){
				data[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i = 0; i<=K; i+=data[0])dp1[i] = 1;
			
			for(int i=1; i<N; i++){
				dp2 = new int[K+1];
				for(int j=0; j<=K; j++){
					dp2[j] = dp1[j];
					if(j>=data[i]){
						dp2[j] += dp2[j-data[i]];
					}
				}
				dp1 = dp2;
			}
			
			System.out.println(dp1[K]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
