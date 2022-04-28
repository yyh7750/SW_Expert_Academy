package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 숫자 배열을 90, 180, 270도 회전 시키는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.28
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.28  Younghun Yu  최초 생성
 */
public class 숫자_배열_회전 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append("\n");

			int[][] arr = null;
			int[][] arr90 = null;
			int[][] arr180 = null;
			int[][] arr270 = null;

			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			arr90 = new int[n][n];
			arr180 = new int[n][n];
			arr270 = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			arr90 = solution(arr);
			arr180 = solution(arr90);
			arr270 = solution(arr180);

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr90[i][j]);
				}

				sb.append(" ");
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr180[i][j]);
				}

				sb.append(" ");
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr270[i][j]);
				}
				
				sb.append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}

	public static int[][] solution(int[][] arr) {
		int n = arr.length;
		int[][] rotate = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotate[j][n - 1 - i] = arr[i][j];
			}
		}

		return rotate;
	}
}