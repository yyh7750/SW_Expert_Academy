package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 주어진 정수의 앞 두 자리를 우효슷자로 표기하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.11
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.11  Younghun Yu  최초 생성
 */
public class 유효숫자_표기 {

	public static void main(String[] args) {

		BufferedReader br = null;
		int testCase = 0;
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			testCase = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			// 테스트 케이스 수만큼 반복입력
			for (int i = 0; i < testCase; i++) {
				String testNum = br.readLine();

				// 유효숫자로 변환하기 위한 함수호출 및 결과를 출력해줄 StringBuilder에 저장
				String result = changeSignificantFigures(testNum);
				sb.append("#").append(i + 1).append(" ").append(result).append("\n");
			}

			br.close();

			System.out.println(sb);

		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
		}
	}

	/**
	 * @methodName : changeSignificantFigures
	 * @description : 유효숫자로 바꿔주는 메소드
	 * @param testNum
	 * @return
	 *
	 * @author : Younghun Yu
	 * @date : 2022.04.11
	 */
	private static String changeSignificantFigures(String testNum) {

		// 앞 3자리를 잘라 int형 변수로 만들어준다.
		int n = Integer.parseInt(testNum.substring(0, 3));
		// 10의 제곱승을 표현해주기 위한 숫자
		int numLength = testNum.length();

		// 유효숫자 구하기
		double significantFigures = Math.round(n / 10.0) / 10.0;

		StringBuilder sb = null;
		// 유효숫자가 반올림되어 앞자리가 10이상이 될 경우
		if (significantFigures >= 10) {
			sb = new StringBuilder();
			sb.append(significantFigures / 10).append("*10^").append(numLength);
		} //
		else {
			sb = new StringBuilder();
			sb.append(significantFigures).append("*10^").append(numLength - 1);
		}

		return sb.toString();
	}
}