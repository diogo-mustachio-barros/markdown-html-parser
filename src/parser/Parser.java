package parser;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import util.StringUtil;

public class Parser {

	private static final String CODE_BLOCK_DELIMITER = "```";
	private static final Character BLOCKQUOTE_CHARACTER = '>';
	
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
				else if (isBlockquote(line))
					parseBlockquote(in, out, line);
				else if (!line.equals(""))
					parseParagraph(in, out, line);
					
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
		return line.startsWith(CODE_BLOCK_DELIMITER);
	}
	
	private static void parseCodeBlock(Reader in, Writer out, String firstLine) throws IOException {
		// returns the language or empty string (because firstLine is always at least 3 in size)
		String language = firstLine.substring(3);
		
		String languagePreamble = language.isEmpty() ? "" : " class=\"lang-" + language + "\"";
		out.write("<pre><code" + languagePreamble + ">\n");
		
		// collect all code until the delimiter
		String line = "";
		while ((line = StringUtil.readLine(in)) != null 
				&& !line.equals(CODE_BLOCK_DELIMITER))
			out.write(line + "\n");
		
		out.write("</code></pre>\n");
	}
	
	
	
	private static boolean isBlockquote(String line) {
		return line.startsWith(BLOCKQUOTE_CHARACTER + "");
	}
	
	private static void parseBlockquote(Reader in, Writer out, String firstLine) throws IOException {
		
		int prevLevel = 0;
		int level = 0;
		String line = firstLine;
		
		while (line != null 
			&& line.startsWith(BLOCKQUOTE_CHARACTER + "")
			&& !line.equals(""))
		{
			level = StringUtil.countHeadingChars(line, BLOCKQUOTE_CHARACTER);
			
			if (level > prevLevel) 
				for (int i = prevLevel; i < level; i++)
					out.write("<blockquote>\n");
			else if (level < prevLevel)
				for (int i = level; i < prevLevel; i++)
					out.write("</blockquote>\n");
			
			out.write(line.substring(level).trim() + "\n");
			
			
			prevLevel = level;
			line = StringUtil.readLine(in);
		}
		
		// close any leftover blockquotes
		for (int i = 0; i < Math.max(prevLevel, level); i++)
			out.write("</blockquote>\n");
	}
	
	
	
	private static void parseParagraph(Reader in, Writer out, String firstLine) throws IOException {
		out.write("<p>\n" + firstLine + "\n");
		
		String line;
		while ((line = StringUtil.readLine(in)) != null 
				&& !line.equals(""))
			out.write(line + "\n");
		
		out.write("</p>\n");
	}
}
