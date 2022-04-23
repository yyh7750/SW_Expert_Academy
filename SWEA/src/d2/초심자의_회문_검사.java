package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 거꾸로 읽어도 제대로 읽은 것과 같은 '회문'을 판단하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.23
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.23  Younghun Yu  최초 생성
 */
public class 초심자의_회문_검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String[] strArr = br.readLine().split("");

			boolean p = false;
			for (int i = 0; i < strArr.length; i++) {
				if (i == strArr.length / 2) {
					p = true;
					break;
				} //
				else if (strArr[i].equals(strArr[strArr.length - 1 - i])) {
					p = true;
					continue;
				} //
				else {
					p = false;
					break;
				}
			}

			if (p) {
				sb.append(1).append("\n");
			} //
			else {
				sb.append(0).append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}