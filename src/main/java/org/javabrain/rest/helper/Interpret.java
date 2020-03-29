package org.javabrain.rest.helper;

public class Interpret {

	public static String asCall(String call, int part) {
		String[] callParts = call.split(" as ");
		if (callParts.length == 2) {
			return callParts[part].split(" use ")[0];
		} else {
			return callParts[0].split(" use ")[0];
		}
	}

	public static String asUse(String use) {
		String[] callParts = use.split(" use ");
		if (callParts.length == 2) {
			return callParts[1];
		} else {
			return "";
		}
	}

}
