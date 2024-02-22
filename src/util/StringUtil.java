package util;

public class StringUtil {

	public static int countHeadingChars(String s, char c) {
		return s.chars().takeWhile(i -> i == c).map(i -> 1).sum();
	}
}
