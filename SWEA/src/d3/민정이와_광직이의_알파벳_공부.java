package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @packageName : d3
 * @description : https://4ngs.tistory.com/41 - dfs, bfs 공부 필요
 * @author : Younghun Yu
 * @date : 2022.05.27
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.27  Younghun Yu  최초 생성
 */
public class 민정이와_광직이의_알파벳_공부 {

	private static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			result = 0;
		
			
			boolean[][] arr = new boolean[n][26];
			for (int i = 0; i < n; i++) {
				char[] str = br.readLine().toCharArray();
			
				for (int j = 0; j < str.length; j++) {
					arr[i][str[j] - 'a'] = true;
				}
			}
			
			dfs(0, n, arr, new int[26]);
			
			sb.append(result).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}

	private static void dfs(int depth, int cnt, boolean[][] arr, int[] check) {
		if (depth == cnt) {
			int flag = 0;
			for (int i = 0; i < check.length; i++) {
				if (check[i] >= 1) {
					flag++;
				}
			}
			
			if (flag == 26) {
				result++;
			}
			
			return;
		}

		for (int j = 0; j < arr[depth].length; j++) {
			if (arr[depth][j]) {
				check[j]++;
			}
		}

		dfs(depth + 1, cnt, arr, check);
		
		for (int j = 0; j < arr[depth].length; j++) {
			if (arr[depth][j]) {
				check[j]--;
			}
		}
		
		dfs(depth + 1, cnt, arr, check);
	}
}