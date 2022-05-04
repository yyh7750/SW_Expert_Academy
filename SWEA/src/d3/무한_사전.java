package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 사전상 두 단어 사이에 다른 단어가 존재할 수 있는지 검사하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.04
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.04  Younghun Yu  최초 생성
 */
public class 무한_사전 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String p = br.readLine();
			String q = br.readLine();
			
			if((p + "a").equals(q)) {
				sb.append("N").append("\n");
			} //
			else {
				sb.append("Y").append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}