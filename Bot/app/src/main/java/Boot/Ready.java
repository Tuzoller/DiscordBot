package Boot;

import javax.annotation.Nonnull;

import IDS.ID;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ready extends ListenerAdapter{
     //On bot ready
    
    @Override
    public void onReady(@Nonnull ReadyEvent event){
        
        Guild guild = event.getJDA().getGuildById(ID.GuildID);
        TextChannel channel = event.getJDA().getTextChannelById(ID.textChannelID);
  
        if(guild != null && channel != null){
            guild.upsertCommand("speak", "Says hello").queue();
            guild.upsertCommand("users", "Gets names of all user in the guild").queue();
            //channel.sendMessage("Online!").queue();
        }
        else{
            System.out.println("Could not find the guild corresponding with the ID of: " + ID.GuildID);
        }
        
    }
}
