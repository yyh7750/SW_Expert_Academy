package a형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서_연결하기 {

	static class Loc {
		int x;
		int y;

		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int T, N, size, min;
	private static int[][] arr;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static Loc[] core;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			core = new Loc[12];
			visited = new boolean[12];
			size = 0;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (arr[i][j] == 1) {
						core[size++] = new Loc(i, j); // 가장자리 빼고
					}
				}
			}

			for (int i = size; i >= 0; i--) {
				combination(0, 0, i);

				if (min < Integer.MAX_VALUE) {
					break; // 최솟값이 갱신되어 있으면 결과가 나왔다는 뜻임
				}
			}

			System.out.println("#" + t + " " + min);
		}
	}

	public static void combination(int idx, int cnt, int R) {
		if (cnt == R) {
			dfs(0, 0);
			return;
		}
		for (int i = idx; i < size; i++) {
			visited[i] = true;
			combination(i + 1, cnt + 1, R);
			visited[i] = false;
		}
	}

	public static void dfs(int idx, int cnt) {
		if (idx == size) {
			min = Math.min(min, cnt); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
			return;
		}
		if (!visited[idx]) { // 부분 집합에 포함되는 애들만 다음 단계로 넘어갈 수 있다.
			dfs(idx + 1, cnt);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int r = core[idx].x;
			int c = core[idx].y;
			int tmp = 0;
			boolean success = false;

			while (true) {
				r += dr[i];
				c += dc[i];

				if (r < 0 || r >= N || c < 0 || c >= N) { // 범위 끝까지 갔으면 성공
					success = true;
					break;
				}

				if (arr[r][c] != 0) {
					break; // 전선이나 코어를 만나면 실패
				}

				arr[r][c] = 2; // 전선 표시
				tmp++; // 전선 길이 합
			}

			if (success) {
				dfs(idx + 1, cnt + tmp);
			}

			while (true) { // 원 상태로 돌려놓기
				r -= dr[i];
				c -= dc[i];

				if (r == core[idx].x && c == core[idx].y) {
					break;
				}

				arr[r][c] = 0;
			}
		}
	}
}