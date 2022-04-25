package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 학생 수와 총점에 맞게 성적을 부과하여 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.25
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.25  Younghun Yu  최초 생성
 */
public class 조교의_성적_매기기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int student = 0;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int k = 0;
		double[] total = null;

		String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			student = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			double temp = 0.0;
			total = new double[student];
			for (int i = 0; i < student; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				total[i] = a * 0.35 + b * 0.45 + c * 0.2;

				if (k == i + 1) {
					temp = total[i];
				}
			}

			Arrays.sort(total);

			int idx = -1;
			for (int i = 0; i < student; i++) {
				if (total[i] == temp) {
					idx = i;
					break;
				}
			}

			int ans = idx / (student / 10);
			sb.append(grade[ans]).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}