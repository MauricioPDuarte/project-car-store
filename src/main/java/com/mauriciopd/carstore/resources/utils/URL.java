package com.mauriciopd.carstore.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

public class URL {

	public static List<String> decodeList(String s) {
		return Arrays.asList(s.split(","));
	}
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
