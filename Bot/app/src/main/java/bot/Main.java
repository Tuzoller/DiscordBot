package bot;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
//import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main extends ListenerAdapter{

    private static String Key = "MTE0OTA4NTIwNzgyODM2NTM2Mw.GNMjjX.sWJOnS3jTljSwVX3mLS5NNFA_0Owmu91rVxP_U";

 public static void main(String[] args) throws LoginException, InterruptedException{
        JDABuilder builder = JDABuilder.createDefault(Key);
        builder.addEventListeners(new Main());

        
        //Sets the discord bots activity in the discord server
        builder.setActivity(Activity.watching("Linus Tech Tips"));

         //Memory config
        configureMemoryUsage(builder);
        
        //Builds a new instance and sends it to the bot
         builder.build().awaitReady();
    }

    public static void configureMemoryUsage(JDABuilder builder){

         //Enable bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);

         //Disbales chache for member activities (streaming/games/spotify) and Voice states
        builder.disableCache(CacheFlag.ACTIVITY, CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        //Disables memeber chunking
         builder.setChunkingFilter(ChunkingFilter.NONE);

       //Disbales presence updates and typing events
        builder.disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING);

        //Considers guilds with more than 50 members as "large".
        //Large gui;ds will only provide online memebers in their setup reducing bandwith IF chunking is disaabled
        builder.setLargeThreshold(50);
    }

    private Long ID = 1148678336629973153L;

    //On bot ready
    @Override
    public void onReady(@Nonnull ReadyEvent event){
        // JDA jda = event.getJDA();
        // for(Guild guild : jda.getGuilds()){
        //     for(TextChannel channel : guild.getTextChannels()){
        //         channel.sendMessage("Online!").queue();
        //         return;
        //     }
        //}

        Guild guild = event.getJDA().getGuildById(ID);
        if(guild != null){
            guild.upsertCommand("speak", "Says hello").queue();
        }
        else{
            System.out.println("Could not find the guild corresponding with the ID of: " + ID);
        }
        
    }

    //Slash commands
    @Override
    public void onSlashCommandInteraction(@Nonnull  SlashCommandInteractionEvent event){
        if(!event.getName().equals("speak")) return; //String has to be all lowercase

        //Have to reply to interactions
        event.reply("Hello World").queue(); //Must queue responses
    }
}
