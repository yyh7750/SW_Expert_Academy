package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : b, d, p, q로 이루어진 문자열이 주어질 때 이 문자열을 거울로 볼 경우의 문자열을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.12
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.12  Younghun Yu  최초 생성
 */
public class 문자열의_거울상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String str = br.readLine();
			
			for(int i = str.length() - 1; i >= 0; i--) {
				char c = str.charAt(i);
				
				if(c == 'b') {
					sb.append('d');
				} //
				else if(c == 'd') {
					sb.append('b');
				} //
				else if(c == 'p') {
					sb.append('q');
				} //
				else {
					sb.append('p');
				}
			}
		
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}