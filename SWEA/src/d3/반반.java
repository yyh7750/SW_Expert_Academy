package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @packageName : d3
 * @description : 문자열 S에 정확히 두 개의 서로 다른 문자가 등장하고, 각 문자가 정확히 두 번 등장하는 지 판별하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.04
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.04  Younghun Yu  최초 생성
 */
public class 반반 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String str = br.readLine();

			Set<String> set = new HashSet<String>(Arrays.asList(str.split("")));

			if (set.size() == 2) {
				sb.append("Yes").append("\n");
			} //
			else {
				sb.append("No").append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}