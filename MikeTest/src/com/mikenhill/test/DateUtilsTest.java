package com.mikenhill.test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtilsTest {

	public static void main(String[] args) {
		DateUtilsTest dut = new DateUtilsTest();
		dut.printDate();
	}
	
	public void printDate()  {
		try {
			
			String quotationDate = "20181119";
			String quotationTime = "230000";
			LocalDateTime lissiaDateTime = LocalDateTime.parse(quotationDate+" "+quotationTime, DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
			String utcDateTime = lissiaDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
			
			LocalDateTime quote_date= java.time.LocalDateTime.parse(
					"2019-05-16T10:37:24.024", java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
			Integer bb = quote_date.getMonthValue();
			
			SimpleDateFormat;
			//Test 
			String SG_APPLICATION_START_DATE = "Fri Jun 07 08:01:25 BST 2019";
			LocalDate ld= java.time.LocalDate.parse(SG_APPLICATION_START_DATE,
					DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH));
			//EOT
			
			java.util.Date dd = new java.util.Date();
			String gg = new SimpleDateFormat("yyyy-MM-dd").format(dd); 
			
			String applStartDate = "2019-05-16T10:37:24.024";
			LocalDateTime ldt = LocalDateTime.parse(applStartDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
			String oTime = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
			
			String dtf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
			
			LocalDate dateLocal = LocalDate.of(2019, 3, 23);
			LocalDate dateLocalNow = LocalDate.now();
			LocalTime localTime = LocalTime.parse("13:45:56");
			
			LocalDate localDate = LocalDate.parse("2014-09-02");
			
			LocalDateTime dt1 = LocalDateTime.of(2019,  Month.APRIL, 18, 13, 45, 23);
			LocalDateTime dt2 = LocalDateTime.of(dateLocal, localTime);
			LocalDateTime dt3 = dateLocal.atTime(12,34,45);
			LocalDateTime dt4 = localTime.atDate(dateLocal);
			
			//Durations - between times or between datetimes (not dates)
			Duration du1 = Duration.between(dt1, dt2);
			Duration threeMins = Duration.ofMinutes(3);
			
			//Use Period for difference between dates
			Period pe1 = Period.between(dateLocal, dateLocalNow);
			Period tenDays = Period.ofDays(4);
			
			//Note Instant is intended for machines, not human readable
			
			dateLocal = dateLocal.withYear(2020);
			dateLocal = dateLocal.plusWeeks(22);
			
			LocalDate fromCustomPattern = LocalDate.parse("20/03/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			LocalDateTime fromIsoZonedDateTime = LocalDateTime
					//.parse("2016/06/16T13:12:38.954+01:00[Europe/London]"
							.parse("16-07-2019 10:20:31+01:00"
							,DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss[XXX][X]"));
			
			String uwwbFormat = fromIsoZonedDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
			
			//UTC
			//LocalDate myLd = LocalDate.parse("2014-05-02T10:45:05-5:00", DateTimeFormatter.with);
			
			//DateTimeFormatter ff = new DateTimeFormatter
			 
//			String mssDateTime = "30/7/2018 10:21:44+0100";
//			mssDateTime = mssDateTime.replaceAll("/", "-").replaceAll(" ", "T");
//			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss[XXX][X]");
//			dateTimeFormatter.parse(mssDateTime);
//			dateTimeFormatter.parse("2015-01-28T10:21:44+01:00");
			
			//String input = "2014-05-02 10.45.05-5:00";
//			String input = "2018-03-2 10:45:05";
//			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//					new DateTimeFormatterBuilder()
//					//.appendPattern("yyyy-MM-dd HH.mm.ss[XXX][X]")
//					//.appendText(ChronoField.DAY_OF_MONTH)
//					.appendPattern("dd/MM/uuuu HH:mm:ss")
//					//.appendLiteral("-")
//					//.appendText(ChronoField.MONTH_OF_YEAR)
//					//.appendLiteral("-")
//					//.appendText(ChronoField.YEAR)
//					//.parseLenient()
//					//.appendOffset("+HH:MM", "Z")
//					.toFormatter();
//			//f = f.withZone(ZoneOffset.UTC);
//			f.parse(input);
//			f.form
			//System.out.println(f.parse(input, ZonedDateTime::from));
			
			

			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
