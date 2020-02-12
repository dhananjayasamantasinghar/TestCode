package com.srp;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class TestApplication {
    public static void main(String[] args) {
        String location_1 = "C:\\Users\\C0262466\\Downloads\\anuja\\A";
        String location_2 = "C:\\Users\\C0262466\\Downloads\\anuja\\B";
        String extension = ".zip";
        List<String> dir1 = getListOfFileNames(location_1, extension);
        List<String> dir2 = getListOfFileNames(location_2, extension);
        System.out.println(getListOfNames(dir1, dir2));
    }

    public static List<String> getListOfNames(List<String> dir1, List<String> dir2) {
        if (dir1.size() == dir2.size()) {
            return Collections.emptyList();
        }

        return (dir1.size() > dir2.size()) ? filterData(dir1, dir2) : filterData(dir2, dir1);
    }

    private static List<String> filterData(List<String> dir1, List<String> dir2) {
        return dir1.stream()
                .filter(e -> !dir2.contains(e))
                .map(e->e.split("_")[0])
                .collect(Collectors.toList());
    }
    
    private static List<String> getListOfFileNames(String location, String extension){
       return  Arrays.stream(new File(location).listFiles())
               .filter(file -> file.getName().contains(extension))
               .map(File::getName)
               .collect(Collectors.toList());
    }

}
