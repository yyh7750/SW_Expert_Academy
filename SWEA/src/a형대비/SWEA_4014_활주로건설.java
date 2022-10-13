package a형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {

	private static int N, X, map[][], map2[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = map2[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(process()).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static int process() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (makeLoad(map[i])) {
				cnt++;
			}
			if (makeLoad(map2[i])) {
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean makeLoad(int[] road) {
		int beforeH = road[0], size = 0;
		int j = 0;

		while (j < N) {
			if (beforeH == road[j]) {
				size++;
				j++;
			} //
			else if (beforeH + 1 == road[j]) {
				if (size < X) {
					return false;
				}

				beforeH++;
				size = 1;
				j++;
			} //
			else if (beforeH - 1 == road[j]) {
				int cnt = 0;
				for (int i = j; i < N; i++) {
					if (road[i] != beforeH - 1) {
						return false;
					} //

					if (++cnt == X) {
						break;
					}
				}

				if (cnt < X) {
					return false;
				} //

				beforeH--;
				size = 0;
				j += X;
			} //
			else {
				return false;
			}
		}

		return true;
	}
}
