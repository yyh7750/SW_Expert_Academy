package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 입력받은 카드 값의 합이 21보다 작을 때 카드를 한 장 더 뽑아 21보다 크거나 같다면 STOP, 작다면 GAZUA 출력.
 * @author : Younghun Yu
 * @date : 2022.05.23
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.23  Younghun Yu  최초 생성
 */
public class 카드_게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());

			int[] score = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
			int[] counting = { 4, 4, 4, 4, 4, 4, 4, 4, 16, 4 };
			int sum = 0;
			int total = 52 - n;
			int count = 0;

			for (int i = 0; i < n; i++) {
				int card = Integer.parseInt(br.readLine());
				sum += card;
				counting[card - 2]--;
			}

			for (int j = 0; j < counting.length; j++) {
				if (sum + score[j] > 21) {
					count += counting[j];
				}
			}

			if (count <= total - count) {
				sb.append("GAZUA");
			} //
			else {
				sb.append("STOP");
			}

			sb.append("\n");
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}