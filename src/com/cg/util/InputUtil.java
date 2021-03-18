/** This package contains code for taking input from user by scanner. */

package com.cg.util;

import java.util.Scanner;

public class InputUtil {
	private static Scanner scanner=null;

	public static Scanner getScanner() {

		if (null == scanner)
			return new Scanner(System.in);
		else
			return scanner;
	}

}
