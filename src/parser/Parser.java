package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Parser {

	public static void main(String[] args) {
		
		String filepathIn  = "input/example1.md";
		String filepathOut = "output";
		
		
		// Try and open a reader
		File fileIn = new File(filepathIn);
		Reader r = null;
		try {
			r = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn), "ASCII"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (r == null)
			return;
		
		// Try and open a writer
		File fileOut = new File(filepathOut);
		Writer w = null;
		try {
			w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileIn), "ASCII"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (w == null)
			return;
		
		// Generate html
		try {
			toHtml(r, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void toHtml(Reader in, Writer out) throws IOException {
		int ascii;
		
		while ((ascii = in.read()) >= 0) {
			// TODO
		}
	}
	
}
