package TaskSelector;

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

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


    public Dataset<Row> Summary()
    {
        Dataset<Row> summary = this.csvDataFrame.summary().toDF();
        return summary;
    }

    public String Schema()
    {
        return this.csvDataFrame.schema().toDDL();
    }

    public Dataset<Row> cleanDataFrame()
    {
        Dataset<Row> cleanDataFrame;
        cleanDataFrame = this.csvDataFrame.na().drop();
        cleanDataFrame = this.csvDataFrame.dropDuplicates();

        return cleanDataFrame;
    }

}
