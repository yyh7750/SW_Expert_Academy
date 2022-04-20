package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 숫자 n이 주어질 때 1이상 9이하의 두 수 a, b의 곱으로 표현될 수 있는지 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.20
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.20  Younghun Yu  최초 생성
 */
public class 구구단1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());

			boolean p = false;
			for (int i = 1; i <= 9; i++) {
				if (n % i == 0 && n / i < 10) {
					p = true;
					break;
				}
			}

			if (p) {
				sb.append("Yes").append("\n");
			} //
			else {
				sb.append("No").append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}