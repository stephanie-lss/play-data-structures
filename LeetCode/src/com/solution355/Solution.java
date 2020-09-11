package com.solution355;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/13 9:42
 */
class Twitter {

    private int timestamp = 0;
    private HashMap<Integer, User> userMap;

    class User {
        private Integer userId;
        private Set<Integer> followed;
        private Node head;

        public User(Integer userId) {
            this.userId = userId;
            this.followed = new HashSet<>();
            this.head = null;
            follow(userId);
        }

        public void follow(int followeeId) {
            followed.add(followeeId);
        }

        public void unfollow(int unFolloweeId) {
            if (userId != unFolloweeId) {
                followed.remove(unFolloweeId);
            }
        }

        public void postTweet(int tweetId) {
            Node newTweet = new Node(tweetId, timestamp);
            newTweet.next = head;
            head = newTweet;
            timestamp++;
        }
    }

    class Node {
        private Integer tweetId;
        private Integer time;
        private Node next;

        public Node() {
        }

        public Node(Integer tweetId, Integer time) {
            this.tweetId = tweetId;
            this.time = time;
        }

    }


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            user.postTweet(tweetId);
            userMap.put(userId, user);
        } else {
            User user = userMap.get(userId);
            user.postTweet(tweetId);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return tweets;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Node> queue = new PriorityQueue<>(users.size(), new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.time - o1.time;
            }
        });
        for (Integer user : users) {
            Node tweet = userMap.get(user).head;
            if (tweet == null) {
                continue;
            }
            queue.add(tweet);
        }
        while (!queue.isEmpty()) {
            Node tweet = queue.poll();
            tweets.add(tweet.tweetId);
            if (tweet.next != null) {
                queue.add(tweet.next);
            }
            if (tweets.size() == 10) {
                break;
            }
        }
        return tweets;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.unfollow(followeeId);
        }
    }
}
