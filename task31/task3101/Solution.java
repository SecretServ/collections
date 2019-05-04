package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {

        Solution sol = new Solution();
        SortedSet<String> sortedSet = new TreeSet();
        String path = args[0];
        File resultFileAbsolutePath = new File(args[1]);
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
        if (path.listFiles() == null) {
            return;
        } else {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.length() <= 50) {
                            set.add(file.getName());
                        }
                    } else if (file.isDirectory()) {
                        //constractor(folder + file);
                        setFolder.add(file.getName());
                    }
                }
            } else {
                return;
            }
        }



        /*if (!setFolder.isEmpty()) {
            //String
            for (String subFolder : setFolder) {
                //System.out.println(folder);
                //System.out.println(subFolder);
                String subPath = folder + "/" + subFolder;
                //System.out.println(folder + "/" + subFolder);
                //File
                setFolder.remove(subFolder);
                constractor(subPath);
            }
        }*/


        if (!setFolder.isEmpty()) {
            //for (int i = 0; i < setFolder.size(); i++) {
                //System.out.println(folder);
                //System.out.println(subFolder);
                //String subPath = folder + "/" + subFolder;
                Iterator<String> iter = setFolder.iterator();
                while (iter.hasNext()) {
                    String str = iter.next();
                    System.out.println(str);
                    //iterator.remove();
                    setFolder.remove(str);
                    constractor(folder + "/" + str);
                }
           } else {
            return;
        }
        //return set;
    }
}
