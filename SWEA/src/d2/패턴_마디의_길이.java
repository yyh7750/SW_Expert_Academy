package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : 특정 단어가 반복되는 문자열이 주어질 경우 반복되는 문자열의 길이를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.22
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.22  Younghun Yu  최초 생성
 */
public class 패턴_마디의_길이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			String str = br.readLine();
			
			for(int i = 1; i <= 10; i++) {
				String prev = str.substring(0, i);
				String next = str.substring(i, i+i);
				
				if(prev.equals(next)) {
					sb.append(prev.length());
					break;
				}
			}
			
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}