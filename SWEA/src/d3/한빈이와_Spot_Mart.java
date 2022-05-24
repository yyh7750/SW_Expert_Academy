package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 과자의 개수 n, 무게 제한 m, 과자의 무게 배열이 주어질때 
 * 				  두 개의 과자를 선택하여 최대 무게를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.24
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.24  Younghun Yu  최초 생성
 */
public class 한빈이와_Spot_Mart {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int result = -1;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] + arr[j] <= m) {
						result = Math.max(result, arr[i] + arr[j]);
					}
				}
			}

			sb.append(result).append("\n");
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}