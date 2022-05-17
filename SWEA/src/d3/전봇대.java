package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : n개의 전봇대가 주어질때 전봇대가 서로 겹치는 교차점을 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.17
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.17  Younghun Yu  최초 생성
 */
public class 전봇대 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine()); // 전봇대 개수

			int[] Ai = new int[n];
			int[] Bi = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				Ai[i] = Integer.parseInt(st.nextToken());
				Bi[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					} //
					if (Ai[i] < Ai[j]) {
						if (Bi[i] > Bi[j]) {
							count++;
						}
					} //
					else if (Ai[i] > Ai[j]) {
						if (Bi[i] < Bi[j]) {
							count++;
						}
					}
				}
			}

			count /= 2;
			sb.append(count).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}