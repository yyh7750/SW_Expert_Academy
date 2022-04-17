package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 최소 3명으로 구성된 조의 수의 최댓값을 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.17
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.17  Younghun Yu  최초 생성
 */
public class 조별과제 {

	public static void main(String[] args) {

		BufferedReader br = null;
		int tc = 0; // Test Case
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {
				sb.append("#").append(t).append(" ");

				// 전체 학생 수
				int n = Integer.parseInt(br.readLine());
				sb.append(n / 3).append("\n");
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