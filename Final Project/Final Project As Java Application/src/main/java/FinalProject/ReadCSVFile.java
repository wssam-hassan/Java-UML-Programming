package FinalProject;

import org.apache.spark.sql.*;


public class ReadCSVFile {

    protected String path;
    private Dataset<Row> csvDataFrame;
    final SparkSession sparkSession = SparkSession.builder()
            .appName("Read CSV File")
            .master("local[3]")
            .getOrCreate();


    public ReadCSVFile(String path){

        final DataFrameReader dataFrameReader = sparkSession.read();
        dataFrameReader.option("header", "true");

        this.csvDataFrame = dataFrameReader.csv(path);
        this.path = path;
    }

    public Dataset<Row> get_csvDataFrame()
    {
        return this.csvDataFrame;
    }


    public void show_csvDataFrame(int numberOfRows)
    {
        this.csvDataFrame.show(numberOfRows);
    }


    public void showSchema()
    {
        this.csvDataFrame.printSchema();
    }


    public void showSummary()
    {
        Dataset<Row> summary = this.csvDataFrame.summary().toDF();
        summary.show();;
    }


    public Dataset<Row> cleanDataFrame()
    {
        Dataset<Row> cleanDataFrame;
        cleanDataFrame = this.csvDataFrame.na().drop();
        cleanDataFrame = this.csvDataFrame.dropDuplicates();

        return cleanDataFrame;
    }

}
