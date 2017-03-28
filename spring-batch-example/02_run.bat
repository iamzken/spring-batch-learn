cd D:/kenan.zhang/Downloads/spring-batch-example

call mvn clean install -DskipTests

cd target

java -cp spring-batch-example.jar;./lib/* org.springframework.batch.core.launch.support.CommandLineJobRunner classpath:/jobs/file-import-job.xml simpleFileImportJob inputFile=test-classes/sample.csv

pause
