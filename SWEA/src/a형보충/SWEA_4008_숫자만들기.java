package a형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {

	private static int N, min, max;
	private static int[] calc, num, formula;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			calc = new int[4];
			num = new int[N];
			formula = new int[N - 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				calc[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(0);

			sb.append(max - min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static void dfs(int idx) {
		if (idx == N - 1) {
			int ans = num[0];

			for (int i = 0; i < N - 1; i++) {
				if (formula[i] == 0) {
					ans += num[i + 1];
				} //
				else if (formula[i] == 1) {
					ans -= num[i + 1];
				} //
				else if (formula[i] == 2) {
					ans *= num[i + 1];
				} //
				else if (formula[i] == 3) {
					ans /= num[i + 1];
				}
			}

			max = Math.max(max, ans);
			min = Math.min(min, ans);
			
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (calc[i] != 0) {
				calc[i] -= 1;
				formula[idx] = i;
				dfs(idx + 1);
				calc[i] += 1;
			}
		}
	}
}