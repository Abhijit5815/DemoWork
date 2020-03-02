package com.hbsp.globalutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONReader4 {

	public static void main(String[] args) {
		JSONReader4 j = new JSONReader4();
		j.getlocatortype("loginpage", "username");

	}

	public String getlocatortype(String pagename, String fieldname) {
		String s = (String) this.readfile().getJSONObject(pagename).getJSONObject(fieldname).get("key");
		System.out.println(s);
		return s;
	}

	public String getlocatorvalue(String pagename, String fieldname) {
		String s = (String) this.readfile().getJSONObject(pagename).getJSONObject(fieldname).get("value");
		return s;
	}

	public JSONObject readfile() {
		InputStream is = null;
		JSONTokener tokener = null;
		JSONObject jsonob = null;
		try {
			is = new FileInputStream("E:\\Vamp-workspace\\HBSelTng\\Resources\\or.json");
			tokener = new JSONTokener(is);
			jsonob = new JSONObject(tokener);

		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {

				is.close();
			} catch (IOException ioe) {

				// can't do anything about it
			}
		}
		return jsonob;

	}

}
