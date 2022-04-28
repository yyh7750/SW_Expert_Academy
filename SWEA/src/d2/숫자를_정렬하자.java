package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 숫자를 오름차순으로 정렬하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.28
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.28  Younghun Yu  최초 생성
 */
public class 숫자를_정렬하자 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}