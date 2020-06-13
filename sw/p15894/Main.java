package p15894;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	private static long getDist(long n){
		return n*4-2*(n-1);
	}
	
	private static long calc(long n){
		if(n==1){
			return 4;
		} else {
		return calc(n-1)+getDist(n)-2*(n-1);
		}
	}
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			BigInteger n = new BigInteger(br.readLine());
			
			n = n.multiply(new BigInteger("4"));
			System.out.println(n);
//			long N = Long.parseLong(br.readLine());
//			System.out.println(calc(N));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
