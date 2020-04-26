package p10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int result = 0;
			String line = br.readLine();
			Stack<String> list = new Stack<>();
			String lastTemp = "";
			for (int i = 0; i < line.length(); i++) {

				if (line.charAt(i) == '(') {
					list.push(line.charAt(i) + "");
				} else {
					if (!list.isEmpty()) {
						if(lastTemp.equals("(")) {
							result += list.size()-1;
						} else {
							result ++;
						}
						list.pop();
					}
				}

				lastTemp = line.charAt(i) + "";
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
