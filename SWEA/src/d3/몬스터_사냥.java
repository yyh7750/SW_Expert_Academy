package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 용사가 몬스터에게 가하는 총 데미지를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.06
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.06  Younghun Yu  최초 생성
 */
public class 몬스터_사냥 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken()); // 기본 데미지
			int l = Integer.parseInt(st.nextToken()); // 용사의 레벨
			int n = Integer.parseInt(st.nextToken()); // 때린 횟수

			double totalDamage = 0.0;
			for (int i = 0; i < n; i++) {
				double nowDamage = d * (1 + i * ((double) l / 100.0));
				totalDamage += nowDamage;
			}

			sb.append((int) totalDamage).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}