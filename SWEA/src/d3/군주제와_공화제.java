package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : d3 군주제와 공화제 문제풀이. 해답을 찾지 못하여 swea 정답 코드 사용.
 * @author : Younghun Yu
 * @date : 2022.05.10
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.10  Younghun Yu  최초 생성
 */
public class 군주제와_공화제 {

	private static int N;
	private static int[] x, y, s, parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			y = new int[N];
			s = new int[N];
			parent = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
				s[i] = Integer.parseInt(st.nextToken());
				parent[i] = i;
			}

			char[] result = new char[N];

			for (int i = 0; i < N; i++) {
				List<Integer> list = findCity(i);
				if (list.isEmpty()) {
					result[i] = 'K';
				} //
				else if (list.size() >= 2) {
					result[i] = 'D';
				} //
				else {
					result[i] = 'P';
					parent[i] = list.get(0);
				}
			}

			for (int i = 0; i < N; i++) {
				if (result[i] == 'P')
					sb.append(find(i) + 1).append(" ");
				else
					sb.append(result[i]).append(" ");
			}
			
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}

	private static int find(int i) {
		if (i == parent[i])
			return i;
		else {
			int p = find(parent[i]);
			parent[i] = p;
			
			return p;
		}
	}

	private static List<Integer> findCity(int i) {
		List<Integer> list = new LinkedList<>();
		double maxThr = Double.MIN_VALUE;
		for (int j = 0; j < N; j++) {
			if (j == i)
				continue;
			double thr = s[j] / (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
			if (thr > s[i]) {
				if (thr == maxThr)
					list.add(j);
				else if (thr > maxThr) {
					maxThr = thr;
					list = new LinkedList<>();
					list.add(j);
				}
			}
		}
		
		return list;
	}
}