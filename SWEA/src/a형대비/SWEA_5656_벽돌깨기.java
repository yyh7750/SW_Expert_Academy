package a형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	static class Loc {
		int r, c, cnt;

		public Loc(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	private static int N, W, H, min;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			go(map, 0);

			sb.append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static void go(int[][] map, int cnt) {
		if (cnt == N) {
			int result = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] > 0) {
						result++;
					}
				}
			}

			min = Math.min(min, result);
			return;
		}

		int[][] copyMap = new int[H][W];

		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0) {
				r++;
			}

			if (r == H) {
				go(map, cnt + 1);
			} //
			else {
				copy(map, copyMap);
				// 연쇄 처리
				boom(copyMap, r, c);
				// 중력 처리
				down(copyMap);
				// 다음 구슬
				go(copyMap, cnt + 1);
			}
		}
	}

	private static void down(int[][] map) {
		Stack<Integer> stack = new Stack<>();
		for (int c = 0; c < W; c++) {
            // 윗 행부터 남은 벽돌 스택에 넣기
            for (int r = 0; r < H; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            }
            
            // 남은 벽돌은 스택에 들어있고 모든 칸은 빈칸 상태
            int nr = H-1;
            while(!stack.isEmpty()) {
                map[nr--][c] = stack.pop();
            }
        }
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Loc> Q = new ArrayDeque<>();

		if (map[r][c] > 1) {
			Q.offer(new Loc(r, c, map[r][c]));
		}
		map[r][c] = 0;

		while (!Q.isEmpty()) {
			Loc cur = Q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r;
				int nc = cur.c;

				for (int i = 1; i < cur.cnt; i++) {
					nr += dr[d];
					nc += dc[d];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) {
							Q.offer(new Loc(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] copyMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}