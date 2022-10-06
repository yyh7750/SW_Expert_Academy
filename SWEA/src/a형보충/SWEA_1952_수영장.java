package a형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {

	private static int[] voucher, swimming;
	private static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			voucher = new int[4];
			swimming = new int[12];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				voucher[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				swimming[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			dfs(0, 0);

			sb.append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static void dfs(int month, int sum) {
		if (month >= 12) {
			min = Math.min(min, sum);
			min = Math.min(min, voucher[3]);
			return;
		}

		dfs(month + 1, sum + voucher[0] * swimming[month]);
		dfs(month + 1, sum + voucher[1]);
		dfs(month + 3, sum + voucher[2]);
	}
}