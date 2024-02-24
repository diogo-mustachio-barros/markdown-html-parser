package conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Headings {
	
	@Test
	public void simpleHeading() throws IOException {
		String markdown = """
				# This is a heading
				""";
		
		String html = """
				<h1>This is a heading</h1>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void mutlipleHeadings() throws IOException {
		String markdown = """
				# Heading 1
				# Heading 2
				# Heading 3
				""";
		
		String html = """
				<h1>Heading 1</h1>
				<h1>Heading 2</h1>
				<h1>Heading 3</h1>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void mutlipleDifferentHeadings() throws IOException {
		String markdown = """
				# H1
				## H2
				### H3
				#### H4
				##### H5
				###### H6
				""";
		
		String html = """
				<h1>H1</h1>
				<h2>H2</h2>
				<h3>H3</h3>
				<h4>H4</h4>
				<h5>H5</h5>
				<h6>H6</h6>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void mixedDifferentHeadings() throws IOException {
		String markdown = """
				## H2
				###### H6
				# H1
				### H3
				##### H5
				#### H4
				""";
		
		String html = """
				<h2>H2</h2>
				<h6>H6</h6>
				<h1>H1</h1>
				<h3>H3</h3>
				<h5>H5</h5>
				<h4>H4</h4>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void spacedHeadings() throws IOException {
		String markdown = """
				# Heading 1
				
				# Heading 2
				
				# Heading 3
				""";
		
		String html = """
				<h1>Heading 1</h1>
				<h1>Heading 2</h1>
				<h1>Heading 3</h1>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
}
