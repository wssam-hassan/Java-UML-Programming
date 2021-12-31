package TitanicData;
import org.apache.commons.csv.*;
import smile.data.*;
import smile.data.vector.IntVector;
import smile.io.*;
import smile.data.measure.NominalScale;
import smile.plot.swing.Histogram;

public class ReadTitanicData {

    public static int[] encodeCategory(DataFrame df, String columnName) {
        String[] values = df.stringVector (columnName).distinct ().toArray (new String[]{});
        int[] pclassValues = df.stringVector (columnName).factorize (new NominalScale (values)).toIntArray ();
        return pclassValues;
    }

    public static void main(String[] args) {

        // Load Titanic Data
        String path = "src/main/resources/titanic.csv";
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        try {
            DataFrame df = Read.csv(path, format);

            // Some Data Exploration Activities
            System.out.println(df.schema());
            System.out.println(".......");
            System.out.println(df.structure());
            System.out.println(".......");
            System.out.println(df.summary());

            // Try to join and add columns of specific datatype to DataFrames
            df = df.merge(IntVector.of("NominalSex", encodeCategory(df, "Sex")));
            DataFrame df1 = df.drop("Sex", "SibSp", "Parch", "Ticket", "Fare", "Cabin", "Embarked");        //The same as df2
            DataFrame df2 = df.select("PassengerId", "Survived", "Pclass", "Name", "Age", "NominalSex");    //The same as df1
            System.out.println(df2);

            //Clean DataFrame and Visualize Sex column in Histogram Chart
            df2 = df2.omitNullRows();

            Histogram.of(df2.intVector("NominalSex").toIntArray(), 4, false)
                    .canvas().setAxisLabels("Gender ( Male = 0 & Female = 1 )", "Numbers")
                    .setTitle("Numbers of Each Gender")
                    .window();

        }
        catch (Exception e)
        {
            System.out.println("Error .....");
        }
    }
}
