package discordbot;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

public class Listeners extends ListenerAdapter{

    public void onReady(@NotNull ReadyEvent event){
        JDA jda = event.getJDA();
        for(Guild guild : jda.getGuilds()){
            for(TextChannel channel : guild.getTextChannels()){
                channel.sendMessage("Online!").queue();
                return;
            }
        }
    }

    public void onMessageReceived(@NotNull MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;

        MessageChannel channel = event.getChannel();
        channel.sendMessage(event.getMessage().getContentRaw()).queue();
    }

    public void onSlashCommandInteraction(@NotNull SlashCommandInteraction event){
        
    }

}
