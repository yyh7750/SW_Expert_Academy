package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : 트리의 각 노드가 a/b 를 나타내고 있다면, 왼쪽 자식은 a/a+b 를 오른쪽 자식은 a+b/b 일때, 최종 좌표의 노드 값을 출력하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.05.04
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.04  Younghun Yu  최초 생성
 */
public class Calkin_Wilf_tree_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String[] arr = br.readLine().split("");

			int left = 1;
			int right = 1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("L")) {
					right += left;
				} //
				else {
					left += right;
				}
			}

			sb.append(left).append(" ").append(right).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}