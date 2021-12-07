package com.Naukri.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	FileInputStream fis;
	public ReadConfig()
	{		
		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro = new Properties();			
		try 
		{
			pro.load(fis);
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{		
		return pro.getProperty("BaseUrl");		
	}
	public String getUsername()
	{		
		return pro.getProperty("Username");		
	}
	public String getPassword()
	{		
		return pro.getProperty("Password");		
	}
	public String getResumeHeadline()
	{		
		return pro.getProperty("ResumeHeadline");		
	}
	public String getResumeHeadline_withSpace()
	{		
		return pro.getProperty("ResumeHeadline_withSpace");		
	}	
}
