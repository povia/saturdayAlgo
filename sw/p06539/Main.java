package p06539;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		boolean[] rooms;
		try {
			N = Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++){
				int K = Integer.parseInt(br.readLine());
				rooms = new boolean[K+1];
				Arrays.fill(rooms, true);
				for(int j=2; j<=K; j++){
					for(int x = 1; x<=K; x++){
						if(x%j==0){
							if(rooms[x]) rooms[x] = false;
							else rooms[x] = true;
						}
					}
				}
				
				int result = 0;
				for(int j=1; j<=K; j++){
					if(rooms[j]) result++;
				}
				
				System.out.println(result);
				/*
				 * 1라운드 : 모두 열음
				 * 2라운드 : 2,4,6,...,n(n이 2의 배수일 경우)까지 닫음
				 * 3라운드 : 3,6,9....,n(n이 3의 배수일 경우)까지 닫혀있으면 열고, 열려있으면 닫음
				 * 
				 */
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
