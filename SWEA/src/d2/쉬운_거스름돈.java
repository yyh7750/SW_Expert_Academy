package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 거스름돈의 최소 갯수를 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.28
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.28  Younghun Yu  최초 생성
 */
public class 쉬운_거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append("\n");

			int pay = Integer.parseInt(br.readLine());
			int[] change = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int[] result = new int[change.length];

			for (int i = 0; i < change.length; i++) {
				if (pay >= change[i]) {
					result[i] = pay / change[i];
					pay %= change[i];
					sb.append(result[i]).append(" ");
				} //
				else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}