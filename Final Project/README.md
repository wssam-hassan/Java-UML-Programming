# N.B:
- If you want to run the project as web service and work properly without any porblems, you will need firstly to change the absolute paths of the csv file, a folder to save DataFrames as csv and the folder to save XChart images that must be the webapp folder "src/main/webapp".
- If you want to see the result of the web application, you can see the demo video provided with X2 speed due to the delay time of processing through this URL "https://youtu.be/_Qu9VjHnRJI"
- If you want to see the tasks, you can run the project as web application and choose the task as you wish in Main class and run.
 
# Final Project
This is the final project of Java and UML Programming course of the MCIT-ITI AI-Pro Program - Intake 1.

The Project was prepared by:

1. Wssam Hassan Ibrahim 

2. Mohammad Jamal Hanafy

3. Mohamed Ahmed Sayed

#

The Project consisted of multiple tasks as follow:

- Build all java needed classes (POJO , DAO, web service and a tester client for the web service)
- Make a web service to get the following from the data set
1. Read data set and convert it to dataframe or Spark RDD and display some from it.
2. Display structure and summary of the data.
3. Clean the data (null, duplications)
4. Count the jobs for each company and display that in order (What are the most demanding companies for jobs)
5. Show step 4 in a pie chart 
6. Find out What are it the most popular job titles 
7. Show step 6 in bar chart 
8. Find out the most popular areas
9. Show step 8 in bar chart 
10. Print skills one by one and how many each repeated and order the output to find out the most important skills required
11. Factorize the YearsExp feature and convert it to numbers in new col. (Bounce )
#
DataSet:

Wuzzuf jobs in Egypt data set at Kaggle
httpswww.kaggle.comomarhanyywuzzuf-jobs

#

The project was implemented using Java and included the following libraries:

- Apache Spark
- SMILE
- XChart
#
The project was deployed as a web service using the Tomcat server.
