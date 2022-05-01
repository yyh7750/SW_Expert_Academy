package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 
 * 알파벳 Ci가 주어지고 알파벳 갯수 Ki가 주어질 경우 10의 길이만큼 출력 후 다음 줄에 이어서 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.01
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.01  Younghun Yu  최초 생성
 */
public class 간단한_압축풀기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append("\n");

			int tn = Integer.parseInt(br.readLine());
			
			String[] Ci = new String[tn];
			int[] Ki = new int[tn];
			int count = 0;
			
			for (int i = 0; i < tn; i++) {
				st = new StringTokenizer(br.readLine());
				Ci[i] = st.nextToken();
				Ki[i] = Integer.parseInt(st.nextToken());
			
				for(int j = 0; j < Ki[i]; j++) {
					count++;
					sb.append(Ci[i]);
					
					if(count % 10 == 0) {
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}