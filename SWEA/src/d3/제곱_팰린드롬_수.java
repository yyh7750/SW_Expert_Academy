package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 주어지는 수 사이의 제곱 팰린드롬 수를 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.15
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.15  Younghun Yu  최초 생성
 */
public class 제곱_팰린드롬_수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());

		boolean[] palendrome = new boolean[(int) Math.sqrt(1000) + 1];
		for (int i = 1; i < palendrome.length; i++) {
			if (solution(i) && solution((int) Math.pow(i, 2))) {
				palendrome[i] = true;
			}
		}

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = (int) Math.ceil(Math.sqrt(Integer.parseInt(st.nextToken())));
			int m = (int) Math.sqrt(Integer.parseInt(st.nextToken()));
			
			int result = 0;
			for(int i = n; i <= m; i++) {
				if(palendrome[i]) {
					result++;
				}
			}
			
			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static boolean solution(int n) {

		String[] num = Integer.toString(n).split("");
		
		for(int i = 0; i < num.length / 2; i++) {
			if(num[i].equals(num[num.length - 1 - i])) {
				continue;
			} //
			else {
				return false;
			}
		}
		
		return true;
	}
}