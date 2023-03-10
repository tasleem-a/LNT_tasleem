package com.lntsuffin.genericRepository;

import java.util.Date;
import java.util.Random;

public class JavaLibrary {
	/**
	 * This method is used to convert string to int and long datatype.
	 * @param s
	 * @param strategy
	 * @return
	 */
	public Object stringToAnyDatatype(String s, String strategy)
	{	Object ConvertedData=null;
		if(strategy.equals("int"))
		{
			ConvertedData=Integer.parseInt(s);
		}
		else if(strategy.equals("long"))
		{
			ConvertedData = Long.parseLong(s);
		}
		return ConvertedData;
		
	}
	/**
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit)
	{
		int randomNumber=new Random().nextInt(limit);
		return randomNumber;
	}
	/**
	 * This method is used to get systemdate
	 * @return
	 */
	
	public String getSystemDateAndTime()
	{
		Date date=new Date();
		return date.toString();
	}
	/**
	 * This method is used to get the formated date as YYYY-MM-DD
	 * @return
	 */
	public String getSystemDateWithFormat()
	{
		Date date=new Date();
		String dateAndTime=date.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		String finalFormat=yyyy+"-"+MM+"-"+DD;
		return finalFormat;
		
	}
	


}
