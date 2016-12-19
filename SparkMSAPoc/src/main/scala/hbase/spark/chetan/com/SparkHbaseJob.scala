/**
  * Created by chetan on 15/12/16.
  * Sample POC with Spark Read / Write Data with Spark Transformations.
  */
package hbase.spark.chetan.com

import it.nerdammer.spark.hbase._
import org.apache.spark.{SparkConf, SparkContext}

object SparkHbaseJob {


      val APP_NAME: String = "SparkHbaseJob"
      var HBASE_DB_HOST: String = null
      var HBASE_TABLE: String = null
      var HBASE_COLUMN_FAMILY: String = null

      def main(args: Array[String]) {
        // Initializing HBASE Configuration variables
        HBASE_DB_HOST="127.0.0.1"
        HBASE_TABLE="university"
        HBASE_COLUMN_FAMILY="school"
        // setting spark application
        val conf = new SparkConf().setAppName(APP_NAME)
        //initialize the spark context
        val sparkContext = new SparkContext(conf)
        //Configuring Hbase host with Spark/Hadoop Configuration
        sparkContext.hadoopConfiguration.set("spark.hbase.host", HBASE_DB_HOST)
        // Generating Dummy Data
        val studentRDD = sparkContext.parallelize(30 to 40).map(i => ("cs"+i.toString, i+1, i+2, i+5, i+3, i+4))
        // Saving Dummy Data to HBASE Table
        studentRDD.toHBaseTable(HBASE_TABLE).toColumns("maths", "english","science","history","computer").inColumnFamily(HBASE_COLUMN_FAMILY).save()
        // Retrieving Data from HBase Table
        val hBaseRDD = sparkContext.hbaseTable[(String, Int, Int, Int, Int, Int)](HBASE_TABLE).select("maths", "english","science","history","computer").inColumnFamily(HBASE_COLUMN_FAMILY)
        // Printing Retrieved Data
        hBaseRDD.foreach(println)


      }
}
