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
				<pre><code>this is a code block</code></pre>
				""";
		
		String actual = ConversionTestUtil.parse(markdown);
		
		assertEquals(html, actual);
	}
	
}
