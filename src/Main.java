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
            if (isRunningFromJar()) {
                File f = new File(getRunningJarDirectory().getParent() + File.seperator + path);
            } else {
                File f = new File("src/assets/tokens.txt");
            }
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
    
    
    public static File getRunningJarDirectory() {
        return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath());
    }
    
    public static void setTokenPath(String path) {
       this.path = path;
    }
    
    public static boolean isRunningFromJar() {
           String className = this.getClass().getName().replace('.', '/');
           String classJar = this.getClass().getResource("/" + className + ".class").toString();
        
            if (classJar.startsWith("jar:")) {
                return true;
            } else return false;
  }
    
    
}
