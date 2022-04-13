package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : #과 .으로 이루어진 N*N 격자판에서 #으로 이루어진 정사각형을 찾는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.13
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.13  Younghun Yu  최초 생성
 */
public class 정사각형_판정 {

	public static void main(String[] args) {

		BufferedReader br = null;
		int tc = 0; // Test Case
		int n = 0; // N * N의 정사각형 격자판을 만들기 위한 숫자 n
		char[][] arr = null; // 격자판을 만들기 위한 2차원 배열
		boolean[][] visited = null; // 방문한 값(정사각형인지 확인하기 위한)을 저장하기 위한 배열
		StringBuilder sb = null; // 결과값을 담기 위한 StringBuilder

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {
				// 격자판 생성
				n = Integer.parseInt(br.readLine());
				arr = new char[n][n];
				visited = new boolean[n][n];

				int startX = -1;
				int startY = -1;

				for (int i = 0; i < arr.length; i++) {
					String row = br.readLine();
					for (int j = 0; j < arr[i].length; j++) {
						// 격자판 입력
						arr[i][j] = row.charAt(j);

						// 첫번째 #을 만났을때
						if (arr[i][j] == '#') {
							// 시작점 설정
							if (startX == -1 && startY == -1) {
								startX = i;
								startY = j;
							}
						}
					}
				}

				int length = 0;

				// 정사각형 길이 찾기
				for (int i = startY; i < arr.length; i++) {
					if (arr[startX][i] == '#') {
						length++;
					} //
					else {
						break;
					}
				}

				// 길이를 구했으므로 정사각형인지 판정하기
				boolean judgment = true;
				loop: for (int i = startX; i < startX + length; i++) {
					for (int j = startY; j < startY + length; j++) {
						// 방문처리
						visited[i][j] = true;
						// 길이만큼 #이 아닐경우 정사각형이 아님
						if (arr[i][j] != '#') {
							judgment = false;
							break loop;
						}
					}
				}
				loop: for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						// 방문하지 않은곳, 정사각형의 범위를 벗어난 곳에서 #이 나와면 안된다.
						if (arr[i][j] == '#' && !visited[i][j]) {
							judgment = false;
							break loop;
						}
					}
				}

				// 결과 출력
				String result = judgment ? "yes" : "no";
				sb.append("#").append(t).append(" ").append(result).append("\n");
			}

			System.out.println(sb);

			br.close();
		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
			System.out.println(ioException.getMessage());
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
			System.out.println(numberException.getMessage());
		}
	}
}