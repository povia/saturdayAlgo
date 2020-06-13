package p01932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		try {
			n = Integer.parseInt(br.readLine().trim());
			int[][] data = new int[n][];
			for(int i=0; i<n; i++) {
				String line = br.readLine();
				String[] lineToData = line.split(" ");
				data[i] = new int[lineToData.length];
				for(int j=0; j<lineToData.length; j++) {
					data[i][j] = Integer.parseInt(lineToData[j]);
				}
			}
			
			System.out.println(data.toString());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
