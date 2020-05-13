package p16120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String line;
	static char[] tmp;
	static int t;
	
	private static boolean isPpap() {
		if(t<4) return false;
		if(tmp[t-4]=='P' &&tmp[t-3]=='P' &&tmp[t-2]=='A' &&tmp[t-1]=='P') return true;
		return false;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = br.readLine();
			tmp = new char[line.length()];
			t=0;
			for(int i=0; i<line.length(); i++) {
				tmp[t++] = line.charAt(i);
				while(isPpap()) {
					t-=4;
					tmp[t++]='P';
				}
			}
			
			if(t==1 && tmp[0]=='P') {
				System.out.println("PPAP");
			} else {
				System.out.println("NP");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
