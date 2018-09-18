package com.dictionary.utils;

import com.dictionary.view.dto.Vocabulary;

import java.util.Map;

public final class Utils {

	private Utils() {
	}

	static RetCount matching(String strInputA, String strInputB, int lngLen) {
		RetCount tempRet = new RetCount();
		int posStrA;
		int posStrB;
		String strTempA;
		String strTempB;
		tempRet.lngCountLike = 0;
		tempRet.lngSubRows = 0;

		for (posStrA = 0; posStrA <= strInputA.length() - lngLen; posStrA++) {
			strTempA = strInputA.substring(posStrA, posStrA + lngLen);
			for (posStrB = 0; posStrB <= strInputB.length() - lngLen; posStrB++) {
				strTempB = strInputB.substring(posStrB, posStrB + lngLen);
				if (strTempA.compareTo(strTempB) == 0) {
					tempRet.lngCountLike = (tempRet.lngCountLike + 1);
					break;
				}
			}
			tempRet.lngSubRows = (tempRet.lngSubRows + 1);
		}
		return tempRet;
	}

	public static int indistinctMatching(int MaxMatching, String strInputMatching, String strInputStandart) {
		RetCount gret = new RetCount();
		RetCount tret = new RetCount();
		int lngCurLen;

		if (MaxMatching == 0 || strInputMatching.length() == 0 || strInputStandart.length() == 0)
			return 0;

		gret.lngCountLike = 0;
		gret.lngSubRows = 0;

		for (lngCurLen = 1; lngCurLen <= MaxMatching; lngCurLen++) {
			tret = matching(strInputMatching, strInputStandart, lngCurLen);
			gret.lngCountLike = gret.lngCountLike + tret.lngCountLike;
			gret.lngSubRows = gret.lngSubRows + tret.lngSubRows;

			tret = matching(strInputStandart, strInputMatching, lngCurLen);
			gret.lngCountLike = gret.lngCountLike + tret.lngCountLike;
			gret.lngSubRows = gret.lngSubRows + tret.lngSubRows;
		}

		if (gret.lngSubRows == 0)
			return 0;

		return (int) (gret.lngCountLike * 100.0 / gret.lngSubRows);

	}

	public static double calculateMark(Map<String, Vocabulary> vocab, Map<String, Integer> answers100, int withMistake, int notRight) {
		int size5 = 0, size4 = 0, size3 = 0, right5 = 0, right4 = 0, right3 = 0;

		for (String k : vocab.keySet()) {
			int i = vocab.get(k).getMark();
			if (i == 5) {
				size5++;
			}
			else if (i == 4) {
				size4++;
			}
			else {
				size3++;
			}
		}

		for (String k : answers100.keySet()) {
			int i = vocab.get(k).getMark();
			if (i == 5) {
				right5++;
			}
			else if (i == 4) {
				right4++;
			}
			else {
				right3++;
			}
		}

		if (size5 == 0) {
			size5 = 1;
		}
		if (size4 == 0) {
			size4 = 1;
		}
		if (size3 == 0) {
			size3 = 1;
		}

		return (1.0 * right5 / size5) * 5 + (1.0 * right4 / size4) * 4 + (1.0 * right3 / size3) * 3 - 0.1 * withMistake - 0.2 * notRight;
	}

	private static class RetCount {
		public long lngSubRows = 0;
		public long lngCountLike = 0;
	}

}
