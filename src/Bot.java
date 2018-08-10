import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

import javax.security.auth.login.LoginException;

public class Bot {


    private JDA jda;

    public Bot(String token){
        try {
            JDA jda = new JDABuilder(AccountType.CLIENT).setToken(token).buildBlocking();
            this.jda = jda;
            jda.addEventListener(new EventListener(jda));
            jda.setAutoReconnect(true);
            jda.getPresence().setPresence(OnlineStatus.INVISIBLE, true);

        } catch (LoginException e) {
            System.out.println("error getting token!");
        } catch (InterruptedException e1) {
            System.out.println("InterruptedException");
        }
    }

    public JDA getJda() {
        return jda;
    }
}
