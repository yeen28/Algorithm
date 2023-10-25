// https://y-e-un28.tistory.com/538

import java.util.*;

class Solution {
	private final int END_OF_DAY = 23 * 60 + 59;

	public int[] solution(int[] fees, String[] records) {
		Map<String, Integer> carsInfo = new HashMap<>(); // [차량 번호, 주차장에 머문 시간]

		// 각 자동차가 주차장에 머문 시간들을 저장
		for (String record : records) {
			String[] arrRecord = record.split(" ");
			String carNumber = arrRecord[1];
			int weight = "IN".equals(arrRecord[2]) ? -1 : 1;
			int duration = carsInfo.getOrDefault(carNumber, 0);
			duration += toMinute(arrRecord[0]) * weight;
			carsInfo.put(carNumber, duration);
		}

		return calcFee(carsInfo, fees);
	}

	private int[] calcFee(Map<String, Integer> carsInfo, int[] fees) {
		return carsInfo.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.mapToInt(car -> {
					int fee = fees[1];

					int duration = car.getValue();
					if (duration <= 0) duration += END_OF_DAY;

					if (duration > fees[0]) {
						fee += extraFee(duration, fees[0], fees[2], fees[3]);
					}

					return fee;
				}).toArray();
	}

	// 기본료를 제외한 추가 요금
	private int extraFee(int duration, int freeTime, int unitTime, int unitFee) {
		return ((int) Math.ceil(1.0 * (duration - freeTime) / unitTime)) * unitFee;
	}

	private int toMinute(String paramTime) {
		String[] time = paramTime.split(":");
		return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
	}
}
