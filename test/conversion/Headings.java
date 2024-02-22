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
		
		Reader in = new StringReader(markdown);
		Writer out = new StringWriter();
		
		Parser.toHtml(in, out);
		
		String actual = out.toString();
		
		assertEquals(html, actual);
	}
}
