package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class TimeLimit {



	//現在時刻から期限までの差分を計算：分(minutes)で返す
	public long timeLimit(Date limit) {
		long re = 0;

		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldtLimit = LocalDateTime.ofInstant(limit.toInstant(), ZoneId.systemDefault());
		Duration duration = Duration.between(ldtNow, ldtLimit);
		re = duration.toMinutes();

		return re;
	}


}
