import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //char[] chars=new char[]{'@','#','S','%','?','*','+',';',':',',','.'};
        char[] chars = new char[] {'.', ',', ':', ';', '+', '*', '?', '%', 'S', '#', '@'};

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("img/img.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        assert img!=null;

        StringBuilder str=new StringBuilder();
        for(int y = 0; y<img.getHeight(); y++) {
            for(int x = 0; x<img.getWidth(); x++) {
                int value = (getRed(img, x, y) + getGreen(img, x, y) + getBlue(img, x, y))/3;
                str.append(chars[(int)((double)chars.length*value/256)]);
            }
            str.append('\n');
        }

        System.out.println(str.toString());
    }

    private static int getRed(BufferedImage img, int x, int y) {
        return new Color(img.getRGB(x, y)).getRed();
    }
    private static int getGreen(BufferedImage img, int x, int y) {
        return new Color(img.getRGB(x, y)).getGreen();
    }
    private static int getBlue(BufferedImage img, int x, int y) {
        return new Color(img.getRGB(x, y)).getBlue();
    }
}