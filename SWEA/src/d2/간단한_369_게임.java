package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 3 6 9가 들어가는 숫자는 들어가는 갯수만큼 -를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.22
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.22  Younghun Yu  최초 생성
 */
public class 간단한_369_게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= Integer.parseInt(n); i++) {
			String str = String.valueOf(i);
			// 3. 6. 9 포함일 경우
			if (str.contains("3") || str.contains("6") || str.contains("9")) {
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					if (c == '3' || c == '6' || c == '9') {
						sb.append("-");
					}
				}
				sb.append(" ");
			} //
			else {
				sb.append(i).append(" ");
			}
		}

		br.close();
		System.out.println(sb);
	}
}
