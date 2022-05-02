package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @packageName : d2
 * @description : d2 새로운 불면증 치료법 문제풀이
 * @author : Younghun Yu
 * @date : 2022.05.02
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.02  Younghun Yu  최초 생성
 */
public class 새로운_불면증_치료법 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<>();

			int i = 0;
			while (set.size() != 10) {
				i++;
				int temp = n * i;

				String[] nArr = String.valueOf(temp).split("");
				for (int j = 0; j < nArr.length; j++) {
					set.add(Integer.parseInt(nArr[j]));
				}
			}

			sb.append(n * i).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}