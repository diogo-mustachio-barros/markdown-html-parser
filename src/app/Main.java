package app;

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

import parser.Parser;

public class Main {
	
	public static void main(String[] args) {
		
		String filepathIn  = "input/example1.md";
		String filepathOut = "output";
		
		File fileIn = new File(filepathIn);
		File fileOut = new File(filepathOut);
		
		parseToHtml(fileIn, fileOut);
	}
	
	public static void parseToHtml(File fileIn, File fileOut) {
		// Try and open a reader
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
			Parser.toHtml(r, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
