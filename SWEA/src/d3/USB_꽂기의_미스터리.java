package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : d3 USB 꽂기의 미스터리 문제풀이
 * @author : Younghun Yu
 * @date : 2022.05.26
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.26  Younghun Yu  최초 생성
 */
public class USB_꽂기의_미스터리 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; ++t) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			double p = Double.parseDouble(st.nextToken());
			double q = Double.parseDouble(st.nextToken());
			
			String result = "YES";

			double s1 = (1 - p) * q;
			double s2 = p * (1 - q) * q;
			
			if (s1 >= s2) {
				result = "NO";
			}

			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}