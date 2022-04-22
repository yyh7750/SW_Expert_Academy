package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 첫 번째 줄은 항상 1이며 두 번째 줄부터 각 숫자들은 왼쪽, 오른쪽 위의 숫자의 합으로 구성되는 삼각형을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.22
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.22  Younghun Yu  최초 생성
 */
public class 파스칼의_삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append("\n");

			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == j || j == 0) {
						arr[i][j] = 1;
					} //
					else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		br.close();
		System.out.println(sb);
	}
}