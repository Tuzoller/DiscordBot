package TwitterBot;

import javax.annotation.Nonnull;

import com.twitter.clientlib.api.TwitterApi;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TwitterbotIntegration extends ListenerAdapter {
    
    private TwitterApi apiInstance;
    private String APIKEY = "X1x9LUN1sDLnH0Tqd6wfUKYrp";
    private String APISECRETKEY = "UGB5GJptRairjfTPfH9I75GdmT18BEcm46DGvVCozWLmpPkaMP";
    private String ACCESSTOKEN = "1615824629695643648-VjPZPMxFoq10VyM4Jz8BTZRFVD7ffv";
    private String ACCESSTOKENSECRET = "qMic0nfEZkF6TZOjyskA9lvH9QQnvKAFirNlvezclR1Bx";

    public TwitterbotIntegration(){
       
    }

    @Override
    public void onSlashCommandInteraction(@Nonnull  SlashCommandInteractionEvent event){
        if(!event.getName().equals("twitter")) return;

        //Have to reply to interactions
        event.reply("TwitterCommand").queue();
    }
}
