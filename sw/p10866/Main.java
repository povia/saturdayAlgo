package p10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int[] dataSet;
		int tail=-1;
		String space = "\n";
		StringBuilder sb = new StringBuilder();
		try {
			N = Integer.parseInt(br.readLine());
			dataSet = new int[N];
			while(N-->0){
				String[] line = br.readLine().split(" ");
				
				if(line[0].equals("push_back")){
					dataSet[++tail] = Integer.parseInt(line[1]);
				}else if(line[0].equals("push_front")){
					for(int i=0; i<=tail; i++)dataSet[i+1] = dataSet[i]; 
					tail++;
					dataSet[0] = Integer.parseInt(line[1]);
				}else if(line[0].equals("pop_front")){
					if(tail>=0) {
						sb.append(dataSet[0]).append(space);
						for(int i=0; i<tail; i++){
							dataSet[i] = dataSet[i+1];
						}
						tail--;
					}else sb.append(-1).append(space);
				}else if(line[0].equals("pop_back")){
					if(tail>=0){
						sb.append(dataSet[tail]).append(space);
						dataSet[tail] = 0;
						tail--;
					}else sb.append(-1).append(space);
				}else if(line[0].equals("size")){
					if(tail>-1)sb.append(tail+1).append(space);
					else sb.append(0).append(space);
				}else if(line[0].equals("empty")){
					if(tail>-1)sb.append(0).append(space);
					else sb.append(1).append(space);
				}else if(line[0].equals("front")){
					if(tail>-1)sb.append(dataSet[0]).append(space);
					else sb.append(-1).append(space);
				}else if(line[0].equals("back")){
					if(tail>-1)sb.append(dataSet[tail]).append(space);
					else sb.append(tail).append(space);
				}
			}
			System.out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
