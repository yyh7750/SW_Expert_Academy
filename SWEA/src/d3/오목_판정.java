package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 'o'가 어떤 방향으로든 5개 이상 연속될 경우 YES, 아닐 경우 NO를 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.07
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.07  Younghun Yu  최초 생성
 */
public class 오목_판정 {

	private static int[][] circuit = { { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } }; // 오른쪽, 아래왼쪽, 아래, 아래오른쪽
	private static char[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());
			board = new char[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			String result = "NO";
			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'o') {
						for (int k = 0; k < 4; k++) {
							int count = counting(i, j, k);
		
							if (count == 5) {
								result = "YES";
								break outer;
							}
						}
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int counting(int i, int j, int k) {
		int count = 1; // 돌을 먼저 발견했기 때문에 1로 초기화
		int dx = i, dy = j;
		
		for (int index = 0; index < 4; index++) {
			dx = dx + circuit[k][0];
			dy = dy + circuit[k][1];
		
			if (dx >= 0 && dx < board.length && dy >= 0 && dy < board.length && board[dx][dy] == 'o') {
				count++;
			} //
			else {
				break;
			}
		}
		
		return count;
	}
}