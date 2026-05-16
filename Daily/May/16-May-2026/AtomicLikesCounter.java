import java.util.concurrent.atomic.AtomicInteger;

class AtomicLikesCounter {

    public static void main(String[] args) {

        Post post = new Post();

        for (int i = 1; i <= 25; i++) {

            new UserThread(post, "User-" + i).start();
        }
    }
}

class Post {

    private AtomicInteger likes = new AtomicInteger(0);
    // int likes =0;

    public void likePost(String user) {

        int totalLikes = likes.incrementAndGet();

        // int totalLikes = likes++;

        System.out.println(user + " liked the post"
                + " | Total Likes: " + totalLikes);
    }

    public int getLikes() {
        // return likes;
        return likes.get();
    }
}

class UserThread extends Thread {

    Post post;
    String user;

    UserThread(Post post, String user) {
        this.post = post;
        this.user = user;
    }

    public void run() {
        post.likePost(user);
    }
}
