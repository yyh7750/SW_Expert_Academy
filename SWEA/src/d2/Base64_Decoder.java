package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

/**
 * @packageName : d2
 * @description : Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여 원문을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.01
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.01  Younghun Yu  최초 생성
 */
public class Base64_Decoder {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			String encode = br.readLine();
			String decode = new String(Base64.getDecoder().decode(encode));
			sb.append(decode).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}