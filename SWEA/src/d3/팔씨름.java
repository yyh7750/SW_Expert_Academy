package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔씨름 {

	public static void main(String[] args) {

		BufferedReader br = null;
		String[] arr = null;
		int n = 0;
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			arr = new String[n];
			sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine();

				int xCount = 0;
				int oCount = 0;

				for (int j = 0; j < arr[i].length(); j++) {
					if (arr[i].charAt(j) == 'x') {
						xCount++;
					} //
					else {
						oCount++;
					}
				}

				if (xCount < oCount || xCount < 8) {
					sb.append("#").append(i + 1).append(" ").append("YES\n");
				} //
				else {
					sb.append("#").append(i + 1).append(" ").append("NO\n");
				}
			}

			System.out.println(sb);

		} //
		catch (IOException ioException) {
			System.out.println("입력 오류. 다시 실행해주세요.");
		} //
		catch (NumberFormatException numberException) {
			System.out.println("올바른 숫자를 입력해주세요. 다시 실행해주세요.");
		}
	}
}