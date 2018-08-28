import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Main {

    public static ArrayList<Bot> bots = new ArrayList<>();
    public static String path = "tokens.txt";

    public static void main(String[] args) throws IOException {


        try {
            File f = new File("src/assets/tokens.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("getting tokens");

            while ((readLine = b.readLine()) != null) {
                Bot c = new Bot(readLine);
                bots.add(c);
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace().toString());
        }
    }
    
    
    public File getRunningJarDirectory() {
        return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath());
    }
    
    public void setTokenPath(String path) {
       this.path = path;
    }
    
    
}
