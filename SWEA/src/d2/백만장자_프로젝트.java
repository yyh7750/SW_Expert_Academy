package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : n일 동안 물건을 사재기하여 최대한의 이익을 보는 프로그램 
 * @author : Younghun Yu
 * @date : 2022.04.12
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.12  Younghun Yu  최초 생성
 */
public class 백만장자_프로젝트 {

	public static void main(String[] args) {

		BufferedReader br = null;
		StringTokenizer st = null;
		int tc = 0; // 테스트케이스
		int n = 0; // 2 <= n <= 1,000,000 물건을 사고팔 수 있는 기간
		StringBuilder sb = null; // 결과를 출력할 StirngBuilder

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {

				n = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());

				int[] arr = new int[n]; // 사재기할 매물의 가격을 담은 배열
				for (int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}

				long max = 0; // 최댓값
				long pay = 0; // 지불한 값
				long count = 0; // 가지고 있는 매물의 개수
				long result = 0; // 결과

				for (int i = arr.length - 1; i >= 0; i--) {
					if (arr[i] > max) {
						result += count * max - pay;
						max = arr[i];
						count = 0;
						pay = 0;
					} //
					else {
						count++;
						pay += arr[i];
					}
				}
				result += count * max - pay;

				sb.append("#").append(t).append(" ").append(result).append("\n");
			}

			System.out.println(sb);
			
			br.close();

		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
		}
	}
}