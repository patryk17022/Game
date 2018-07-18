package pl.game.gameStates;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class ResourceManager {

    private Image image;

    public Image getTexture(String tekxtureName) {

        return image;
    }

    public void getFile(String path) {

        try {
             FileReader file = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(file);

            String line=bufferedReader.readLine();
            while (line != null) {

                String textureName = "";
                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) == ' '|| line.charAt(i)==13) {
                        getTexture(textureName);
                        System.out.println(textureName);
                        textureName = "";
                    } else {
                        textureName += line.charAt(i);
                    }
                }
                line=bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch(Exception ex) { ex.printStackTrace();}

    }

    public static void main(String [ ] args)
    {
        ResourceManager resourceManager= new ResourceManager();

        resourceManager.getFile("C:\\Users\\SQ054\\Desktop\\Monia\\Moje_projekty\\gra\\przyklad\\przyklad.txt");
    }

}
