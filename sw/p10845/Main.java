package p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		int head=0, tail=0;
		int[] dataSet;
		StringBuilder sb = new StringBuilder();
		String space = "\n";
		try {
			N = Integer.parseInt(br.readLine());
			dataSet = new int[N];
			while(N-->0){
				String[] line = br.readLine().split(" ");
				
				if(line[0].equals("push")){
					dataSet[tail++] = Integer.parseInt(line[1]);
				}else if(line[0].equals("pop")){
					if(head==tail){
						sb.append(-1).append(space);
					}else {
						sb.append(dataSet[head++]).append(space);
					}
				}else if(line[0].equals("size")){
					sb.append(tail-head).append(space);
				}else if(line[0].equals("empty")){
					sb.append(tail-head==0?1:0).append(space);
				}else if(line[0].equals("front")){
					if(tail-head<=0){
						sb.append(-1).append(space);
					}else {
						sb.append(dataSet[head]).append(space);
					}
				}else if(line[0].equals("back")){
					if(tail-head<=0){
						sb.append(-1).append(space);
					}else {
						sb.append(dataSet[tail-1]).append(space);
					}
				}
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}