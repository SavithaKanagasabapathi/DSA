class Twitter {

    //TC:
    // postTweet:O(1)
    // follow / unfollow:O(1)
    // getNewsFeed:O(FLOGF), F no. of followees (including self), and at most 10 tweets returned.
    // Building heap: O(F log F) (each followee’s head tweet).
    // Each of up to 10 pops/pushes: O(10 log F).

    //Tweet id, time, previousTweet is the pointer that point previous tweet
    //It's like linkedlist, new tweet will be like head, has previous tweet pointer
    //In insta, if we view any account, recent post will show up, if we scroll, old ones
    class Tweet {
        int id, time;
        Tweet previousTweet;

        Tweet(int id, int time, Tweet previousTweet) {
            this.id = id;
            this.time = time;
            this.previousTweet = previousTweet;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;
    int time;//time to maintain tweet order/heap

    public Twitter() {//Initialize
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {//if userId present? then post tweet
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        tweetMap.put(userId, new Tweet(tweetId, time++, tweetMap.get(userId)));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feedList = new ArrayList<>();
        if (!followMap.containsKey(userId)) {
            return feedList;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);//desc/maxheap
        for (int followee : followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                if (tweetMap.get(followee) != null) {
                    pq.offer(tweetMap.get(followee));
                }
            }
        }
        //to get previous tweets from followers
        while (!pq.isEmpty() && feedList.size() < 10) {
            Tweet current = pq.poll();
            feedList.add(current.id);
            if (current.previousTweet != null) {
                pq.offer(current.previousTweet);
            }
        }
        return feedList;
    }

    public void follow(int followerId, int followeeId) {//check if user is following himself
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followerId);
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && (followeeId != followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
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