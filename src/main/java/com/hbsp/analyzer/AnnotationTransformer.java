package com.hbsp.analyzer;

import java.lang.reflect.Constructor;

import org.jsoup.Connection.Method;
import org.jsoup.select.Evaluator.Class;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
