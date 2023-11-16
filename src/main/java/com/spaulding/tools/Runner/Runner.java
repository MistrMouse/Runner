package com.spaulding.tools.Runner;

import com.spaulding.tools.Runner.objects.RunRecord;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static RunRecord runProcess(String[] commands) throws Exception {
        Process pro = Runtime.getRuntime().exec(commands);
        List<String> results = getResults(pro.getInputStream());
        List<String> errors = getResults(pro.getErrorStream());
        pro.waitFor();
        return new RunRecord(commands, results, errors, pro.exitValue());
    }

    private static List<String> getResults(InputStream ins) throws Exception {
        String line;
        List<String> results = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
           results.add(line);
        }
        return results;
    }
}
