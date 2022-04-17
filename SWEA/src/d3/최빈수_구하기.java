package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @packageName : d3
 * @description : 최빈수를 구하는 프로그램
 * @author : Younghun Yu
 * @date : 2022.04.17
 * ===========================================================
 *     DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022.04.17  Younghun Yu  최초 생성
 */
public class 최빈수_구하기 {

	public static void main(String[] args) {

		BufferedReader br = null;
		StringTokenizer st = null;
		int tc = 0; // Test Case
		int n = 0; // Test Case Number
		int[] score = null; // 점수표
		int[] counting = null; // Counting Sort를 이용하여 최빈수를 찾기 - 인덱스 개수 저장 배열
		StringBuilder sb = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			tc = Integer.parseInt(br.readLine());
			sb = new StringBuilder();

			for (int t = 1; t <= tc; t++) {
				n = Integer.parseInt(br.readLine());
				// 최빈수를 찾을 점수 입력
				st = new StringTokenizer(br.readLine());
				sb.append("#").append(n).append(" ");

				score = new int[1000]; // 학생 수 1000명
				counting = new int[101]; // 점수 0 ~ 100

				// 인덱스 카운트
				for (int i = 0; i < score.length; i++) {
					score[i] = Integer.parseInt(st.nextToken());
					counting[score[i]]++;
				}

				// 최빈수 찾기
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < counting.length; i++) {
					max = Math.max(max, counting[i]);
				}

				// 최빈수가 여러 개일 경우 최빈수들을 담기 위한 리스트
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < counting.length; i++) {
					if (max == counting[i]) {
						list.add(i);
					}
				}

				// 최빈수 설정
				int mode = -1;
				if (list.size() > 1) {
					for (int i = 0; i < list.size(); i++) {
						mode = Math.max(mode, list.get(i));
					}
				} //
				else {
					mode = list.get(0);
				}

				sb.append(mode).append("\n");
			}

			br.close();

			System.out.println(sb);

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