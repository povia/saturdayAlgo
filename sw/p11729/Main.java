package p11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder strBuilder = new StringBuilder();
	static int cnt = 0;

	public static void func(int a, int b, int n) {
		cnt++;
		if (n == 1) {
			strBuilder.append(a).append(" ").append(b).append("\n");
			return;
		}
		int c = 6 - a - b;                                          // a, b가 아닌 나머지 기둥의 번호              
		func(a, c, n - 1);											// a에 있던 1 to n-1번째 원판을 a에서 c로 이동   
		strBuilder.append(a).append(" ").append(b).append("\n");    // a에 남아있던 n번째 원판을 b로 이동            
		func(c, b, n - 1);                                          // c에 있던 1 to n-1번째 원판을 c에서 b로 이동   
	}

	public static void main(String[] args) {
		int N = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			N = Integer.parseInt(br.readLine().trim());

			func(1, 3, N);
			System.out.println(cnt);
			System.out.println(strBuilder);

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
