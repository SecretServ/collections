package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {

        Solution sol = new Solution();
        SortedSet<String> sortedSet = new TreeSet();
        sortedSet.addAll(sol.constractor(args[0]));
        System.out.println(sortedSet);
    }


    public Set<String> constractor (String folder) {
        File path = new File(folder);
        Set<String> set = new HashSet<>();
        Set<String> setFolder = new HashSet<>();
        for (File file : path.listFiles()) {
            if (file.isFile()) {
                if (file.length() <= 50) {
                    set.add(file.getName());
                }
            } else {
                //constractor(folder + file);
                setFolder.add(file.getName());
            }
        }

        if (!setFolder.isEmpty()) {
            for (String subFolder : setFolder) {
                constractor(folder + subFolder);
            }
        }

        return set;
    }
}
