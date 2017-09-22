package com.liuawei.util.json;

import java.text.SimpleDateFormat;
import java.util.Date;


public class yyyyMMddHHmmssSSS {

	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		System.out.println(sdf.format(new Date())); 

//		String uri = "/GKCallCenter/consultdoc_syncConsultDocData.htm";
//		System.out.println(uri.indexOf("consultdoc"));
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println("GKDATAENCODE_HOME "+System.getenv("GKDATAENCODE_HOME"));
		System.out.println("GKBSS_HOME "+System.getenv("GKBSS_HOME"));
		System.out.println("GKDB_HOME "+System.getenv("GKDB_HOME"));
		System.out.println("GKDPW_HOME "+System.getenv("GKDPW_HOME"));
		System.out.println("GKTJDATA_HOME "+System.getenv("GKTJDATA_HOME"));
	}

}
