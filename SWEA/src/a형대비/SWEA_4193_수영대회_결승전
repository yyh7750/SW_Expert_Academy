package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_수영대회_결승전 {

	static class Swimmer {
		int r, c, cnt;

		/**
		 * @param r
		 * @param c
		 * @param cnt : 이동시간을 나타내기 위한 변수
		 */
		public Swimmer(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Swimmer [r=");
			builder.append(r);
			builder.append(", c=");
			builder.append(c);
			builder.append(", cnt=");
			builder.append(cnt);
			builder.append("]");
			return builder.toString();
		}
	}

	private static int N, ans;
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());

			ans = -1;
			if (sr == er && sc == ec) {
				ans = 0;
			} //
			else {
				swimming(sr, sc, er, ec);
			}

			sb.append(ans).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	/**
	 * @methodName : swimming
	 * @description :
	 * @param sr : 시작위치 r
	 * @param sc : 시작위치 c
	 * @param er : 종료위치 r
	 * @param ec : 종료위치 c
	 *
	 * @author : Younghun Yu
	 * @date : 2022.11.12
	 */
	private static void swimming(int sr, int sc, int er, int ec) {
		// 진행방향에 소용돌이가 있을 경우 2가지 선택지
		// 1. 피해서 다른 방향으로 진행한다.
		// 2. 소용돌이가 사라질때까지 기다린다.
		// 2번 선택지의 경우 해당 진행 방향 앞에 소용돌이가 또 있다면 갈 수 없으므로 소용돌이가 더 있는지 검사한다.

		Queue<Swimmer> Q = new LinkedList<>();
		Q.offer(new Swimmer(sr, sc, 0));
		boolean[][] visited = new boolean[N][N];
		visited[sr][sc] = true;

		// 0 : 소용돌이 유지중
		// 1 : 소용돌이 유지중
		// 2 : 소용돌이 사라짐
		while (!Q.isEmpty()) {
			Swimmer cur = Q.poll();

			System.out.println(cur);

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!isChecked(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) {
					continue;
				}

				// 도착
				if (nr == er && nc == ec) {
					ans = cur.cnt + 1;
//					System.out.println("Ans : " + ans);
//					System.out.println("======================");
					return;
				}

				if (map[nr][nc] == 2) {
					// 소용돌이를 만났을 때 소용돌이가 사라진 경우
					if (cur.cnt % 3 == 2) {
						Q.offer(new Swimmer(nr, nc, cur.cnt + 1));
						visited[nr][nc] = true;
					}
					// 기다린다.
					else {
						Q.offer(new Swimmer(cur.r, cur.c, cur.cnt + 1));
						visited[cur.r][cur.c] = true;
					}
				} //
				else {
					Q.offer(new Swimmer(nr, nc, cur.cnt + 1));
					visited[nr][nc] = true;
				}
			}
		}
	}

	/**
	 * @methodName : isChecked
	 * @description :
	 * @param nr
	 * @param nc
	 * @return
	 *
	 * @author : Younghun Yu
	 * @date : 2022.11.12
	 */
	private static boolean isChecked(int nr, int nc) {
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			return true;
		}
		return false;
	}
}
