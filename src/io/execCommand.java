package io;

import java.io.File;
import java.io.IOException;

/**
 * Created by a.talismanov on 08.08.2016.
 */
public class ExecCommand {
    public static void main(String[] args) {
        try {
            Process runtime = Runtime.getRuntime().exec("cmd /c start notepad++.exe");
            Process runtime3 =  Runtime.getRuntime().exec("cmd /c start cmd.exe", null, new File("C:\\"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }
}
