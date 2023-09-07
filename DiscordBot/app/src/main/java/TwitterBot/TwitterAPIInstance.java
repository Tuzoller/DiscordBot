package TwitterBot;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPIInstance {
    public static Twitter createTwitterInstance() {
        String consumerKey = "X1x9LUN1sDLnH0Tqd6wfUKYrp";
        String consumerSecret = "UGB5GJptRairjfTPfH9I75GdmT18BEcm46DGvVCozWLmpPkaMP";
        String accessToken = "1615824629695643648-VjPZPMxFoq10VyM4Jz8BTZRFVD7ffv";
        String accessTokenSecret = "qMic0nfEZkF6TZOjyskA9lvH9QQnvKAFirNlvezclR1Bx";

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
