package p01267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			String[] data = br.readLine().split(" ");
			
			int ysCost = 0;
			int msCost = 0;
			
			for(int i=0; i<N; i++){
				int num = Integer.parseInt(data[i]);
				int tmp = num%29;
				ysCost += (num/30)*10;
				if(tmp>0) ysCost+=10;
				msCost += (num/60)*15;
				tmp = num%59;
				if(tmp>0) msCost+=15;
			}
			
			System.out.println(ysCost<msCost?"Y " + ysCost:ysCost==msCost?"Y M " + ysCost:"M " + msCost);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
