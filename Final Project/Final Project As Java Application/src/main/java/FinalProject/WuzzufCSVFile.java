package FinalProject;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.lang3.math.NumberUtils;
import smile.data.DataFrame;
import smile.data.vector.IntVector;
import smile.io.Read;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class WuzzufCSVFile extends DataAndOperations {

    public WuzzufCSVFile(String path)
    {
        super(path);
    }

    public void FactorizeYearsExpFeature(boolean OldAndNewTogether)
    {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        try {
            DataFrame df = Read.csv(super.path, format);
            df = df.select("Title", "Company", "Location", "Type", "Level", "Country", "Skills", "YearsExp");

            String[] values = df.stringVector("YearsExp").toArray();
            List<String> values2 = Arrays.stream(values).map(x -> x.substring(0,2)).map(x -> x.split("-")).map(x -> x[0]).map(x -> x.split("\\+")).map(x -> x[0]).collect(Collectors.toList());
            List<Integer> val = values2.stream().map(x -> NumberUtils.isParsable(x) ? Integer.valueOf(x) : 0).collect(Collectors.toList());
            int[] fin = val.stream().mapToInt(i->i).toArray();

            df = df.merge(IntVector.of("Minimum Experience", fin));

            if (OldAndNewTogether)
                System.out.println(df);

            else
            {
                df = df.drop("YearsExp");
                System.out.println(df);
            }

        }
        catch (Exception e)
        {
            System.out.println("Error in Reading CSV File of Processing ... ");
        }
    }
}
