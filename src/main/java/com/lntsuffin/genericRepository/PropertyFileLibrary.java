package com.lntsuffin.genericRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all the opening , fetching  values and closing the propertyfiles
 * @author asus
 *
 */
public class PropertyFileLibrary {
	private FileInputStream fis;
	private Properties property;
	/**
	 * This method is used to open the properyFile in particular path
	 * @param propertyFilePath
	 */
	public void openPropertyFile(String propertyFilePath)
	{ try {
		fis=new FileInputStream(propertyFilePath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * This method is used to fetch the data from the property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) 
	{
	
		
		String value=property.getProperty(key).trim();
		return value;
	}
	/**
	 * used to close the propertyfile
	 * @throws IOException
	 */
	public void closePropertyFile()
	{
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
