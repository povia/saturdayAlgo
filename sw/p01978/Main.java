package p01978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		int[] data;
		int result = 0;
		
		try {
			N = Integer.parseInt(br.readLine());
			
			String[] line = br.readLine().split(" ");
			
			ArrayList<Integer> primeNumbers = new ArrayList<>();
			boolean[] isPrimeSet = new boolean[1001];
			Arrays.fill(isPrimeSet, true);
			isPrimeSet[1] = false;
			
			for(int i=2; i<1001;i++) {
				for(int j=(int)Math.pow(i, 2); j<1001; j+=i) {
					isPrimeSet[j]=false;
				}
			}
			for(int i=0; i<N; i++) {
				int target = Integer.parseInt(line[i]);
				if(isPrimeSet[target]==true) result++;
			}
			
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
