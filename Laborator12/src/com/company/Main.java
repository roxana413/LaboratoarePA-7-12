package com.company;

public class Main {

    public static void main(String[] args) {

         // JavaClassLoader javaClassLoader = new JavaClassLoader();
        //javaClassLoader.invokeClassMethod("com.company.MyClass");

        //cream o instanta pt FileWalker
        FileWalker fw = new FileWalker();

        //oferim path-ul directorul in care cautam
        fw.walk("C:\\Users\\Roxana\\Laborator12\\src\\classes" );


    }
}
