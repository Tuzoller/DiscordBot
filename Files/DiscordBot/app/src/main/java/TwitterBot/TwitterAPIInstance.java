import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPIInstance {
    public static Twitter createTwitterInstance() {
        String consumerKey = "YOUR_CONSUMER_KEY";
        String consumerSecret = "YOUR_CONSUMER_SECRET";
        String accessToken = "YOUR_ACCESS_TOKEN";
        String accessTokenSecret = "YOUR_ACCESS_TOKEN_SECRET";

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}
