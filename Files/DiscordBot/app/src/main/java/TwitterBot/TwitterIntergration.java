import twitter4j.*;

import java.util.ArrayList;

public class TwitterIntegration {
    private Twitter twitter;

    public TwitterIntegration(Twitter twitter) {
        this.twitter = twitter;
    }

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public Status tweet(String tweetText) throws TwitterException {
        return twitter.updateStatus(tweetText);
    }

    public User getUser(String username) throws TwitterException {
        return twitter.showUser(username);
    }

    public ResponseList<Status> getUserTimeline(long userId) throws TwitterException {
        return twitter.getUserTimeline(userId, new Paging(1, 5)); // Retrieve the last 5 tweets
    }

    public void followUser(long userId) throws TwitterException {
        twitter.createFriendship(userId);
    }

    public void retweetStatus(long statusId) throws TwitterException {
        twitter.retweetStatus(statusId);
    }

    public void favoriteStatus(long statusId) throws TwitterException {
        twitter.createFavorite(statusId);
    }

    public DirectMessage sendDirectMessage(String recipientUsername, String message) throws TwitterException {
        return twitter.sendDirectMessage(recipientUsername, message);
    }

    public ArrayList<User> searchUsers(String query) throws TwitterException {
        ArrayList<User> users = new ArrayList<>();
        QueryResult result = twitter.searchUsers(query, 10); // Search for up to 10 users matching the query

        for (User user : result.getUsers()) {
            users.add(user);
        }
        return users;
    }

    public ArrayList<User> listFollowers(long userId) throws TwitterException {
        ArrayList<User> followers = new ArrayList<>();
        PagableResponseList<User> followerList = twitter.getFollowersList(userId, -1, 10); // Retrieve up to 10 followers

        for (User follower : followerList) {
            followers.add(follower);
        }
        return followers;
    }
}
