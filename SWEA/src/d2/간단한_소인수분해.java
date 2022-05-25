package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d2
 * @description : N = 2^a x 3^b x 5^c x 7^d x 11^e 일 때 a, b, c, d, e를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.01
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.01  Younghun Yu  최초 생성
 */
public class 간단한_소인수분해 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			int a = 0, b = 0, c = 0, d = 0, e = 0;
			
			while(n > 0) {
				if(n % 2 == 0) {
					n /= 2;
					a++;
				} //
				else if(n % 3 == 0) {
					n /= 3;
					b++;
				} //
				else if(n % 5 == 0) {
					n /= 5;
					c++;
				} //
				else if(n % 7 == 0) {
					n /= 7;
					d++;
				} //
				else if(n % 11 == 0) {
					n /= 11;
					e++;
				} //
				else {
					break;
				}
			}
			
			sb.append(a).append(" ");
			sb.append(b).append(" ");
			sb.append(c).append(" ");
			sb.append(d).append(" ");
			sb.append(e).append(" ");
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}