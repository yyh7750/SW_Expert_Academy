package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 9자리 이하의 정수 n을 한 쌍의 숫자를 골라 이동하여 최솟값과 최댓값을 구하는 프로그램.
 * @author : Younghun Yu
 * @date : 2022.04.16
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.16  Younghun Yu  최초 생성
 */
public class 숫자_조작 {

	public static void main(String[] args) {

		BufferedReader br = null;
		int tc = 0; // Test Case
		String n = null;
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {

				n = br.readLine();

				sb.append("#").append(t).append(" ");

				String result = getResult(n.split(""));
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

	/**
	 * @methodName : getResult
	 * @description : 최댓값과 최솟값을 구하는 메소드
	 * @param arr
	 * @return
	 *
	 * @author : Younghun Yu
	 * @date : 2022.04.16
	 */
	private static String getResult(String[] arr) {

		StringBuilder sb = new StringBuilder();

		int max = Integer.parseInt(String.join("", arr));
		int min = max;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				String[] tempArr = arr.clone();

				// 값을 하나씩 교체하여 비교
				String temp = tempArr[i];
				tempArr[i] = tempArr[j];
				tempArr[j] = temp;

				// 첫 번째 수가 0이 아닐 경우 최솟값과 최댓값 저장
				if (!tempArr[0].equals("0")) {
					int num = Integer.parseInt(String.join("", tempArr));
					max = Math.max(max, num);
					min = Math.min(min, num);
				}
			}
		}

		sb.append(min).append(" ").append(max);

		return sb.toString();
	}
}