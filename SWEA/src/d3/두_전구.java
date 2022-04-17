package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 주어지는 2가지의 시간 사이(4개의 수) 중 서로 겹치는 시간을 찾는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.17
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.17  Younghun Yu  최초 생성
 */
public class 두_전구 {

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

				int a = Integer.parseInt(st.nextToken());	// 첫 번째 전구가 켜지는 시간
				int b = Integer.parseInt(st.nextToken());	// 첫 번째 전구가 꺼지는 시간
				int c = Integer.parseInt(st.nextToken());	// 두 번째 전구가 켜지는 시간
				int d = Integer.parseInt(st.nextToken());	// 두 번째 전구가 꺼지는 시간

				/**
				 * 서로 겹치는 시간을 확인하기 위한 공식 
				 * 각 최댓값 중 작은 수 - 각 최솟값 중 큰 수
				 */
				int result = Math.min(b, d) - Math.max(a, c);
				if (result < 0) {
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