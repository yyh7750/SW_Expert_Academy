package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @packageName : d2
 * @description : 입력받은 배열이 스도쿠 형태를 가지고 있는지 확인하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.28
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.28  Younghun Yu  최초 생성
 */
public class 스도쿠_검증 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int[][] arr = new int[9][9];

			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (solution(arr)) {
				sb.append(1).append("\n");
			} //
			else {
				sb.append(0).append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}

	private static boolean solution(int[][] arr) {

		boolean p = false;

		for (int i = 0; i < arr.length; i++) {
			Set<Integer> colSet = new HashSet<>();
			Set<Integer> rowSet = new HashSet<>();

			for (int j = 0; j < arr[i].length; j++) {
				rowSet.add(arr[i][j]);
				colSet.add(arr[j][i]);
			}

			if (rowSet.size() != 9 || colSet.size() != 9) {
				p = false;
				break;
			} //
			else {
				p = true;
			}
		}

		if (p) {
			loop: for (int i = 0; i < arr.length; i += 3) {
				for (int j = 0; j < arr.length; j += 3) {
					Set<Integer> set = new HashSet<>();

					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							set.add(arr[i + k][j + l]);
						}
					}

					if (set.size() != 9) {
						p = false;
						break loop;
					} //
					else {
						p = true;
					}
				}
			}
		}

		return p;
	}
}