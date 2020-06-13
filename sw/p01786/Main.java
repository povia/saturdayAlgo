package p01786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[] failure(String s){
		int[] list = new int[s.length()];
		
		int j= 0;
		
		for(int i=1; i<s.length(); i++) {
			while(j>0 && s.charAt(i)!=s.charAt(j)) j = list[j-1];
			if(s.charAt(i)==s.charAt(j)) list[i] = ++j;
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String source = br.readLine();
			String target = br.readLine();
			int[] testSet = failure(target);
			int j=0;
			ArrayList<Integer> resultSet = new ArrayList<Integer>();
			
			for(int i=0; i<source.length(); i++) {
				while (j>0 && source.charAt(i)!=target.charAt(j)) j=testSet[j-1];
				if(source.charAt(i)==target.charAt(j))j++;
				if(j==target.length()) {
					resultSet.add(i+2-target.length());
					j = testSet[j-1];
				}
			}
			
			System.out.println(resultSet.size());
			for(int num : resultSet) {
				System.out.print(num + " ");
			}
//			int firstLoc = 0;
//			int targetTest = 0;
//			int result = 0;
//			int testing = 0;
//			char firstChar = target.charAt(0);
//			ArrayList<Integer> resultLoc = new ArrayList<>();
//			for(int i=0; i<source.length();) {
//				
//				for(int j=0; j<target.length(); j++) {
//					if(source.charAt(i)==firstChar && i==firstLoc) firstLoc = i;
//					if(j==0) {
//						testing = i;
//					}
//					if(targetTest==target.length()) {
//						result++;
//						resultLoc.add(testing);
//						i = firstLoc;
//					}
//					if(source.charAt(i)==target.charAt(j)) {
//						targetTest++;
//						i++;
//						continue;
//					} else {
//						i = firstLoc;
//						targetTest=0;
//						break;
//					}
//				}
//				
//				if(target.length()>source.length()-firstLoc) {
//					break;
//				}
//			}
//			
//			System.out.println(result);
//			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
