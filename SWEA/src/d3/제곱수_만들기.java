package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 소인수분해를 이용하여 제곱수를 만드는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.11
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.11  Younghun Yu  최초 생성
 */
public class 제곱수_만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());

			int result = 1;
			int a = 2;
			int count = 0;
			
			while (a <= n) {
				if (n % a == 0) {
					count++;
					n /= a;
				} //
				else {
					if(count % 2 != 0) {
						result *= a;
					}
					a++;
					count = 0;
				}
			}
			
			if(count % 2 != 0) {
				result *= a;
			}

			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}