package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : pi-1, pi, pi+1 중 pi가 최솟값도, 최댓값도 아니라면 pi를 평범한 숫자라고 정의하여 순열 중 평범한 숫자를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.04
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.04  Younghun Yu  최초 생성
 */
public class 평범한_숫자 {

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

			int count = 0;
			for (int i = 1; i < n - 1; i++) {
				if ((arr[i] > arr[i - 1] && arr[i] < arr[i + 1]) || (arr[i] < arr[i - 1] && arr[i] > arr[i + 1])) {
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}