package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @packageName : d3
 * @description : 쌍을 이루는 문자는 삭제하고 남는 문자를 사전 순서대로 출력하는 프로그램. 문자가 모두 삭제될 경우 Good 출력.
 * @author : Younghun Yu
 * @date : 2022.05.12
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.12  Younghun Yu  최초 생성
 */
public class 외로운_문자 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			String str = br.readLine();

			int[] arr = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}

			Arrays.sort(arr);

			int[] counting = new int[arr[arr.length - 1] + 1];
			for (int i = 0; i < arr.length; i++) {
				counting[arr[i]]++;
			}

			List<Character> list = new ArrayList<>();
			for (int i = 0; i < counting.length; i++) {
				if (counting[i] % 2 != 0) {
					char c = (char) i;
					list.add(c);
				}
			}
			
			if(list.isEmpty()) {
				sb.append("Good").append("\n");
			} //
			else {
				for(int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
				}
				sb.append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}