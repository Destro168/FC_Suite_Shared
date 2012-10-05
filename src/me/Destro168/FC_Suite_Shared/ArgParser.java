package me.Destro168.FC_Suite_Shared;

import java.util.ArrayList;
import java.util.List;

public class ArgParser
{
	private final int MAX_ARGS_TO_PARSE = 100;
	
	protected String[] args;
	protected String finalArgument;
	protected List<String> finalArgumentList;
	
	public void setArg(int x, String y) { try { args[x] = y; } catch (ArrayIndexOutOfBoundsException e) { } }
	
	public String getArg(int x) { try { return args[x]; } catch (ArrayIndexOutOfBoundsException e) { return ""; } }
	public String[] getArgs() { return args; }
	public String getFinalArg() { return finalArgument; }
	public List<String> getFinalArgList() { return finalArgumentList; }
	
	public ArgParser(String[] args_)
	{
		//Assign passed args.
		args = new String[MAX_ARGS_TO_PARSE];
		finalArgument = "";
		finalArgumentList = new ArrayList<String>();
		
		//Set the safe arguments based on argument string.
		setSafeArguments(args_);
	}
	
	//Returns an array of arguments where all null parameters are set to "".
	public void setSafeArguments(String[] args_)
	{
		for (int i = 0; i < MAX_ARGS_TO_PARSE; i++)
			args[i] = "";
		
		for (int i = 0; i < args_.length; i++)
		{
			if (args_[i] != null)
				args[i] = args_[i];
			else
				args[i] = "";
		}
	}
	
	//command [arg1] <-- default argument to skip, pass in 1 to skip it.
	public void setLastArg(int argsToSkip_)
	{
		//Set the args to skip = to the args to skip plus previous arguments.
		int argsToSkip = argsToSkip_;
		
		//Form the final argument
		for (int i = argsToSkip; i < args.length; i++)
		{
			if (!args[i].equals(""))
			{
				if (i != argsToSkip)
					finalArgument += " " + args[i];
				else
					finalArgument += args[i];
				
				finalArgumentList.add(args[i]);
			}
		}
	}
}




