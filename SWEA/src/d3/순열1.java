package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : n까지의 숫자가 주어질 경우, 이 수들이 수열을 이루는지 판단하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.20
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.20  Younghun Yu  최초 생성
 */
public class 순열1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}

			if (set.size() != n) {
				sb.append("No");
			} //
			else {
				sb.append("Yes");
			}

			sb.append("\n");
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}