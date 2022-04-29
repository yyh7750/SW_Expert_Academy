package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 
 * n배열과 m배열을 입력받아 짧은 배열을 한칸씩 움직이며 서로의 원소를 곱한 값을
 * 더하면서 더한 값중 최댓값을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.29
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.29  Younghun Yu  최초 생성
 */
public class 두_개의_숫자열 {

	private static int[] nArr = null;
	private static int[] mArr = null;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			nArr = new int[n];
			mArr = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < nArr.length; i++) {
				nArr[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < mArr.length; i++) {
				mArr[i] = Integer.parseInt(st.nextToken());
			}

			int result = solution();

			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static int solution() {

		int max = Integer.MIN_VALUE;

		if (nArr.length > mArr.length) {

			for (int i = 0; i < nArr.length - mArr.length + 1; i++) {
				int temp = 0;
				for (int j = 0; j < mArr.length; j++) {
					temp += nArr[j + i] * mArr[j];
				}
				max = Math.max(max, temp);
			}
		} //
		else if (nArr.length < mArr.length) {

			for (int i = 0; i < mArr.length - nArr.length + 1; i++) {
				int temp = 0;
				for (int j = 0; j < nArr.length; j++) {
					temp += nArr[j] * mArr[j + i];
				}
				max = Math.max(max, temp);
			}
		} //
		else {
			for (int i = 0; i < nArr.length; i++) {
				max += nArr[i] * mArr[i];
			}
		}

		return max;
	}
}