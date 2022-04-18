package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 숫자 n이 주어질 경우 n*n 크기의 배열 모양으로 달팽이 모양을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.18
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.18  Younghun Yu  최초 생성
 */
public class 달팽이_숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0; // test case

		tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			solution(1, 0, n, arr);

			System.out.println("#" + t);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void solution(int k, int count, int n, int[][] snail) {
		if (k >= n * n) {
			if (n % 2 == 1) {
				snail[count][count] = k;
			}
			return;
		}
		for (int j = count; j < n - 1 - count; j++) {
			snail[count][j] = k++;
		}
		for (int j = count; j < n - 1 - count; j++) {
			snail[j][n - 1 - count] = k++;
		}
		for (int j = count; j < n - 1 - count; j++) {
			snail[n - 1 - count][n - 1 - j] = k++;
		}
		for (int j = count; j < n - 1 - count; j++) {
			snail[n - 1 - j][count] = k++;
		}
		
		solution(k, ++count, n, snail);
	}
}