package com.jzr.utils;

import java.util.UUID;

import com.jzr.constants.Constants;

public class TokenUtils {

	 public static String getMemberToken(){
		 return Constants.TOKEN_MEMBER+"-"+UUID.randomUUID();
	 }
	
}
