package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 교환학생 {

	public static void main(String[] args) {

		BufferedReader br = null;
		StringTokenizer st = null;
		int tc = 0; // test case
		int n = 0; // 들어야하는 수업 일수
		int[] arr = null; // 수업이 열리는 날을 저장하는 배열
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			arr = new int[7];
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {
				n = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());

				sb.append("#").append(t).append(" ");

				int count = 0; // 수업이 열리는 날을 카운트
				
				for (int i = 0; i < arr.length; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
					if(arr[i] == 1) {
						count++;
					}
				}

				int middle = (n / count) * 7; // 첫주와 마지막주를 제외한 날
				int sum = (n / count) * count; // 현재까지 채운 수업일

				if (n % count == 0) {
					middle -= 7;
					sum -= count;
				}

				int result = Integer.MAX_VALUE;

				for (int i = 0; i < 7; i++) {
					int a = 0;
					int s = 0;
					for (int j = 0; j < 7; j++) {
						a++;
						if (arr[(i + j) % 7] == 1) {
							s++;
							if (sum + s == n) {
								result = Math.min(result, middle + a);
								break;
							}
						}
					}
				}

				sb.append(result).append("\n");
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