package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @packageName : d3
 * @description : 다음 일요일까지 며칠 남았는지 나타내는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.14
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.14  Younghun Yu  최초 생성
 */
public class 일요일 {

	public static void main(String[] args) {

		BufferedReader br = null;
		int tc = 0; // Test Case
		String[] arr = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
		String now = null; // 현재 요일
		StringBuilder sb = null; // 결과를 저장하기 위한 StringBuilder

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {
				now = br.readLine();
				sb.append("#").append(t).append(" ");

				if (now.equals("SUN")) {
					sb.append(7).append("\n");
				} //
				else {
					List<String> list = new ArrayList<String>(Arrays.asList(arr));
					sb.append(6 - list.indexOf(now)).append("\n");
				}
			}

			System.out.println(sb);

			br.close();
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