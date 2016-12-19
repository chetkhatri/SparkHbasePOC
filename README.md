# SparkHbasePOC
This repository will contains everything about Spark Transformation with HBase

IDE and Code Setup steps:

1. Clone Repository: git clone https://github.com/chetkhatri/SparkHbasePOC.git
2. Open project in Intellij IDEA IDE
3. Make Sure Scala, SBT has installed on your machine as well as plugins has been configured at your Intellij IDEA IDE, SCALA_HOME environment variable must be configured.
4. Go to at Root Directory of SparkHbasePOC project and give  'sbt clean assembly' command which will make Uber('Super') jar for your Project
5. Take Uber jar from target directory of your project for example, /home/chetan/IdeaProjects/SparkMSAPoc/target/scala-2.12/
6. Now Spark Job Jar is ready for execution, go to /usr/local/spark where your spark is configured, give below command to execute spark job

```bin/spark-submit --class hbase.spark.chetan.com.SparkHbaseJob /home/chetan/hbase-spark/SparkMSAPoc-assembly-1.0.jar```

where --class is main class of your spark job and Spark Uber Jar path.

##### Screen 1: Spark Submit Command
![Alt text](/images/spark-submit-command.png?raw=true "Spark-Submit-Command")
##### Screen 2: Spark UI: http://localhost:4040/jobs/
![Alt text](/images/spark-ui-monitoring.png?raw=true "Spark-UI-Monitoring")
##### Screen 3: Resultset Retrieved from HBase with Spark Transformation
![Alt text](/images/Retrieved-Data-HBase-Spark.png?raw=true "HBase-Resultset-spark")


