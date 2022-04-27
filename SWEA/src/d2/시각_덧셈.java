package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 입력 받은 4가지 숫자를 시, 분으로 나누어 서로 더한 값을 12시간제로 표현하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.27
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.27  Younghun Yu  최초 생성
 */
public class 시각_덧셈 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int hour = a + c;
			int minute = b + d;

			if (hour > 12) {
				hour -= 12;
			}
			if (minute > 60) {
				minute -= 60;
				hour += 1;
			}

			sb.append(hour).append(" ").append(minute).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}