package parser;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import util.StringUtil;

public class Parser {

	public static void toHtml(Reader in, Writer out) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int ascii;
		
		while ((ascii = in.read()) >= 0) 
		{
			if (ascii == '\n') 
			{ 
				// collect line
				String line = sb.toString();
				
				// parse
				if (isHeading(line))
					parseHeading(in, out, line);
			}
			else
			{
				// read an entire line before trying to parse
				sb.append((char) ascii);
			}
		}
	}
	
	private static boolean isHeading(String line) {
		return line.startsWith("#") 
			&& StringUtil.countHeadingChars(line, '#') <= 6;
	}
	
	private static void parseHeading(Reader in, Writer out, String firstLine) throws IOException {
		int headingCount = StringUtil.countHeadingChars(firstLine, '#');
		
		out.write("<h" + headingCount + ">" + firstLine.substring(headingCount).trim() + "</h" + headingCount + ">\n");
	}
	
	
	
}
