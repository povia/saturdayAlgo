package p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int[] dataSet;
		int cursor =0;
		String space = "\n";
		StringBuilder sb = new StringBuilder();
		try {
			N = Integer.parseInt(br.readLine());
			dataSet = new int[N];
			
			while(N-->0){
				String[] line = br.readLine().split(" ");
				
				if(line[0].equals("push")){
					dataSet[cursor++] = Integer.parseInt(line[1]);
				}else if(line[0].equals("top")){
					if(cursor>0){
						sb.append(dataSet[cursor-1]).append(space);
					} else {
						sb.append(-1).append(space);
					}
				}else if(line[0].equals("size")){
					sb.append(cursor).append(space);
				}else if(line[0].equals("empty")){
					if(cursor<=0){
						sb.append(1).append(space);
					}else{
						sb.append(0).append(space);
					}
				}else if(line[0].equals("pop")){
					if(cursor>0){
						sb.append(dataSet[--cursor]).append(space);
					}else {
						sb.append(-1).append(space);
					}
				}
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			System.out.println("Error Occured");
		}
	}
}