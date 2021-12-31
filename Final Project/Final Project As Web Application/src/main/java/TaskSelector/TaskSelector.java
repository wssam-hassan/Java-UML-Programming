package TaskSelector;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.spark.sql.Dataset;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.spark.sql.Row;
import smile.data.DataFrame;
import smile.data.vector.IntVector;
import smile.io.Read;

@WebServlet(name = "TaskSelector", value = "/TaskSelector")
public class TaskSelector extends HttpServlet implements DFtoCSV {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Aboslute Path of the csv File
        String path = "C:/Users/Wssam/IdeaProjects/JUPAI_Final_Project/src/main/resources/Wuzzuf_Jobs.csv";
        DataAndOperations wuzzuf = new DataAndOperations(path);

        // Aboslute Path For Saving DataFrames to CSV
        String toCSVPath = "C:/Users/Wssam/IdeaProjects/JUPAI_Final_Project/src/main/resources/toCSV";

        // Aboslute Path For Saving XChart Visuals
        String imagesPath = "C:/Users/Wssam/IdeaProjects/JUPAI_Final_Project/src/main/webapp";

        String url1 = "/Task1.jsp";
        String url2 = "/Task2.jsp";
        String url3 = "/Task3.jsp";
        String url4 = "/Task4.jsp";
        String url5 = "/Task5.jsp";
        String url6 = "/Task6.jsp";
        String url7 = "/Task7.jsp";
        String url8 = "/Task8.jsp";
        String url9 = "/Task9.jsp";
        String url10 = "/Task10.jsp";
        String url11 = "/Task11.jsp";
        String url12 = "/Tasks.jsp";

        String id = request.getParameter("id");

        if (Integer.parseInt(id) == 1)
        {
            String task1 = path;
            request.setAttribute("Task1", task1);
            getServletContext()
                    .getRequestDispatcher(url1)
                    .forward(request, response);
        }

        else if (Integer.parseInt(id) == 2)
        {

            String getschema = wuzzuf.Schema();

            String schema = "";
            String[] cont = getschema.split(",");
            for (String val: cont)
            {
                schema =  schema.concat(val);
                schema =  schema.concat("<br>");
            }
            request.setAttribute("Task22", schema);


            Dataset<Row> df = wuzzuf.Summary();

            String task2 = DFtoCSV.DFtoCSVwithAbsolutePath(df, toCSVPath);
            request.setAttribute("Task2", task2);

            getServletContext()
                    .getRequestDispatcher(url2)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 3)
        {
            Dataset<Row> df = wuzzuf.cleanDataFrame();

            String task3 = DFtoCSV.DFtoCSVwithAbsolutePath(df, toCSVPath);
            request.setAttribute("Task3", task3);
            getServletContext()
                    .getRequestDispatcher(url3)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 4) {
            Dataset<Row> df = wuzzuf.jobsForCompany();

            String task4 = DFtoCSV.DFtoCSVwithAbsolutePath(df, toCSVPath);
            request.setAttribute("Task4", task4);
            getServletContext()
                    .getRequestDispatcher(url4)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 5) {
            String imageName = imagesPath + "/Task5.jpg";
            wuzzuf.TopTenDemandingCompaniesPieChart(imageName);

            getServletContext()
                    .getRequestDispatcher(url5)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 6) {
            Dataset<Row> df = wuzzuf.MostPopularJobs();

            String task6 = DFtoCSV.DFtoCSVwithAbsolutePath(df, toCSVPath);
            request.setAttribute("Task6", task6);
            getServletContext()
                    .getRequestDispatcher(url6)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 7) {
            String imageName = imagesPath + "/Task7.jpg";
            wuzzuf.TopTenMostPopularJopsBarChart(imageName);

            getServletContext()
                    .getRequestDispatcher(url7)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 8) {
            Dataset<Row> df = wuzzuf.MostPopularAreas();

            String task8 = DFtoCSV.DFtoCSVwithAbsolutePath(df, toCSVPath);
            request.setAttribute("Task8", task8);
            getServletContext()
                    .getRequestDispatcher(url8)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 9) {
            String imageName = imagesPath + "/Task9.jpg";
            wuzzuf.TopTenMostPopularAreasBarChart(imageName);

            getServletContext()
                    .getRequestDispatcher(url9)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 10) {

            String task10 = wuzzuf.printSkillsOneByOne();
            request.setAttribute("Task10", task10);
            getServletContext()
                    .getRequestDispatcher(url10)
                    .forward(request, response);
        }


        else if (Integer.parseInt(id) == 11) {

            CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
            DataFrame df;

            try {
                    df = Read.csv(path, format);
                    df = df.select("Title", "Company", "Location", "Type", "Level", "Country", "Skills", "YearsExp");
                    String[] values = df.stringVector("YearsExp").toArray();
                    List<String> values2 = Arrays.stream(values).map(x -> x.substring(0,2)).map(x -> x.split("-")).map(x -> x[0]).map(x -> x.split("\\+")).map(x -> x[0]).collect(Collectors.toList());
                    List<Integer> val = values2.stream().map(x -> NumberUtils.isParsable(x) ? Integer.valueOf(x) : 0).collect(Collectors.toList());
                    int[] fin = val.stream().mapToInt(i->i).toArray();

                    df = df.merge(IntVector.of("Minimum Experience", fin));
                    df = df.drop("YearsExp");

                String[][] strdf = df.toStrings(df.nrows());

                String task11 = "";
                for (int i =0; i<df.nrows(); i++)
                {
                    for (int j =0; j<8 ; j++)
                    {
                        task11 = task11.concat(strdf[i][j]);
                        task11 = task11.concat(",");
                    }
                    task11 = task11.substring(0, task11.length()-1);
                    task11 = task11.concat("<br>");
                }

                request.setAttribute("Task11", task11);
                getServletContext()
                        .getRequestDispatcher(url11)
                        .forward(request, response);


                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
        }


        else if (Integer.parseInt(id) == 12) {
            getServletContext()
                    .getRequestDispatcher(url12)
                    .forward(request, response);
        }


        else{
            getServletContext()
                    .getRequestDispatcher(url12)
                    .forward(request, response);
        }

    }
}
