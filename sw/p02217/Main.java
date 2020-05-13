package p02217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		ArrayList<Integer> list = new ArrayList<>();
		try {
			N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(list, Comparator.reverseOrder());
			int cnt=0;
			int result = 0;
			for(int num : list) {
				cnt++;
				result = Math.max(num*cnt, result);
			}
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
