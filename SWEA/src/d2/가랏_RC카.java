package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 가속, 감속을 하는 RC카의 최종 이동거리를 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.03
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.03  Younghun Yu  최초 생성
 */
public class 가랏_RC카 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int time = Integer.parseInt(br.readLine());

			int distance = 0;
			int speed = 0;
			for (int a = 0; a < time; a++) {
				st = new StringTokenizer(br.readLine());

				int command = Integer.parseInt(st.nextToken());
				int shift = 0;
				if (command != 0) {
					shift = Integer.parseInt(st.nextToken());
				}

				if (command == 1) {
					speed += shift;
					distance += speed;
				} //
				else if (command == 2) {
					if (shift > speed) {
						speed = 0;
					} //
					else {
						speed -= shift;
					}
					distance += speed;
				} //
				else {
					distance += speed;
				}
			}

			sb.append(distance).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}