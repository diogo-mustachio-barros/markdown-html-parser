package parser;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import util.StringUtil;

public class Parser {

	private static final String CODE_BLOCK_DELIMITER = "```";
	
	public static void toHtml(Reader in, Writer out) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int ascii;
		
		while ((ascii = in.read()) >= 0) 
		{
			if (ascii == '\n') 
			{ 
				// collect line
				String line = sb.toString();
				// clear StringBuilder
				sb.setLength(0);
				
				// parse
				if (isHeading(line))
					parseHeading(in, out, line);
				else if (isCodeBlock(line))
					parseCodeBlock(in, out, line);
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
	
	
	
	private static boolean isCodeBlock(String line) {
		return line.equals(CODE_BLOCK_DELIMITER);
	}
	
	private static void parseCodeBlock(Reader in, Writer out, String firstLine) throws IOException {
		// returns the language or empty string (because firstLine is always at least 3 in size)
		String language = firstLine.substring(3);
		
		// collect all code until the delimiter
		String code = "";
		String line = "";
		while ((line = StringUtil.readLine(in)) != CODE_BLOCK_DELIMITER)
			code += line + "\n";
		
		out.write("<pre><code class=\"" + language + "\"> "+ code + "</code></pre>\n");
	}
	
}
