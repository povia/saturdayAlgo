package definitions.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static int[][] makeAdjacencyMatrix(int[][] dataSet) {
		int[][] matrix = new int[dataSet.length + 1][dataSet.length + 1];
		for (int i = 0; i < dataSet.length; i++) {
			// Undirected Link일 경우 양 측면의 연결 여부를 true로 둔다.
			// Directed Link일 경우 list[a][b]만 true로 둔다.
			// 굳이 boolean으로 사용한 이유 => boolean - 1byte, int - 4byte
			matrix[dataSet[i][0]][dataSet[i][1]] = 1;
			matrix[dataSet[i][1]][dataSet[i][0]] = 1;
		}
		return matrix;
	}
	
	public static ArrayList<ArrayList<Integer>> makeAdjacencyList(int[][] dataSet){
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<=dataSet.length; i++){
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<dataSet.length; i++){
			int x = dataSet[i][0];
			int y = dataSet[i][1];
			
			// Undirected Link일 경우 양 측면의 연결 여부를 true로 둔다.
			// Directed Link일 경우 list[a][b]만 true로 둔다.
			// 굳이 boolean으로 사용한 이유 => boolean - 1byte, int - 4byte
			list.get(x).add(y);
			list.get(y).add(x);
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] list = new boolean[N + 1][N + 1];
		int[][] dataSet = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			dataSet[i][0] = a;
			dataSet[i][1] = b;

		}
		
		int[][] matrixResult = makeAdjacencyMatrix(dataSet);
		ArrayList<ArrayList<Integer>> listResult = makeAdjacencyList(dataSet);

		System.out.println("===================================================");
		System.out.println("Adjacency List");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (listResult.get(i).get(j)==1) {
					System.out.println(i + " " + j);
				}
			}
		}
		System.out.println("===================================================");
		
		System.out.println("===================================================");
		System.out.println("Adjacency Matrix");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (matrixResult[i][j]==1) {
					System.out.println(i + " " + j);
				}
			}
		}
		System.out.println("===================================================");
	}
}
