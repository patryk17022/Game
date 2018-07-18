package pl.game.utility;

import pl.game.GameEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    private Image image;

    private Map<String, Image>map= new HashMap<String, Image>();

    public Image getTexture(String textureName) {

        image=map.get(textureName);

        return image;
    }

    public void getFile(String path) {

        try {
            ClassLoader classLoader = new GameEngine().getClass().getClassLoader();
            File fileFromResources = new File(classLoader.getResource(path).getFile());
            FileReader file = new FileReader(fileFromResources);
            BufferedReader bufferedReader = new BufferedReader(file);

            String line=bufferedReader.readLine();
            while (line != null) {

                int ktory=1;
                String imagePath="";
                String textureName = "";
                for (int i = 0; i < line.length(); i++) {

                    if ((line.charAt(i) == ' '|| line.charAt(i)==13) && ktory==1) {
                        ktory=2;
                    } else if ((line.charAt(i) == ' '|| line.charAt(i)==13) && ktory==2) {
                        getTexture(textureName);
                        File filePath = new File(classLoader.getResource(imagePath).getFile());
                        Image image = ImageIO.read(filePath);
                        map.put(textureName, image);
                        textureName = "";
                        imagePath="";
                        ktory=1;
                    }
                    else if(ktory==1){
                        textureName += line.charAt(i);
                    }
                    else{
                        imagePath+=line.charAt(i);
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

        resourceManager.getFile("Textures\\textures.txt");
    }

}
