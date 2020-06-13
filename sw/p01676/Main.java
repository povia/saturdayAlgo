package p01676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTwo = 0, numFive = 0;
		int N;
		
		/*
		 * 1의 자리부터 0의 갯수가 몇개나 나오는지를 확인
		 * *10을 얼마나 하는지가 관건
		 * *10 => *(2*5)
		 * 2의 갯수와 5의 갯수를 찾아, 둘 중 적은 걸 return 하면
		 * 10을 곱한 갯수를 알 수 있다.
		 */
		
		try {
			N = Integer.parseInt(br.readLine());
			
			for(int i=2; i<=N; i*=2){
				numTwo += N/i;
			}
			
			for(int i=5; i<=N; i*=5){
				numFive += N/i;
			}
			
			System.out.println(numTwo>numFive?numFive:numTwo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
