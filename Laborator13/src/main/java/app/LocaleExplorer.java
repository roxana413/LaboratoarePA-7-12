package app;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;


public class LocaleExplorer {

    Properties commands = new Properties();
    InputStream zipStream;

    public void run() throws NullPointerException,ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
            IOException {

        //InputStream zipStream;
        URL resource = this.getClass().getClassLoader().getResource("Commands.properties");
        if (resource != null) {

                URLConnection urlConnection = resource.openConnection();
                urlConnection.setUseCaches(false);
                zipStream = urlConnection.getInputStream();

        }
        commands.load(zipStream);
        //commands.load(this.getClass().getClassLoader().getResourceAsStream("Messages.properties"));
        LocaleContext.setLocale("en-US");
        LocaleContext.setLocale("ro-RO");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(LocaleContext.message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;

            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales": {
                    Class clazz = Class.forName(commands.getProperty("display-locale.impl"));
                    clazz.getConstructor().newInstance();
                    break;
                }
                case "set": {
                    Class clazz = Class.forName(commands.getProperty("set-locale.impl"));
                    clazz.getConstructor(String.class).newInstance(params[1]);
                    break;

                }

                case "info": {
                    Class clazz = Class.forName(commands.getProperty("info-locale.impl"));
                    clazz.getConstructor(String.class).newInstance();
                    break;
                }

                default:
                    System.out.println(LocaleContext.message("invalid"));

            }
        }


    }

    public static void main(String args[]) throws NullPointerException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {
        new LocaleExplorer().run();
    }


}
