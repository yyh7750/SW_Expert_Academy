package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 각각의 개인 소득이 주어질 때 평균 소득 이하의 수를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.18
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.18  Younghun Yu  최초 생성
 */
public class 소득_불균형 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int sum = 0;

			int[] earnings = new int[n];
			for (int i = 0; i < n; i++) {
				earnings[i] = Integer.parseInt(st.nextToken());
				sum += earnings[i];
			}

			double avg = (double) sum / n;

			int count = 0;
			for (int i = 0; i < earnings.length; i++) {
				if (avg >= earnings[i]) {
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}