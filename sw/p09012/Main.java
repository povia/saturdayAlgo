package p09012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine().trim());
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				System.out.println(calc(line));
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String calc(String str) {
		Stack<String> st = new Stack<String>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				st.push(str.charAt(i)+"");
			} else {
				if (st.isEmpty()) return "NO";
				String tmp = st.pop();
				if(!tmp.equals("(")) {
					return "NO";
				}
			}
		}
		if(st.isEmpty()) return "YES";
		else return "NO";
	}
}
