package p02504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> list = new Stack<>();
		int lineScore = 1;
		int score = 0;
		try {
			String line = br.readLine();
			for(int i=0; i<line.length(); i++) {
				String tgt = line.charAt(i)+"";
				if(tgt.equals("(")) {
					lineScore*=2;
					list.push(tgt);
				} else if(tgt.equals("[")) {
					lineScore*=3;
					list.push(tgt);
				} else if(tgt.equals(")")) {
					if(list.isEmpty() || !list.peek().equals("(")) {
						score = 0;
						break;
					} else {
						if(line.charAt(i-1)=='(') {
							score+=lineScore;
						}
						lineScore/=2;
						list.pop();
					}
				} else if(tgt.equals("]")) {
					if(list.isEmpty() || !list.peek().equals("[")) {
						score = 0;
						break;
					} else {
						if(line.charAt(i-1)=='[') {
							score+=lineScore;
						}
						lineScore/=3;
						list.pop();
					}
				}
			}
			
			if(list.isEmpty()) System.out.println(score);
			else System.out.println(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
