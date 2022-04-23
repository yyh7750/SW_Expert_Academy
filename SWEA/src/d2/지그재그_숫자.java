package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 1부터 숫자 n까지 홀수는 더하고 짝수는 빼는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.23
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.23  Younghun Yu  최초 생성
 */
public class 지그재그_숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			int sum = 0;

			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					sum -= i;
				} //
				else {
					sum += i;
				}
			}

			sb.append(sum).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}