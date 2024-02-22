package parser;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Parser {

	public static void toHtml(Reader in, Writer out) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int ascii;
		
		while ((ascii = in.read()) >= 0) 
		{
			if (ascii == '\n') 
			{ 
				String line = sb.toString();
				
			}
			else
			{
				// read an entire line before trying to parse
				sb.append((char) ascii);
			}
		}
	}
	
}
