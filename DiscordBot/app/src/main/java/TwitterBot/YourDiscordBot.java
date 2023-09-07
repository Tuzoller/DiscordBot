package TwitterBot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import twitter4j.Twitter;

public class YourDiscordBot extends ListenerAdapter {
    private Twitter twitter;

    public YourDiscordBot() {
        twitter = TwitterAPIInstance.createTwitterInstance();
    }

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("YOUR_BOT_TOKEN");
        builder.addEventListeners(new YourDiscordBot());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // ... (Rest of your code)
    
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        MessageChannel channel = event.getChannel();
        User author = event.getAuthor();

        if (message.startsWith("!twitter ")) {
            String command = message.substring(9); // Extract the Twitter command
            String[] commandParts = command.split(" ", 2);

            if (commandParts.length >= 2) {
                String subCommand = commandParts[0];
                String subCommandArgs = commandParts[1];

                switch (subCommand) {
                    case "tweet":
                        tweet(subCommandArgs, channel);
                        break;
                    case "mention":
                        mention(subCommandArgs, channel);
                        break;
                    case "timeline":
                        timeline(author, channel);
                        break;
                    case "follow":
                        follow(subCommandArgs, channel);
                        break;
                    case "retweet":
                        retweet(subCommandArgs, channel);
                        break;
                    case "favorite":
                        favorite(subCommandArgs, channel);
                        break;
                    case "message":
                        messageUser(subCommandArgs, channel);
                        break;
                    case "search":
                        searchUsers(subCommandArgs, channel);
                        break;
                    case "followers":
                        listFollowers(author, channel);
                        break;
                    default:
                        channel.sendMessage("Invalid Twitter command.").queue();
                        break;
                }
            } else {
                channel.sendMessage("Invalid usage of !twitter command.").queue();
            }
        }
    }

}
