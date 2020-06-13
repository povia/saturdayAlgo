package p11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N, M;
		try {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);
			int[] source = new int[N];
			int[] dest = new int[M];

			line = br.readLine().trim().split(" ");
			for (int i = 0; i < line.length; i++) {
				source[i] = Integer.parseInt(line[i]);
			}

			line = br.readLine().trim().split(" ");
			for (int i = 0; i < line.length; i++) {
				dest[i] = Integer.parseInt(line[i]);
			}

			int[] result = new int[N + M];
			int idxSource = 0;
			int idxDest = 0;
			int idxFull = 0;

			while (idxFull < result.length) {
				if (idxSource < N && idxDest < M) {
					if (source[idxSource] <= dest[idxDest]) {
						sb.append(source[idxSource] + " ");
						result[idxFull++] = source[idxSource++];
						
					} else {
						sb.append(dest[idxDest] + " ");
						result[idxFull++] = dest[idxDest++];
					}
				} else if(idxSource==N) {
					while(idxDest<M) {
						sb.append(dest[idxDest] + " ");
						result[idxFull++] = dest[idxDest++]; 
					}
				} else if(idxDest==M) {
					while(idxSource<N) {
						sb.append(source[idxSource] + " ");
						result[idxFull++] = source[idxSource++];
					}
				}

			}
			
			System.out.println(sb);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
