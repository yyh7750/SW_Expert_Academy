package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 카드의 유효기간이 연, 월 순인지 월, 연 순인지 판단하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.18
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.18  Younghun Yu  최초 생성
 */
public class 유효기간 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String str = br.readLine();

			int front = Integer.parseInt(str.substring(0, 2));
			int back = Integer.parseInt(str.substring(2, 4));

			if (front > 0 && front <= 12) {
				if (back > 0 && back <= 12) {
					sb.append("AMBIGUOUS").append("\n");
				} //
				else {
					sb.append("MMYY").append("\n");
				}
			} //
			else {
				if (back > 0 && back <= 12) {
					sb.append("YYMM").append("\n");
				} //
				else {
					sb.append("NA").append("\n");
				}
			}
		}

		br.close();
		System.out.println(sb);
	}
}