package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 두 정수를 곱한 값이 연속되는 숫자로 이루어져 있는지 검사하는 프로그램(정수가 여러개일 경우 두 정수를 골라 곱한 값이 최대인 것을 출력)
 * @author : Younghun Yu
 * @date : 2022.05.22
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.22  Younghun Yu  최초 생성
 */
public class 최고의_쌍 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = -1;

			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					int result = arr[i] * arr[j];
					if (solution(result)) {
						max = Math.max(max, result);
					}
				}
			}

			sb.append(max);
			sb.append("\n");
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static boolean solution(int num) {

		if (1 <= num && num <= 9) {
			return true;
		}

		boolean p = false;

		int n = num % 10;
		num /= 10;

		while (num > 0) {
			if (n - 1 == num % 10) {
				p = true;
			} //
			else {
				p = false;
				break;
			}

			n = num % 10;
			num /= 10;
		}

		return p;
	}
}