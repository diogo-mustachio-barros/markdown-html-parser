package conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Paragraphs {

	@Test
	public void simpleParagraph() throws IOException {
		String markdown = """
				this is a paragraph
				""";
		
		String html = """
				<p>
				this is a paragraph
				</p>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void multilineParagraphs() throws IOException {
		String markdown = """
				this is a 
				multiple line
				paragraph
				""";
		
		String html = """
				<p>
				this is a 
				multiple line
				paragraph
				</p>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void multipleParagraphs() throws IOException {
		String markdown = """
				this is a paragraph
				
				this is another paragraph
				""";
		
		String html = """
				<p>
				this is a paragraph
				</p>
				<p>
				this is another paragraph
				</p>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
}
