package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : SWEA D3 문제풀이 최대 상금. 풀이 실패로 goyeseul님의 코드 참고
 * @author : Younghun Yu
 * @date : 2022.04.19
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.19  Younghun Yu  최초 생성
 */
public class 최대_상금 {

	private static int[] arr;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();	// 숫자판 정보
			n = Integer.parseInt(st.nextToken());	// 교환횟수

			char[] c = str.toCharArray();
			arr = new int[c.length];
			for (int i = 0; i < c.length; i++) {
				arr[i] = c[i] - '0';
			}

			changeNumber(0, 0);

			sb.append("#").append(t).append(" ");
			for (int i : arr) {
				sb.append(i);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void changeNumber(int idx, int count) {
		if (count >= n) {
			return;
		}

		if (idx == arr.length - 1) { // 10과 1만 계속 바꾼다.
			if (arr[idx] < arr[idx - 1]) { // 정렬 똑바로 됨!
				for (int i = 0; i < arr.length; i++) {
					if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
						changeNumber(idx, n); // 같은 거 계속 교환하면 되니까 바로 종료조건으로 간다.
						return;
					}
				}
			}

			int temp = arr[idx - 1];
			arr[idx - 1] = arr[idx];
			arr[idx] = temp;
			changeNumber(idx, count + 1);
			return;
		}

		int countIndex = -1;

		for (int i = 0; i < arr.length; i++) { // 자기 자리 찾음
			if (arr[i] >= arr[idx]) {
				countIndex++;
			}
		}

		int max = 0;
		int index = 0;

		for (int i = idx; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
				index = i;
			} //
			else if (arr[i] == max) {
				if (i <= countIndex) { // 넘어가지만 않으면 상관없음
					max = arr[i];
					index = i;
				}
			}
		}

		if (arr[idx] == max) { // 지금 자리가 제자리면 안바꿈
			changeNumber(idx + 1, count);
			return;
		}

		int temp = arr[idx];
		arr[idx] = max;
		arr[index] = temp;

		changeNumber(idx + 1, count + 1);
	}
}