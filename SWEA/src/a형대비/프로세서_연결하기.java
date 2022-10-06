package a형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 프로세서_연결하기 {

	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = { 1, 0, 0, -1 };
	private static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

		}
	}

	private static void dfs(int r, int c) {
		
	}

	private static boolean isChecked(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N) {
			return true;
		}
		return false;
	}
}