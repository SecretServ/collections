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
        String path = args[0];
        File resultFileAbsolutePath = new File(args[1]);

        FileUtils.renameFile(resultFileAbsolutePath,
                new File("allFilesContent.txt"));


        sol.constractor(path);
        sortedSet.addAll(sol.set);
        //sortedSet.addAll(sol.constractor(path));
        System.out.println(sortedSet);
    }


    public Set<String> set = new HashSet<>();
    public Set<String> setFolder = new HashSet<>();

    public void /*Set<String>*/ constractor (String folder) {
        File path = new File(folder);
        //Set<String> set = new HashSet<>();
        //Set<String> setFolder = new HashSet<>();

    }
}
