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
	private int year1, month1, day1, hour1, minute1, second1;
	private int year2, month2, day2, hour2, minute2, second2;
	private long yearDiff, monthDiff, dayDiff, hourDiff, minuteDiff, secondDiff;

	private int firstTime;
	// firstTime = 0 -> This is the first time user plays the indolent game

	public void getSystemTime()
	{
		Calendar cal = Calendar.getInstance();
		//Date date = cal.getTime();
		year2 = cal.get(Calendar.YEAR);
		month2 = cal.get(Calendar.MONTH) + 1;
		day2 = cal.get(Calendar.DAY_OF_MONTH);
		hour2 = cal.get(Calendar.HOUR_OF_DAY);
		minute2 = cal.get(Calendar.MINUTE);
		second2 = cal.get(Calendar.SECOND);
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
			lastTimeData.write(year2 + " " + month2 + " " + day2 + " " + hour2 + " " + minute2 + " " + second2);
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
				year1 = reader.nextInt();
				month1 = reader.nextInt();
				day1 = reader.nextInt();
				hour1 = reader.nextInt();
				minute1 = reader.nextInt();
				second1 = reader.nextInt();
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
			LocalDateTime fromDateTime = LocalDateTime.of(year1, month1, day1, hour1, minute1, second1);
			LocalDateTime toDateTime = LocalDateTime.of(year2, month2, day2, hour2, minute2, second2);
			LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );
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