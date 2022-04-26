package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 주어진 k의 길이만큼 딱 맞게 들어갈 수 있는 공간의 갯수를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.26
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.26  Younghun Yu  최초 생성
 */
public class 어디에_단어가_들어갈_수_있을까 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] row = new int[n];
			int[] col = new int[n];
			int count = 0;

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == 1) {
						row[i] += arr[i][j];
						col[j] += arr[i][j];
						if ((row[i] == k && j + 1 == n) || (row[i] == k && j + 1 < n && arr[i][j + 1] == 0)) {
							count++;
						} //
						if ((col[j] == k && i + 1 == n) || (col[j] == k && i + 1 < n && arr[i + 1][j] == 0)) {
							count++;
						}
					} //
					else {
						row[i] = 0;
						col[j] = 0;
					}
				}
			}

			sb.append(count).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}