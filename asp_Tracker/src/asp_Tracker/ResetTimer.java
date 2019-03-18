package asp_Tracker;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class ResetTimer {
	
	
	public ResetTimer(ASP_Data data) {
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		Timer timer = new Timer(true);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Test");
				int day = c.get(Calendar.DAY_OF_WEEK);
				if(day == Calendar.SUNDAY) {
					if (data.checkReset()) {
						data.resetW();
					}
				}else {
					if (data.checkReset()) {
						data.reset();
					}
					
					
					
				}
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						GUI.reset();
						
					}
					
				});
			}
		};
		timer.scheduleAtFixedRate(task, 10, 36*100000);
	}
	
}



