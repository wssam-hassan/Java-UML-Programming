package TaskSelector;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface DFtoCSV {

    public static String DFtoCSVwithAbsolutePath(Dataset<Row> df, String targetFolder)
    {
        df.coalesce(1).write().mode(SaveMode.Overwrite).option("header", true).csv(targetFolder);

        File file = new File(targetFolder);
        String[] files = file.list();
        List<String> filePathlist = Arrays.stream(files).filter(x -> x.endsWith("csv")).collect(Collectors.toList());
        String filePath = filePathlist.get(0);
        return targetFolder + "/" + filePath;
    }
}
