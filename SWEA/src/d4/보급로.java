package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @packageName : d4
 * @description : 최단경로를 찾는 프로그램. bfs 사용.(다익스트라, bfs, dfs 공부 필요)
 * @author : Younghun Yu
 * @date : 2022.04.20
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.20  Younghun Yu  최초 생성
 */
public class 보급로 {

	private static int[] dx = { -1, 1, 0, 0 }; // 좌우
	private static int[] dy = { 0, 0, -1, 1 }; // 상하
	private static int n; // 지도의 크기 지정을 위한 숫자
	private static int[][] map; // n*n 크기의 지도
	private static int[][] count; // 복구시간 비교할 배열
	private static boolean[][] visited; // 방문체크 배열
	private static int min; // 최단경로를 구하기 위한 변수

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0; // test case
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			count = new int[n][n];
			visited = new boolean[n][n];

			// 지도 입력
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}

			for (int i = 0; i < n; i++) {
				Arrays.fill(count[i], Integer.MAX_VALUE);
			}
			count[0][0] = 0;

			min = Integer.MAX_VALUE;
			bfs(0, 0);

			sb.append(min).append("\n");
		}

		br.close();
		
		System.out.println(sb);
	}

	/**
	 * @methodName : bfs
	 * @description :
	 * @param x
	 * @param y
	 *
	 * @author : Younghun Yu
	 * @date : 2022.04.20
	 */
	private static void bfs(int x, int y) {

		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int a = arr[0];
			int b = arr[1];

			if (a == n - 1 && b == n - 1) {
				min = min > count[n - 1][n - 1] ? count[n - 1][n - 1] : min;
			}

			if (min <= count[a][b]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (!visited[nx][ny] || count[nx][ny] > count[a][b] + map[nx][ny]) {
						visited[nx][ny] = true;
						count[nx][ny] = count[a][b] + map[nx][ny];
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
}