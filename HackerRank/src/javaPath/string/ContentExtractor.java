package javaPath.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ContentExtractor {
	public static void main(String[] args){
		String regex = "<(.+)>([^<>]+)</\\1>";
		Pattern m = Pattern.compile(regex);
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			Matcher p = m.matcher(line);
			boolean f = false;
			
			if (line.length() <= 10000) {
				while (p.find() && p.group(2).length() <= 1000000) {
					System.out.println(p.group(2));
					f = true;
				}
				if (!f) {
					System.out.println("None");
				}
			}

			testCases--;
		}
		in.close();
	}
}
