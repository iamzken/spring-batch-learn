package com.geekcap.javaworld;


import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jobs/file-import-job.xml")
public class TestJob {
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Before
	public void setUp() throws ParseException{
		System.out.println("setUp==================================================================setUp");
	}

	@Test
	@Rollback(true)
	public void testBatchJob() throws Exception
	{
		//开始跑批
		JobParameters jobParameters = new JobParametersBuilder()
		.addDate("date", new Date())
        .addString("inputFile", "src/test/resources/sample.csv")
        //.addString("inputFile", "D:/kenan.zhang/Downloads/spring-batch-example/src/test/resources/sample.csv")
        .toJobParameters();
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		//JobExecution jobExecution = jobLauncherTestUtils.launchStep("step0001");

		//检查结果
		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}
}
