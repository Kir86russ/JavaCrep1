import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crep {

    private boolean byRegex;
    private boolean filterInverted;
    private boolean ignoreCase;

    Crep(boolean byRegex, boolean filterInverted, boolean ignoreCase) {
        this.byRegex = byRegex;
        this.filterInverted = filterInverted;
        this.ignoreCase = ignoreCase;
    }

    public List<String> read(File inputFile, String word) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        String s = bf.readLine();
        if (ignoreCase)
            word = word.toLowerCase();


        if (byRegex) {
            while (s != null) {
                if (ignoreCase) {
                    if (Pattern.compile(word).matcher(s.toLowerCase()).find() ^ filterInverted)
                        list.add(s);
                } else if (Pattern.compile(word).matcher(s).find() ^ filterInverted) {
                    list.add(s);
                }
                s = bf.readLine();
            }
        } else {
            while (s != null) {
                if (ignoreCase) {
                    if (s.toLowerCase().contains(word) ^ filterInverted)
                        list.add(s);
                } else if (s.contains(word) ^ filterInverted) {
                    list.add(s);
                }
                s = bf.readLine();
            }
        }
        return list;
    }

    public void show(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}








