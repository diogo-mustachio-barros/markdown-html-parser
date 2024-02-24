package util;

import java.io.IOException;
import java.io.Reader;

public class StringUtil {

	public static int countHeadingChars(String s, char c) {
		return s.chars().takeWhile(i -> i == c).map(i -> 1).sum();
	}
	
	public static String readLine(Reader in) {
		StringBuilder sb = new StringBuilder();
		int ascii;
		
		try 
		{
			while ((ascii = in.read()) >= 0) 
				if (ascii == '\n') 
					return sb.toString();
				else
					sb.append((char) ascii);
		} catch (IOException e) {
			return sb.toString();
		}
		
		return sb.toString();
	}
}
