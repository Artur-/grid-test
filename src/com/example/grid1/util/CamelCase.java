package com.example.grid1.util;

public class CamelCase {
	/**
	 * From http://stackoverflow.com/questions/2559759/how-do-i-convert-camelcase-into-human-readable-names-in-java
	 */
	static String splitCamelCase(String s) {
		   return s.replaceAll(
		      String.format("%s|%s|%s",
		         "(?<=[A-Z])(?=[A-Z][a-z])",
		         "(?<=[^A-Z])(?=[A-Z])",
		         "(?<=[A-Za-z])(?=[^A-Za-z])"
		      ),
		      " "
		   );
		}

	public static String toHumanReadable(Object propertyId) {
		String res = splitCamelCase(String.valueOf(propertyId));
		String[] parts = res.split(" ");
		res= parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
		for (int i=1; i < parts.length; i++) {
			res+= " ";
			res += parts[i].substring(0, 1).toLowerCase() + parts[i].substring(1);
		}
		return res;
	}

}
