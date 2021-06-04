package com.company;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JavaClassLoader {
    public void invokeClassMethod(String classBinName) {

        try {

            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass(classBinName);

            System.out.println("Loaded class name: " + loadedMyClass.getName());

            System.out.println("From package: " + loadedMyClass.getPackage());

            Method[] methods = loadedMyClass.getDeclaredMethods();

            for (Method m : loadedMyClass.getMethods()) {
                int modifers = m.getModifiers();
                if (m.isAnnotationPresent(Test.class) && Modifier.isStatic(modifers)) {
                    System.out.println(m.getName() + " is Static and adnotated with @Test ");
                }
                else
                if (m.isAnnotationPresent(Test.class) && Modifier.isPublic(modifers)) {
                    System.out.println(m.getName() + " is Public  and adnotated with @Test ");
                }


            }

            List<String> actualMethods = getMethodNames(methods);
            System.out.println("Methods: " + actualMethods);


            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            // Getting the target method from the loaded class and invoke it using its name
            /*Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }


}
