package d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {

	private static final int INF = Integer.MAX_VALUE / 2;
	private static int[][] adjArr;
	private static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjArr = new int[N + 1][N + 1];

			// 초기 설정
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) {
						continue;
					}
					adjArr[i][j] = INF;
				}
			}

			// input
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int input = Integer.parseInt(st.nextToken());
					// 자기 자신 또는 인접하지 않다면 pass
					if (i == j || input == 0) {
						continue;
					}
					adjArr[i][j] = input;
				}
			}

			min = Integer.MAX_VALUE;
			floydWashall();

			sb.append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	/**
	 * @methodName : floydWashall
	 * @Description : 모든 정점에서의 최단 거리를 구한 뒤 최단 거리가 가장 적은 행을 출력.
	 * 
	 * @return void
	 *
	 * @date 2022. 10. 6.
	 * @author 유영훈
	 */
	private static void floydWashall() {
		// 각 정점에서의 최단 거리 구하기
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjArr[i][j] = Math.min(adjArr[i][j], adjArr[i][k] + adjArr[k][j]);
				}
			}
		}

		// 각 정점의 최단거리 합
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += adjArr[i][j];
			}
			min = Math.min(min, sum);
		}
	}
}