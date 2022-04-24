import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
//import java.util.Date;

public class LastTimePlayed
{
	private Time time1;
	private Time time2;
	private long yearDiff, monthDiff, dayDiff, hourDiff, minuteDiff, secondDiff;

	private int firstTime;
	// firstTime = 0 -> This is the first time user plays the indolent game

	public LastTimePlayed(){
		this.time1 = new Time();
		this.time2 = new Time();
	}

	public void getSystemTime()
	{
		Calendar cal = Calendar.getInstance();
		//Date date = cal.getTime();
		time2.setYear(cal.get(Calendar.YEAR));
		time2.setMonth(cal.get(Calendar.MONTH) + 1);
		time2.setDay(cal.get(Calendar.DAY_OF_MONTH));
		time2.setHour(cal.get(Calendar.HOUR_OF_DAY));
		time2.setMinute(cal.get(Calendar.MINUTE));
		time2.setSecond(cal.get(Calendar.SECOND));
	}

	public void checkFirstTime()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("lastTimeData.txt"));     
			if (br.readLine() == null) 
			{
    			firstTime = 0;
			}
			else 
			{
				firstTime = 1;
			}
			br.close();
      	}
      	catch (IOException e)
      	{
      		System.out.println("An error occurred.");
      		e.printStackTrace();
      	}
	}

	public void archiveData()
	{
		try
		{
			FileWriter lastTimeData = new FileWriter("lastTimeData.txt");
			lastTimeData.write(time2.toString());
			lastTimeData.close();
			
      	}
      	catch (IOException e)
   		{
      		System.out.println("An error occurred.");
      		e.printStackTrace();
   		}
	}

	public void getLastTime()
	{
		if (firstTime == 1)
		{
			try
			{
				File lastTimeData = new File("lastTimeData.txt");
				Scanner reader = new Scanner(lastTimeData);
				time1.setYear(reader.nextInt());
				time1.setMonth(reader.nextInt());
				time1.setDay(reader.nextInt());
				time1.setHour(reader.nextInt());
				time1.setMinute(reader.nextInt());
				time1.setSecond(reader.nextInt());
				reader.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("An error occurred.");
	      		e.printStackTrace();
			}
		}
		else 
		{
			//System.out.println("This is the first time. No getLastTime");
		}
	}

	public void timeDiff()
	{
		if (firstTime == 1)
		{
			LocalDateTime fromDateTime = LocalDateTime.of(time1.getYear(), time1.getMonth(), time1.getDay(), time1.getHour(), time1.getMinute(), time1.getSecond());
			LocalDateTime toDateTime = LocalDateTime.of(time2.getYear(), time2.getMonth(), time2.getDay(), time2.getHour(), time2.getMinute(), time2.getSecond());
			LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);
			calculateDiffernce(tempDateTime,toDateTime);
			tempDateTime = calctempDateTime(tempDateTime);
			//System.out.println(yearDiff + " " + monthDiff + " " + dayDiff + " " + hourDiff + " " + minuteDiff + " " + secondDiff);
		}
//		else
//		{
//			//System.out.println("This is the first time. No timeDiff");
//		}
	}

	private LocalDateTime calctempDateTime(LocalDateTime tempDateTime){
		tempDateTime = tempDateTime.plusYears( yearDiff );

		tempDateTime = tempDateTime.plusMonths( monthDiff );

		tempDateTime = tempDateTime.plusDays( dayDiff );

		tempDateTime = tempDateTime.plusHours( hourDiff );

		tempDateTime = tempDateTime.plusMinutes( minuteDiff );
		return tempDateTime;
	}

	private void calculateDiffernce(LocalDateTime tempDateTime, LocalDateTime toDateTime){

		yearDiff = calcDiff(tempDateTime,toDateTime, ChronoUnit.YEARS);
		monthDiff = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
		dayDiff = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
		hourDiff = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
		minuteDiff = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
		secondDiff = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);
	}


	private long calcDiff(LocalDateTime fromDateTime, LocalDateTime toDateTime, ChronoUnit chronoUnit){
		return fromDateTime.until( toDateTime, chronoUnit);
	}

	public long totalSecondDiff()
	{
		return secondDiff + minuteDiff * 60 + hourDiff * 3600 + dayDiff * 86400 + monthDiff * 30 + yearDiff * 365;
	}
}