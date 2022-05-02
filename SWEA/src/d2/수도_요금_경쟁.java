package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : A사, B사의 수도요금을 비교하여 수도요금이 더 적게 나오는 회사의 요금을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.02
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.02  Younghun Yu  최초 생성
 */
public class 수도_요금_경쟁 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken()); // A사 1L 당 요금
			int q = Integer.parseInt(st.nextToken()); // B사 기본요금
			int r = Integer.parseInt(st.nextToken()); // B사 기본요금의 경계량
			int s = Integer.parseInt(st.nextToken()); // B사 1L 당 요금
			int w = Integer.parseInt(st.nextToken()); // 한 달간 사용하는 양

			int min = Integer.MAX_VALUE;
			if (w > r) {
				min = Math.min(p * w, q + (s * (w - r)));
			} //
			else {
				min = Math.min(p * w, q);
			}

			sb.append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}