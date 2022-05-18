package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : P채널과, T채널 중 두 채널을 모두 구독하고 있는 사람의 수를 구하는 프로그램.
 * @author : Younghun Yu
 * @date : 2022.05.18
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.18  Younghun Yu  최초 생성
 */
public class 구독자_전쟁 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int min = 0;
			int max = 0;

			if (a + b > n) {
				min = (a + b) - n;
				if (a > b) {
					max = b;
				} //
				else {
					max = a;
				}
			} //
			else {
				min = 0;
				if (a > b) {
					max = b;
				} //
				else {
					max = a;
				}
			}

			sb.append(max).append(" ").append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}