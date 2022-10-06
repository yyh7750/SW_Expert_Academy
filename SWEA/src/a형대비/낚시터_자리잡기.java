package a형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시터_자리잡기 {

	private static int N;
	private static int[] fishing;
	private static int[][] gate;
	private static int[][] sel;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			fishing = new int[N];
			gate = new int[3][2];
			sel = new int[3][2];
			visited = new boolean[3];

			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					gate[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 낚시터 게이트 순서에 따라 결과가 바뀌기 때문에 순열을 구해준다.
			permutation(0);
		}
	}

	private static void permutation(int idx) {
		if (idx == 3) {
			// 최솟값 구하기
			dfs(0);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx][0] = gate[i][0];
				sel[idx][1] = gate[i][1];
				permutation(idx + 1);
				visited[i] = false;
			}
		}
	}

	private static void dfs(int idx) {
		
	}
}