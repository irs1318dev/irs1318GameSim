package com.usfirst.irs1318;

public class SystemOutLogger implements Logger{

	@Override
	public void log(String string) {
		System.out.println(string);

		
	}
	
}
