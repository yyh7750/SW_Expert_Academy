package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 주어진 횟수만큼 최고점에서 최저점으로 평탄화 작업을 진행 후 최고점과 최저점의 높이를 반환하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.21
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.21  Younghun Yu  최초 생성
 */
public class Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int dump = Integer.parseInt(br.readLine());
			
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			
			// 배열 입력
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[arr.length -1] -= 1;
				arr[0] += 1;
			}
			
			Arrays.sort(arr);
			sb.append(arr[arr.length -1] - arr[0]).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}