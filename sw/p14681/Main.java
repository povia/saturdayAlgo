package p14681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int x = Integer.parseInt(br.readLine().trim());
			int y = Integer.parseInt(br.readLine().trim());
			
			if(x>=0 && y>=0){
				System.out.println(1);
			} else if(x<0 && y>=0){
				System.out.println(2);
			} else if(x<0 && y<0){
				System.out.println(3);
			} else if(x>=0 && y<0){
				System.out.println(4);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
