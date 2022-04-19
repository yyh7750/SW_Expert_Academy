package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 1이상 10미만의 숫자만 곱셈을 하는 프로그램. 10 이상일 경우 -1 리턴
 * @author : Younghun Yu
 * @date : 2022.04.19
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.19  Younghun Yu  최초 생성
 */
public class 구구단2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0; // test case
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a >= 10 || b >= 10) {
				sb.append(-1).append("\n");
			} //
			else {
				sb.append(a * b).append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}