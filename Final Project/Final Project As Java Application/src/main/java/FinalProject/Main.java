package FinalProject;

import com.fasterxml.jackson.module.scala.introspect.ScalaAnnotationIntrospector;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.hadoop.fs.*;
import org.apache.spark.sql.SaveMode;
import java.util.Scanner;
import java.io.File;

import smile.data.*;



public class Main {
    public static void main(String[] args) {

        String path = "src/main/resources/Wuzzuf_Jobs.csv";

        WuzzufCSVFile wuzzuf = new WuzzufCSVFile(path);

        // Task 1
        wuzzuf.get_csvDataFrame().show();

        // Task 2
        wuzzuf.showSchema();
        wuzzuf.showSummary();

        // Task 3
        wuzzuf.cleanDataFrame().show();

        // Task 4
        wuzzuf.showTopDemandingCompaniesForJops();

        // Task 5
        wuzzuf.TopTenDemandingCompaniesPieChart();

        // Task 6
        wuzzuf.showTopMostPopularJops();

        // Task 7
        wuzzuf.TopTenMostPopularJopsBarChart();

        // Task 8
        wuzzuf.showTopMostPopularAreas();

        // Task 9
        wuzzuf.TopTenMostPopularAreasBarChart();

        // Task 10
        wuzzuf.printSkillsOneByOne();

        // Task 11
        wuzzuf.FactorizeYearsExpFeature(true);
        
    }
}
