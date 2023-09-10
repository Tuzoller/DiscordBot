package Commands;
import java.util.List;

import javax.annotation.Nonnull;

import IDS.ID;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Users extends ListenerAdapter {

    private Guild guild;
    private TextChannel channel;
    private List<Member> members;

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event){
        if(!event.getName().equals("users")) return; //If the command doesn't start with users then return from this method
    
        guild = event.getJDA().getGuildById(ID.GuildID);
        channel = event.getJDA().getTextChannelById(ID.textChannelID);
        members = event.getJDA().getGuildById(ID.GuildID).getMembers();
        
        if(guild != null && channel != null){
            channel.sendMessage(listOfUsers()).queue();
            System.out.println(members.size());
        }
    }
    
    private String listOfUsers(){
        String list = new String("");
        
        for(Member member: members){
            list += member.getEffectiveName();
        }

        return list;
    }
}
