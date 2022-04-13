package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 
 * 모든 정수 1 ≤ i ≤ N 에 대해, 
 * 좌표 x에 분무기를 놓았을 경우 닫힌 구간 [x - D, x + D]에 심긴 모든 꽃들에 물을 줄 수 있다.
 * N과 D가 주어질 때, 모든 꽃이 한 개 이상의 분무기에서 물을 받을 수 있도록 하기 위해 
 * 필요한 최소한의 분무기 수를 구하는 프로그램.
 * 
 * @author : Younghun Yu
 * @date : 2022.04.13
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.13  Younghun Yu  최초 생성
 */
public class d3_1차원_정원 {

	public static void main(String[] args) {

		BufferedReader br = null;
		StringTokenizer st = null;
		int tc = 0; // Test Case
		StringBuilder sb = null; // 결과 출력을 위한 StringBuilder

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int i = 1; i <= tc; i++) {
				// n과 d 입력
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				// 분무기로 한 번에 물을 줄 수 있는 범위(양)
				int sprayer = d * 2 + 1;

				int result = 0;

				if (n % sprayer != 0) {
					result = (n / sprayer) + 1;
				} //
				else {
					result = n / sprayer;
				}

				sb.append("#").append(i).append(" ").append(result).append("\n");
			}

			System.out.println(sb);

			br.close();
		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
		}
	}
}