package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 시침만 있는 시계의 시침이 12로부터 몇 도(°) 정도 돌아가 있는지 주어질 때, 지금이 몇 시 몇 분인지 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.20
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.20  Younghun Yu  최초 생성
 */
public class 미니멀리즘_시계 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int rad = Integer.parseInt(br.readLine());
			int h = 0, m = 0;
			
			rad *= 2;
			h = rad / 60;
			m = rad % 60;

			sb.append(h).append(" ").append(m).append("\n");
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}