package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 주어진 두 수의 합을 24시간제 시간으로 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.17
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.17  Younghun Yu  최초 생성
 */
public class D3_24시간 {

	public static void main(String[] args) {

		BufferedReader br = null;
		StringTokenizer st = null;
		int tc = 0; // Test Case
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {
				sb.append("#").append(t).append(" ");
				st = new StringTokenizer(br.readLine());

				int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

				if (result > 24) {
					result -= 24;
				} //
				else if (result == 24) {
					result = 0;
				}

				sb.append(result).append("\n");
			}

			System.out.println(sb);

		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
			System.out.println(ioException.getMessage());
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
			System.out.println(numberException.getMessage());
		}
	}
}