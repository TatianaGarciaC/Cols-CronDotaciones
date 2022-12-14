package com.colsubsidio.dotaciones.scheduled.config.utils;

import java.io.UnsupportedEncodingException;

public class ProcessChainSpecials {

	public static String quitarEspeciales(String str, int a) throws UnsupportedEncodingException {
		String res = "";

		if (str != null) {

			res = res.replaceAll("&aacute;", "a");
			res = res.replaceAll("&eacute;", "e");
			res = res.replaceAll("&iacute;", "i");
			res = res.replaceAll("&oacute;", "o");
			res = res.replaceAll("&uacute;", "u");
			res = res.replaceAll("&Aacute;", "A");
			res = res.replaceAll("&Eacute;", "E");
			res = res.replaceAll("&Iacute;", "I");
			res = res.replaceAll("&Oacute;", "O");
			res = res.replaceAll("&Uacute;", "U");

			res = res.replaceAll("&auml;", "a");
			res = res.replaceAll("&euml;", "e");
			res = res.replaceAll("&iuml;", "i");
			res = res.replaceAll("&ouml;", "o");
			res = res.replaceAll("&uuml;", "u");
			res = res.replaceAll("&Auml;", "A");
			res = res.replaceAll("&Euml;", "E");
			res = res.replaceAll("&Iuml;", "I");
			res = res.replaceAll("&Ouml;", "O");
			res = res.replaceAll("&Uuml;", "U");

			res = res.replaceAll("&Ntilde;", "N");
			res = res.replaceAll("&ntilde;", "n");
			res = res.replaceAll("&deg;", "_");

			res = res.replaceAll("&iquest;", "_");
			res = res.replaceAll("&iexcl;", "_");

			res = res.replaceAll("&acirc;", "a");
			res = res.replaceAll("&ecirc;", "e");
			res = res.replaceAll("&icirc;", "i");
			res = res.replaceAll("&ocirc;", "o");
			res = res.replaceAll("&ucirc;", "u");

			res = res.replaceAll("&Acirc;", "A");
			res = res.replaceAll("&Ecirc;", "E");
			res = res.replaceAll("&Icirc;", "I");
			res = res.replaceAll("&Ocirc;", "O");
			res = res.replaceAll("&Ucirc;", "U");

			res = res.replaceAll("&agrave;", "a");
			res = res.replaceAll("&egrave;", "e");
			res = res.replaceAll("&igrave;", "i");
			res = res.replaceAll("&ograve;", "o");
			res = res.replaceAll("&ugrave;", "u");

			res = res.replaceAll("&Agrave;", "A");
			res = res.replaceAll("&Egrave;", "E");
			res = res.replaceAll("&Igrave;", "I");
			res = res.replaceAll("&Ograve;", "O");
			res = res.replaceAll("&Ugrave;", "U");

			res = res.replaceAll("&ccedil;", "c");
			res = res.replaceAll("&Ccedil;", "C");

			res = res.replaceAll("??", "a");

			res = res.replaceAll("??", "a");
			res = res.replaceAll("??", "e");
			res = res.replaceAll("??", "i");
			res = res.replaceAll("??", "o");
			res = res.replaceAll("??", "u");
			res = res.replaceAll("??", "A");
			res = res.replaceAll("??", "E");
			res = res.replaceAll("??", "I");
			res = res.replaceAll("??", "O");
			res = res.replaceAll("??", "U");

			res = res.replaceAll("??", "a");
			res = res.replaceAll("??", "e");
			res = res.replaceAll("??", "i");
			res = res.replaceAll("??", "o");
			res = res.replaceAll("??", "u");
			res = res.replaceAll("??", "A");
			res = res.replaceAll("??", "E");
			res = res.replaceAll("??", "I");
			res = res.replaceAll("??", "O");
			res = res.replaceAll("??", "U");

			res = res.replaceAll("??", "N");
			res = res.replaceAll("??", "n");
			res = res.replaceAll("??", "_");

			res = res.replaceAll("??", "_");
			res = res.replaceAll("??", "_");

			res = res.replaceAll("??", "a");
			res = res.replaceAll("??", "e");
			res = res.replaceAll("??", "i");
			res = res.replaceAll("??", "o");
			res = res.replaceAll("??", "u");

			res = res.replaceAll("??", "A");
			res = res.replaceAll("??", "E");
			res = res.replaceAll("??", "I");
			res = res.replaceAll("??", "O");
			res = res.replaceAll("??", "U");

			res = res.replaceAll("??", "a");
			res = res.replaceAll("??", "e");
			res = res.replaceAll("??", "i");
			res = res.replaceAll("??", "o");
			res = res.replaceAll("??", "u");

			res = res.replaceAll("??", "A");
			res = res.replaceAll("??", "E");
			res = res.replaceAll("??", "I");
			res = res.replaceAll("??", "O");
			res = res.replaceAll("??", "U");

			res = res.replaceAll("??", "c");
			res = res.replaceAll("??", "C");
			res = new String(str.getBytes(), "UTF-8");
		}

		return res;
	}

	public static String quitarEspeciales(String input) throws UnsupportedEncodingException {
		String original = "????????????????????????????u??????????????????????????????????????????";
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcCnN";
		String output = input;
		for (int i = 0; i < original.length(); i++) {
			output = output.replace(original.charAt(i), ascii.charAt(i));
		}
		return output;
	}
}
