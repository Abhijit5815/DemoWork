package com.hbsp.globalutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;

public class JSONReader3 {
	String filePath;
	InputStream is;
	JSONTokener tokener;
	JSONObject jsonob;
	static By value;

	public JSONReader3(String fp) throws FileNotFoundException {
		this.filePath = fp;
		this.is = new FileInputStream(fp);
		this.tokener = new JSONTokener(this.is);
		this.jsonob = new JSONObject(this.tokener);
	}

	public boolean isOfFile(String fp) {
		return this.getFilePath().equalsIgnoreCase(fp);
	}

	String getFilePath() {
		return this.filePath;
	}

	public static void main(String args[]) throws FileNotFoundException {
		JSONReader3 jr = new JSONReader3("E:\\Vamp-workspace\\HBSelTng\\Resources\\or.json");

		String s2 = jr.getlocatortype("loginpage", "username");
		System.out.println(s2);

		String s1 = jr.getlocatorvalue("loginpage", "username");
		System.out.println(s1);

		By s3 = jr.getlocator("loginpage", "username");
		System.out.println(s3);

	}

	public String getlocatortype(String pagename, String fieldname) {

		String s1 = (String) this.jsonob.getJSONObject(pagename).getJSONObject(fieldname).get("key");
		return s1;
	}

	public String getlocatorvalue(String pagename, String fieldname) {

		String s1 = (String) this.jsonob.getJSONObject(pagename).getJSONObject(fieldname).get("value");
		return s1;
	}

	public By getlocator(String page, String field) {

		String s = this.getlocatortype(page, field);
		// By value=null;
		// By.id("");
		switch (s) {
		case "id":
			value = By.id(this.getlocatorvalue(page, field));

			break;

		case "xpath":
			value = By.xpath(this.getlocatorvalue(page, field));

			break;

		}
		return value;

	}

}
