package Commands;

import javax.annotation.Nonnull;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Speak extends ListenerAdapter{
    
    @Override
    public void onSlashCommandInteraction(@Nonnull  SlashCommandInteractionEvent event){
        if(!event.getName().equals("speak")) return; //String has to be all lowercase

        //Have to reply to interactions
        event.reply("Hello World").queue(); //Must queue responses
    }
}
