package me.Destro168.FC_Suite_Shared;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FileLineWriter
{
	protected final DateFormat dfm = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String pluginAbsolutePath;
	
	public FileLineWriter(String pluginAbsolutePath_)
	{
		pluginAbsolutePath = pluginAbsolutePath_;
	}
	
	protected void writeToFile(String fileName, String loggable)
	{
		String finalPath = pluginAbsolutePath + "\\" + fileName;
		
		//Attempt to create file if it doesn't exist.
		File f = new File(finalPath);
		
		if (!f.exists())
		{
			try {
				f.createNewFile();
				f.setWritable(true);
			} catch (IOException e1) {
				e1.printStackTrace();
				return;
			}
		}
		
		//Create a writer stream.
		FileWriter fstream;
		
		try {
			fstream = new FileWriter(finalPath, true);
		} catch (IOException e) 
		{
			e.printStackTrace();
			return;
		}
		
		//Create a buffered out stream.
		BufferedWriter out = new BufferedWriter(fstream);
		
		try {
			out.append(loggable);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
