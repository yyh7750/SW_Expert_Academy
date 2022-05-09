package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 주어지는 x, y 좌표를 토대로 다트 게임 점수를 매기는 프로그램. r^2 = x^2 + y^2
 * @author : Younghun Yu
 * @date : 2022.05.09
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.09  Younghun Yu  최초 생성
 */
public class 다트_게임 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		double[] r = new double[] { //
				Math.pow(20, 2), Math.pow(40, 2), Math.pow(60, 2), Math.pow(80, 2), //
				Math.pow(100, 2), Math.pow(120, 2), Math.pow(140, 2), //
				Math.pow(160, 2), Math.pow(180, 2), Math.pow(200, 2) };
		
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			int result = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				
				for (int j = 0; j < 10; j++) {
					if (Math.pow(x, 2) + Math.pow(y, 2) <= r[j]) {
						result += (10 - j);
						break;
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}