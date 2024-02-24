package conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Codeblocks {

	@Test
	public void simpleCodeblock() throws IOException {
		String markdown = """
				```
				this is a code block
				```
				""";
		
		String html = """
				<pre><code>
				this is a code block
				</code></pre>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void doubleCodeblock() throws IOException {
		String markdown = """
				```
				this is a code block
				```
				```
				this is another code block
				```
				""";
		
		String html = """
				<pre><code>
				this is a code block
				</code></pre>
				<pre><code>
				this is another code block
				</code></pre>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void largeCodeblock() throws IOException {
		String markdown = """
				```
				this is 
				a 
				biiig
				code block
				```
				""";
		
		String html = """
				<pre><code>
				this is 
				a 
				biiig
				code block
				</code></pre>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
	@Test
	public void languageCodeblock() throws IOException {
		String markdown = """
				```js
				this is a js code block
				```
				""";
		
		String html = """
				<pre><code class="lang-js">
				this is a js code block
				</code></pre>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
}
