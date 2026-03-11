package com.example.speedlimit;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class CSVReader {
    Context context;
    String fileName;
    List<String[]> rows = new ArrayList<>();

    public CSVReader(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public List<String[]> readCSV() throws IOException {
        InputStream is = context.getAssets().open("water_potability.csv");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        String csvSplitBy = ",";

        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] row = line.split(csvSplitBy);
            rows.add(row);
        }
        return rows;
    }
}