
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Random;


public class EventListener implements net.dv8tion.jda.core.hooks.EventListener{

    JDA jda;

    public EventListener(JDA jda) {
        this.jda = jda;
    }


    @Override
    public void onEvent(Event e) {
        if (e instanceof MessageReceivedEvent) {

            String message = ((MessageReceivedEvent) e).getMessage().getContentDisplay();

            if (((MessageReceivedEvent) e).isFromType(ChannelType.PRIVATE)) {
                if (((MessageReceivedEvent) e).getAuthor() != getJda().getSelfUser())
                ((MessageReceivedEvent) e).getChannel().sendMessage("hihihihiihi").queue();
            }

            if (((MessageReceivedEvent) e).isFromType(ChannelType.TEXT)) {
                Guild guild = ((MessageReceivedEvent) e).getGuild();
                guild.getName();
                System.out.println("Guild name: " + guild.getName());

                List<TextChannel> channels = guild.getTextChannels();

                for (TextChannel channel : channels) {
                    if (channel.canTalk()) {
                        if (message.toLowerCase().equals("barrage incoming") || message.toLowerCase().equals("barrage commencing") || message.toLowerCase().equals("go")) {
                            channel.sendMessage("spamspamspamspamspamspamspamspam").queue();
                            channel.sendMessage("barrage commencing").queue();
                            List<Member> members = guild.getMembers();
                            Random rand = new Random();
                            int randomNum = rand.nextInt((members.size() - 0));
                            String msg = members.get(randomNum).getAsMention();
                            channel.sendMessage(msg).queue();
                        }
                    }
                }

            }

        }
    }

    public JDA getJda() {
        return jda;
    }
}
