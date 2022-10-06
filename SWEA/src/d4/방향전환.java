package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방향전환 {

	private static int cnt, result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			result = Integer.MAX_VALUE;

			solution(false, x1, y1, x2, y2);
			solution(true, x1, y1, x2, y2);

			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	/**
	 * Description : 세로, 가로 방향 중 한가지 먼저 실행. 이후 둘 중 최단거리를 비교.
	 * 
	 * @param dir : false=세로시작, true=가로시작.
	 * @param x1  : 시작지점 좌표
	 * @param y1  : 시작지점 좌표
	 * @param x2  : 목표지점 좌표
	 * @param y2  : 목표지점 좌표
	 * @return void
	 *
	 * @date 2022. 8. 22.
	 * @author 유영훈
	 */
	private static void solution(boolean dir, int x1, int y1, int x2, int y2) {
		cnt = 0;

		while (!(x1 == x2 && y1 == y2)) {
			// 세로 시작일 경우 y1값 변경
			if (dir) {
				if (y1 < y2) {
					y1++;
				} //
				else {
					y1--;
				}
				dir = false;
				cnt++;
			}
			// 가로 시작일 경우 x1값 변경
			else {
				if (x1 < x2) {
					x1++;
				} //
				else {
					x1--;
				}
				dir = true;
				cnt++;
			}
		}

		result = Math.min(cnt, result);
	}
}