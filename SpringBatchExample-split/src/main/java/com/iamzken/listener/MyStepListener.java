package com.iamzken.listener;

import org.springframework.batch.core.StepListener;

public class MyStepListener implements StepListener{
	
	public MyStepListener() {
		
		System.out.println("ExceptionListener构造方法-------------------------");
		
	}
}
