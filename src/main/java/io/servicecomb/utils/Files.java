package io.servicecomb.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Files {
    //tool class to deal files
    //list all file recursively and return java file list and xml file list seperately

    public List<String> javaFiles = new ArrayList<String>();
    public List<String> xmlFiles = new ArrayList<String>();

    public void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                //empty dir
            } else {
                for (File f : files){
                    if (f.isDirectory()) {
                        //recursive
                        traverseFolder(f.getAbsolutePath());
                    }else{
                        String filename = f.getAbsolutePath();
                        if (filename.endsWith(".java")){
                            javaFiles.add(filename);
                        } else if (filename.endsWith(".xml")) {
                            xmlFiles.add(filename);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Files fs = new Files();
        fs.traverseFolder("/home/bo/workspace/dubbo-example");
    }
}