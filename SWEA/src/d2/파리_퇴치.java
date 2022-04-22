package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : N*N 배열에서 M*M만큼의 구역 합이 최대인 경우 최대합을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.22
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.22  Younghun Yu  최초 생성
 */
class 파리_퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] nArr = new int[n][n];
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					nArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					int temp = 0;
					for (int k = 0; k < m; k++) {
						for (int l = 0; l < m; l++) {
							temp += nArr[i + k][j + l];
						}
					}
					max = Math.max(max, temp);
				}
			}

			sb.append(max).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}