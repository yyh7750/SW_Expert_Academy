package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : n 크기의 문자열이 주어질 때 석찬이가 해당 문자열을 받아쓰기 하여 맞히는 갯수를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.21
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.21  Younghun Yu  최초 생성
 */
public class 석찬이의_받아쓰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			String[] answer = br.readLine().split("");
			String[] submit = br.readLine().split("");

			int count = 0;
			for (int i = 0; i < n; i++) {
				if (answer[i].equals(submit[i])) {
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}