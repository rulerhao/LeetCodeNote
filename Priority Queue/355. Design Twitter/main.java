// Only show the tweets of followees.
// Show Most 10 recent tweets.
// I need to set a parameter called "time" and pair to each post so that I can get the

class Tweet {
    private int id;
    private int time;
    
    Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
    
    public int getId() {
        return id;
    }
    
    public int getTime() {
        return time;
    }
}

class User {
    private int id;
    private Stack<Tweet> tweets;
    private Set<User> followees;
    
    User(int id) {
        this.id = id;
        this.tweets = new Stack<>();
        this.followees = new HashSet<>();
    }
    
    public void postTweet(int tweetId, int time) {
        tweets.push(new Tweet(tweetId, time));
    }
    
    public void follow(User user) {
        followees.add(user);
    }
    
    public void unFollow(User user) {
        followees.remove(user);
    }
    
    public int getId() {
        return id;
    }
    
    public Stack<Tweet> getTweets() {
        return tweets;
    }
    
    public Set<User> getFollowees() {
        return followees;
    }
}

class Twitter {

    HashMap<Integer, User> users;
    int time;
    public Twitter() {
        users = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.postTweet(tweetId, time++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        
        PriorityQueue<Tweet> tweetQueue = getTweets(user);
            
        List<Integer> res = new LinkedList<>();
        while (res.size() < 10 && !tweetQueue.isEmpty()) {
            res.add(tweetQueue.poll().getId());
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        User followee = getUser(followeeId);
        
        user.follow(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = getUser(followerId);
        
        if (users.containsKey(followeeId)) {
            User followee;
            followee = users.get(followeeId);
            user.unFollow(followee);
        }
    }
    
    private User getUser(int userId) {
        User user;
        if (users.containsKey(userId)) {
            user = users.get(userId);
        } else {
            user = new User(userId);
            users.put(userId, user);
        }
        
        return user;
    }
    
    private PriorityQueue<Tweet> getTweets(User user) {
        Set<User> followees = user.getFollowees();
        PriorityQueue<Tweet> tweetQueue = new PriorityQueue<>(
            (a, b) -> b.getTime() - a.getTime()
        );
        followees.forEach((e) -> {
            Stack<Tweet> tweets = e.getTweets();
            tweets.forEach((t) -> {
                tweetQueue.add(t);
            });
        });
        user.getTweets().forEach( (t) -> {
            tweetQueue.add(t);
        });
        
        return tweetQueue;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
