package Listen;

import javax.annotation.Nonnull;

//import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
//import net.dv8tion.jda.api.entities.MessageChannel;
//import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
//import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listeners extends ListenerAdapter{

    private Long ID = 1148678336629973153L;

    @Override
    public void onReady(@Nonnull ReadyEvent event){
        // JDA jda = event.getJDA();
        // for(Guild guild : jda.getGuilds()){
        //     for(TextChannel channel : guild.getTextChannels()){
        //         channel.sendMessage("Online!").queue();
        //         return;
        //     }
        // }

        Guild guild = event.getJDA().getGuildById(ID);
        if(guild != null){
            guild.upsertCommand("speak", "Says hello").queue();
        }
        else{
            System.out.println("Could not find the guild corresponding with the ID of: " + ID);
        }
        
    }

    // public void onMessageReceived(@NotNull MessageReceivedEvent event){
    //     if(event.getAuthor().isBot()) return;

    //     MessageChannel channel = event.getChannel();
    //     channel.sendMessage(event.getMessage().getContentRaw()).queue();
    // }

}
