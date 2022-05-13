package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : https://github.com/sur2/SWEA/blob/master/10761.%20%EC%8B%A0%EB%A2%B0%20D3.java
 * @author : Younghun Yu
 * @date : 2022.05.12
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.05.12  Younghun Yu  최초 생성
 */
public class 신뢰 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			String[] sArr = new String[n];
			int[] iArr = new int[n];
			int sIndex = 0;
			int iIndex = 0;
			while (st.hasMoreTokens()) {
				sArr[sIndex] = st.nextToken();
				iArr[iIndex] = Integer.parseInt(st.nextToken());
				sIndex++;
				iIndex++;
			}

			Robot O = new Robot();
			Robot B = new Robot();

			int currentTime = 0;

			for (int i = 0; i < n; i++) {
				if (sArr[i].equals("O")) {
					int move = Math.abs(O.location - iArr[i]);
					int afterTime = currentTime - O.time;

					if (currentTime == O.time) {
						O.time += move + 1;
						O.location = iArr[i];
						currentTime = O.time;
					} //
					else {
						if (afterTime > move) {
							currentTime++;
							O.time = currentTime;
							O.location = iArr[i];
						} //
						else {
							currentTime += move - afterTime + 1;
							O.time = currentTime;
							O.location = iArr[i];
						}
					}
				} //
				else {
					int move = Math.abs(B.location - iArr[i]);
					int afterTime = currentTime - B.time;
					
					if(currentTime == B.time) {
						B.time += move + 1;
						B.location = iArr[i];
						currentTime = B.time;
					} //
					else {
						if(afterTime > move) {
							currentTime++;
							B.time = currentTime;
							B.location = iArr[i];
						} //
						else {
							currentTime += move - afterTime + 1;
							B.time = currentTime;
							B.location = iArr[i];
						}
					}
				}
			}
			
			sb.append(currentTime).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}

class Robot {
	public int time = 0;
	public int location = 1;
}