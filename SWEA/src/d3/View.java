package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 좌, 우로 2칸씩 비어있는 세대의 합을 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.17
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.17  Younghun Yu  최초 생성
 */
public class View {

	public static void main(String[] args) {

		BufferedReader br = null;
		int tc = 0; // Test Case
		StringTokenizer st = null;
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			sb = new StringBuilder();

			for (int t = 1; t <= 10; t++) {
				sb.append("#").append(t).append(" ");

				tc = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());

				int[] arr = new int[tc];
				for (int i = 0; i < tc; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}

				int sum = 0;
				for (int i = 2; i < arr.length - 2; i++) {
					int max = Integer.MIN_VALUE;
					if (arr[i] > arr[i - 2] && arr[i] > arr[i - 1] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
						max = Math.max(arr[i + 2], Math.max(arr[i + 1], Math.max(arr[i - 2], arr[i - 1])));
						sum += arr[i] - max;
					}
				}

				sb.append(sum).append("\n");
			}

			br.close();

			System.out.println(sb);
		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
			System.out.println(ioException.getMessage());
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
			System.out.println(numberException.getMessage());
		}
	}
}