package conversion;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import parser.Parser;

public class ConversionTestUtil {
	public static String parse(String input) throws IOException {
		Reader in = new StringReader(input);
		Writer out = new StringWriter();
		
		Parser.toHtml(in, out);
		
		return out.toString();
	}
}
