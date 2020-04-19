package p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] data = new int[10000];
		int pos = 0;
		int N;

		try {
			N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				String cmd = br.readLine().trim();
				String[] set = cmd.split(" ");
				cmd = set[0];

				switch (cmd) {
				case "push":
					data[pos++] = Integer.parseInt(set[1].trim());
					break;
				case "top":
					if(pos==0) System.out.println(-1);
					else System.out.println(data[pos - 1]);
					break;
				case "size":
					System.out.println(pos);
					break;
				case "empty":
					System.out.println(pos == 0 ? 1 : 0);
					break;
				case "pop":
					if (pos == 0) {
						System.out.println(-1);
					} else {
						// pos¸¸ ³·ÃçÁàµµ µÊ
						System.out.println(data[pos - 1]);
						data[--pos] = 0;
					}
					break;
				}
			}

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}