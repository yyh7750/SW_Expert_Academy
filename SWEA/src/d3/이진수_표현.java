package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 10진수를 2진수로 바꿔 마지막 자릿수부터 n개만큼 "1"로 표시되어 있는지 확인하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.15
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.15  Younghun Yu  최초 생성
 */
public class 이진수_표현 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			String binary = Integer.toBinaryString(m);

			int size = binary.length() - n;
			if (size < 0) {
				size = binary.length();
			}
			String result = binary.substring(size);

			if (result.contains("0")) {
				sb.append("OFF").append("\n");
			} //
			else {
				if (result.isEmpty()) {
					sb.append("OFF").append("\n");
				} //
				else {
					sb.append("ON").append("\n");
				}
			}
		}

		br.close();
		System.out.println(sb);
	}
}