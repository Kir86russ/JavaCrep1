import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Crep {

    private boolean byRegex;
    private boolean filterInverted;
    private boolean ignoreCase;

    public List<String> read(File inputFile, String word) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        String s = bf.readLine();


        if (byRegex) {
            while (s != null) {
                if (s.matches(word)) {
                    list.add(s);
                }
                s = bf.readLine();

            }


        }
        else {
            while (s != null){
                if (word.contains(s)) {
                    list.add(s);
                }
                s = bf.readLine();

            }
        }


       return list;
    }

}






