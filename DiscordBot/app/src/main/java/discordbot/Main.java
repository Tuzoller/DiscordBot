package discordbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main{

    private static String Key = "MTE0OTA4NTIwNzgyODM2NTM2Mw.GWdMbG.IeIJyx83RSiooMCZiRm2tEqFZrMIs5BgD2ArR0";

    public static void main(String[] args) throws LoginException, InterruptedException{
        JDABuilder builder = JDABuilder.createDefault(Key);
        builder.addEventListeners(new Listeners());
        
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
}
