package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 두 날짜간의 차이를 일 수로 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.01
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.01  Younghun Yu  최초 생성
 */
public class 날짜_계산기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			int month1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			int month2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());

			Calendar date1 = Calendar.getInstance();
			Calendar date2 = Calendar.getInstance();

			date1.set(Calendar.MONTH, month1 - 1);
			date1.set(Calendar.DATE, day1);

			date2.set(Calendar.MONTH, month2 - 1);
			date2.set(Calendar.DATE, day2);

			long diffSec = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
			long diffDays = diffSec / (24 * 60 * 60) + 1;

			sb.append(diffDays).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}