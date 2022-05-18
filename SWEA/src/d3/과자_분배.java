package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : N개의 과자를 K명의 사람에게 공정하게 분배하였을 경우 많이 받는 사람과 적게 받는 사람의 개수 차이를 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.18
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.18  Younghun Yu  최초 생성
 */
public class 과자_분배 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (n % k == 0) {
				sb.append(0);
			} //
			else {
				sb.append(1);
			}

			sb.append("\n");
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}