package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName : d3
 * @description : 0이 입력될 경우 마지막 숫자 제거. 그 외의 모든 숫자의 합 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.28
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.28  Younghun Yu  최초 생성
 */
public class 제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int k = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < k; i++) {
				int num = Integer.parseInt(br.readLine());

				if (num > 0) {
					list.add(num);
				} //
				else {
					list.remove(list.size() - 1);
				}
			}

			int result = 0;
			for (int i : list) {
				result += i;
			}

			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}