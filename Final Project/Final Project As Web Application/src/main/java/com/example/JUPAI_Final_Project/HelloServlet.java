package com.example.JUPAI_Final_Project;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.spark.sql.*;

@WebServlet(name = "helloServlet", value = "/hs")
public class HelloServlet extends HttpServlet {
    private String message;
    private String line;

    public void init()
    {
        message = "Hello World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        final SparkSession sparkSession = SparkSession.builder()
                .appName("Spark CSV AnalysisDemo")
                .master("local[2]")
                .getOrCreate();

        final DataFrameReader dataFrameReader = sparkSession.read();
        dataFrameReader.option("header", "true");
        final Dataset<Row> csvDataFrame = dataFrameReader.csv("C:\\Users\\Wssam\\IdeaProjects\\FinalProject\\src\\main\\resources\\Wuzzuf_Jobs.csv");


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");


    }

    public void destroy() {
    }
}