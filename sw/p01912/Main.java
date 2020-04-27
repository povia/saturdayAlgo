package p01912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine().trim());
			String[] line = br.readLine().trim().split(" ");
			int[] data = new int[line.length];
			int[] dp = new int[line.length];
			int result = Integer.MIN_VALUE;
			for(int i=0; i<line.length; i++){
				data[i] = Integer.parseInt(line[i]);
				if(i==0) {
					dp[i] = data[i];
				} else if(i>0){
					dp[i] = Math.max(dp[i-1]+data[i],data[i]); 
				}
				result = result<dp[i]?dp[i]:result;
			}
			
			System.out.println(result);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
