import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static ArrayList<Bot> bots = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        try {
            File f = new File("src/assets/tokens.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                Bot c = new Bot(readLine);
                bots.add(c);
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace().toString());
        }


      /*  for (int i = 0; i > 9000 ; i++ ) {
            for(Bot j : bots) {
                if (!j.getJda().getGuilds().isEmpty()) {
                    Guild versai = j.getJda().getGuilds().get(0);
                    List<TextChannel> channels = versai.getTextChannels();
                    for (TextChannel channel : channels) {
                        if (channel.canTalk()) {
                                channel.sendMessage("megalunchbox and datpigmaster are god.").queue();
                        }
                    }
                }
            }
        }
*/

    }
}
