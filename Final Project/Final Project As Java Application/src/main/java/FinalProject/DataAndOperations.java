package FinalProject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.knowm.xchart.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import java.util.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAndOperations extends ReadCSVFile {

    private Dataset<Row> cleanDataFrame = cleanDataFrame();

    public DataAndOperations(String path)
    {
        super(path);
    }

    private Dataset<Row> jobsForCompany()
    {
        this.cleanDataFrame.createOrReplaceTempView("Temp_Table");
        final Dataset<Row> jobsForCompany = sparkSession.sql("select Company, count(Title) as NumberOfJobs from Temp_Table group by Company order by NumberOfJobs desc");
        return jobsForCompany;
    }

    public void showTopDemandingCompaniesForJops()
    {
        Dataset<Row> TDCFJ_DataFrame = jobsForCompany();
        TDCFJ_DataFrame.show();
    }

    public void showTopDemandingCompaniesForJops(int numberOfRow)
    {
        Dataset<Row> TDCFJ_DataFrame = jobsForCompany();
        TDCFJ_DataFrame.show(numberOfRow);
    }

    public void TopTenDemandingCompaniesPieChart()
    {
        Dataset<Row> TDCFJ_DataFrame = jobsForCompany();

        PieChart chart = new PieChartBuilder()
                .width(1024).height (728)
                .title("Top Ten Demanding Companies For Jobs")
                .build ();

        Color[] sliceColors = new Color[]{
                new Color(200, 50, 0),
                new Color (180, 68, 50),
                new Color (130, 105, 120),
                new Color (80, 143, 160),
                new Color (50, 100, 160),
                new Color (60, 200, 160),
                new Color (200, 100, 10),
                new Color (150, 150, 150),
                new Color (100, 100, 20),
                new Color (50, 10, 100)};
        chart.getStyler ().setSeriesColors (sliceColors);

        List<Row> arr1 = TDCFJ_DataFrame.select("NumberOfJobs").collectAsList();
        Long[] arr2 = new Long[arr1.size()];
        for (int i = 0; i < arr1.size(); i++)
            arr2[i] = (Long) arr1.get(i).get(0);
        int[] Num_values = Arrays.stream(arr2).mapToInt(x -> x.intValue()).toArray();

        List<Row> arr3= TDCFJ_DataFrame.select("Company").collectAsList();
        String[] companies = new String[10];
        for (int i = 0; i < 10; i++)
            companies[i] = (String) arr3.get(i).get(0);

        for (int i = 0; i <10; i++)
        {
            chart.addSeries(companies[i], Num_values[i]);
        }
        new SwingWrapper(chart).displayChart ();
    }

    private Dataset<Row> MostPopularJobs()
    {
        this.cleanDataFrame.createOrReplaceTempView("Temp_Table");
        final Dataset<Row> MostPopularJobs = sparkSession.sql("select Title, count(*) as NumberOfJobTitles  from Temp_Table group by Title order by NumberOfJobTitles desc");
        return MostPopularJobs;
    }

    public void showTopMostPopularJops()
    {
        Dataset<Row> TMPJ_DataFrame = MostPopularJobs();
        TMPJ_DataFrame.show();
    }

    public void showTopMostPopularJops(int numberOfRow)
    {
        Dataset<Row> TMPJ_DataFrame = MostPopularJobs();
        TMPJ_DataFrame.show(numberOfRow);
    }

    public void TopTenMostPopularJopsBarChart()
    {
        Dataset<Row> TTMPJ_DataFrame = MostPopularJobs();

        List<Row> arr = TTMPJ_DataFrame.select("NumberOfJobTitles").collectAsList();
        Long[] arr2 = new Long[10];
        for (int i = 0; i < 10; i++)
            arr2[i] = (Long) arr.get(i).get(0);
        int[] Num_values = Arrays.stream(arr2).mapToInt(x -> x.intValue()).toArray();

        List<Row> arr4 = TTMPJ_DataFrame.select("Title").collectAsList();
        String[] companies = new String[10];
        for (int i = 0; i < 10; i++)
            companies[i] = (String) arr4.get(i).get(0);

        CategoryChart chart = new CategoryChartBuilder()
                .width(1024).height (728)
                .title("The Most Popular Job Titles")
                .build ();

        Color[] sliceColors = new Color[]{
                new Color(200, 50, 0),
                new Color (180, 68, 50),
                new Color (130, 105, 120),
                new Color (80, 143, 160),
                new Color (50, 100, 160),
                new Color (60, 200, 160),
                new Color (200, 100, 10),
                new Color (150, 150, 150),
                new Color (100, 100, 20),
                new Color (50, 10, 100)};
        chart.getStyler ().setSeriesColors (sliceColors);

        int[] accurate_num = new int[1];
        for (int i = 0; i <10; i++)
        {
            accurate_num[0] = Num_values[i];
            chart.addSeries(companies[i], accurate_num, accurate_num);
        }
        new SwingWrapper (chart).displayChart ();
    }

    private Dataset<Row> MostPopularAreas()
    {
        this.cleanDataFrame.createOrReplaceTempView("Temp_Table");
        final Dataset<Row> MostPopularAreas = sparkSession.sql("select Country, count(*) as NumberOfAreas  from Temp_Table group by Country order by count(Country) desc");
        return MostPopularAreas;
    }

    public void showTopMostPopularAreas()
    {
        Dataset<Row> TMPA_DataFrame = MostPopularAreas();
        TMPA_DataFrame.show();
    }

    public void showTopMostPopularAreas(int numberOfRow)
    {
        Dataset<Row> TMPA_DataFrame = MostPopularAreas();
        TMPA_DataFrame.show(numberOfRow);
    }

    public void TopTenMostPopularAreasBarChart()
    {
        Dataset<Row> TTMPA_DataFrame = MostPopularAreas();

        List<Row> arr = TTMPA_DataFrame.select("NumberOfAreas").collectAsList();
        Long[] arr2 = new Long[10];
        for (int i = 0; i < 10; i++)
            arr2[i] = (Long) arr.get(i).get(0);
        int[] Num_values = Arrays.stream(arr2).mapToInt(x -> x.intValue()).toArray();

        List<Row> arr4 = TTMPA_DataFrame.select("Country").collectAsList();
        String[] companies = new String[10];
        for (int i = 0; i < 10; i++)
            companies[i] = (String) arr4.get(i).get(0);

        CategoryChart chart = new CategoryChartBuilder()
                .width(1024).height (728)
                .title("The Most Popular Areas")
                .build ();

        Color[] sliceColors = new Color[]{
                new Color(200, 50, 0),
                new Color (180, 68, 50),
                new Color (130, 105, 120),
                new Color (80, 143, 160),
                new Color (50, 100, 160),
                new Color (60, 200, 160),
                new Color (200, 100, 10),
                new Color (150, 150, 150),
                new Color (100, 100, 20),
                new Color (50, 10, 100)};
        chart.getStyler ().setSeriesColors (sliceColors);

        int[] accurate_num = new int[1];
        for (int i = 0; i <10; i++)
        {
            accurate_num[0] = Num_values[i];
            chart.addSeries(companies[i], accurate_num, accurate_num);
        }
        new SwingWrapper (chart).displayChart ();
    }

    public void printSkillsOneByOne()
    {
        this.cleanDataFrame.createOrReplaceTempView("Temp_Table");
        final Dataset<Row> Skills = sparkSession.sql("select Skills from Temp_Table");

        List<String> skillsList = Skills.as(Encoders.STRING()).collectAsList();
        sparkSession.close();

        SparkConf conf = new SparkConf().setAppName ("Skills Counts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);

        JavaRDD<String> skillRDD = sparkContext.parallelize(skillsList,1);
        JavaRDD<String> cleanskill = skillRDD.flatMap(skillrecord -> Arrays.asList(skillrecord.toLowerCase().trim().replaceAll("\\p{Punct}", "&").split("&")).iterator());
        Map<String, Long> skillsCounts = cleanskill.countByValue();
        List<Map.Entry> sorted = skillsCounts.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (Map.Entry<String, Long> entry : sorted)
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sparkContext.close();
    }


    public Dataset<Row> getCleanDataFrame() {
        return this.cleanDataFrame;
    }
}
