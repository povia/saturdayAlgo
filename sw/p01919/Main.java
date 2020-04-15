package p01919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> sourceCount = new HashMap<>();
		HashMap<String, Integer> destCount = new HashMap<>();
		
		int totCnt = 0;

		try {
			String source = br.readLine().trim();
			String dest = br.readLine().trim();

			for (int i = 0; i < source.length(); i++) {
				String tmp = source.charAt(i) + "";

				if (sourceCount.containsKey(tmp)) {
					sourceCount.put(tmp, sourceCount.get(tmp)+1);
				} else {
					sourceCount.put(tmp, 1);
				}
			}

			for (int i = 0; i < dest.length(); i++) {
				String tmp = dest.charAt(i) + "";

				if (destCount.containsKey(tmp)) {
					destCount.put(tmp, destCount.get(tmp)+1);
				} else {
					destCount.put(tmp, 1);
				}
			}
			
			for(int i=0; i<26; i++){
				int tmpSourceCnt = 0;
				int tmpDestCnt = 0;
				char target = (char) ('a'+i);
				String targetStr = target + "";
				
				if(sourceCount.containsKey(targetStr)){
					tmpSourceCnt=sourceCount.get(targetStr);
				}
				
				if(destCount.containsKey(targetStr)){
					tmpDestCnt = destCount.get(targetStr);
				}
				
				if(tmpSourceCnt!=tmpDestCnt){
					totCnt += Math.abs(tmpSourceCnt-tmpDestCnt);
				}
			}
			
			System.out.println(totCnt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
