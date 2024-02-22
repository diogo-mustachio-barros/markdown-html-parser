package conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import parser.Parser;

public class Headings {
	
	@Test
	public void simpleHeading() throws IOException {
		String markdown = """
				# This is a heading
				""";
		
		String html = """
				<h1>This is a heading</h1>
				""";
		
		String actual = parse(markdown);
		
		assertEquals(html, actual);
	}
	
	private static String parse(String input) throws IOException {
		Reader in = new StringReader(input);
		Writer out = new StringWriter();
		
		Parser.toHtml(in, out);
		
		return out.toString();
	}
}
