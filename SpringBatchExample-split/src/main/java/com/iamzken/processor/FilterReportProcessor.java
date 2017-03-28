package com.iamzken.processor;

import org.springframework.batch.item.ItemProcessor;

import com.iamzken.model.Report;

//run before writing
public class FilterReportProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {

		//filter object which age = 30
		if("0".equals(item.getEarnings())){
			return null; // null = ignore this object
		}
		return item;
	}

}