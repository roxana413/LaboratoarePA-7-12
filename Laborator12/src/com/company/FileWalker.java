package com.company;

import java.io.File;
import java.io.FilenameFilter;

public class FileWalker {
    public void walk(String path) {

        File root = new File(path);

        File[] list = root.listFiles();

        if (list == null) return;

        // This filter will only include files ending with .py
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".java");
            }
        };

     // This is how to apply the filter
        String[] pathnames;
        pathnames = root.list(filter);

        //facem afisarea
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
            JavaClassLoader javaClassLoader = new JavaClassLoader();
            String classname="classes."+pathname.substring(0, pathname.lastIndexOf('.')); //inlaturam extensia
            javaClassLoader.invokeClassMethod(classname);
        }





       /* for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath());
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
            }


        }*/

    }
}
