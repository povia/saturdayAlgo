package p09466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int T = Integer.parseInt(br.readLine().trim());
			
			for(int i=0; i<T; i++){
				int N = Integer.parseInt(br.readLine().trim());
				String line = br.readLine();
				
				String[] tmp = line.split(" ");
				int[] data = new int[tmp.length+1];
				for(int j=1; j<data.length; j++){
					data[j] = Integer.parseInt(tmp[j-1]);
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
