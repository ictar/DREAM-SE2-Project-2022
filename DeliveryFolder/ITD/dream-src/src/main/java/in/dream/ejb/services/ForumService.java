package in.dream.ejb.services;

import in.dream.ejb.models.*;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class ForumService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;
    public Post createPost(String title, String content, Farmer farmer, Timestamp posttime, Long forumId) throws CreateException {
        if(title.length()<1 ) {
            throw new CreateException("Please enter title or content.");
        }

        Forum forum = em.find(Forum.class, forumId);
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTime(posttime);
        post.setFarmer(farmer);
        post.setForum(forum);

        try {
            em.persist(post);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
        return post;
    }

    public List<Post> getForum() {
        return this.getPostList();
    }

    private List<Post> getPostList() {
        List<Post> result;

        try{
            result = em.createNamedQuery("Post.findAll", Post.class).getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        return result;
    }

    public Post getPost(Long postid) {
        Post post;

        try{
            post = em.createNamedQuery("Post.findOne", Post.class)
                    .setParameter(1,postid)
                    .getSingleResult();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
        return post;
    }

    public void createComment(Farmer farmer, Long postId, String content, Timestamp commenttime) throws CreateException {
        if(content.length()<1 ) {
            throw new CreateException("Please enter title or content.");
        }

        Post post = em.find(Post.class, postId);
        Comment comment = new Comment();
        comment.setFarmer(farmer);
        comment.setPost(post);
        comment.setContent(content);
        comment.setTime(commenttime);

        try {
            em.persist(comment);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

}