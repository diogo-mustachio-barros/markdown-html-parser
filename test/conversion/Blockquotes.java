package conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Blockquotes {

	@Test
	public void simpleBlockquote() throws IOException {
		String markdown = """
				> this is a blockquote
				""";
		
		String html = """
				<blockquote>
				this is a blockquote
				</blockquote>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void multilineBlockquote() throws IOException {
		String markdown = """
				> this is 
				> a multiline blockquote
				""";
		
		String html = """
				<blockquote>
				this is
				a multiline blockquote
				</blockquote>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void multipleBlockquote() throws IOException {
		String markdown = """
				> this is a blockquote
				
				> this is another blockquote
				
				> and another blockquote!
				""";
		
		String html = """
				<blockquote>
				this is a blockquote
				</blockquote>
				<blockquote>
				this is another blockquote
				</blockquote>
				<blockquote>
				and another blockquote!
				</blockquote>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void nestedBlockquote() throws IOException {
		String markdown = """
				> outside
				>> nested
				""";
		
		String html = """
				<blockquote>
				outside
				<blockquote>
				nested
				</blockquote>
				</blockquote>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void multipleNestedBlockquotes() throws IOException {
		String markdown = """
				> outside
				>> nested
				> out
				>> nested
				>>> nested again
				> out
				>>> double nested
				""";
		
		String html = """
				<blockquote>
				outside
				<blockquote>
				nested
				</blockquote>
				out
				<blockquote>
				nested
				<blockquote>
				nested again
				</blockquote>
				</blockquote>
				out
				<blockquote>
				<blockquote>
				double nested
				</blockquote>
				</blockquote>
				</blockquote>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
}
