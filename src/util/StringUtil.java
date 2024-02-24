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
			return null;
		}
		
		String line = sb.toString();
		
		// reader reached end and nothing was read
		if (line == "" && ascii == -1)
			return null;
		
		return sb.toString();
	}
}
