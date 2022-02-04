package in.dream.ejb.services;

import in.dream.ejb.models.*;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.security.auth.login.CredentialException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Stateless
public class ForumService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;
    public Post createPost(String title, String content, Farmer farmer, Timestamp posttime) throws CreateException {
        if(title.length()<1 ) {
            throw new CreateException("Please enter title or content.");
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTime(posttime);
        post.setFarmer(farmer);

        try {
            em.persist(post);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
        return post;
    }

    public List<Post> getPost() {
        List<Post> result;

        try{
            result = em.createQuery("SELECT a from Post a order by a.time Desc ", Post.class).getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        return result;
    }
    public Post getPostByID(Long postid) {
        Post post;

        try{
            post = em.createQuery("SELECT a from Post a where a.postid=?1", Post.class)
                    .setParameter(1,postid)
                    .getSingleResult();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
        return post;
    }

    public void createComment(Farmer farmer, Post post, String content, Timestamp commenttime) throws CreateException {
        if(content.length()<1 ) {
            throw new CreateException("Please enter title or content.");
        }

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

    public List<Comment> getComment(Long postid) {
        List<Comment> result;

        try{
            result = em.createQuery("SELECT a from Comment a WHERE a.post.postid=?1 order by a.time Desc ", Comment.class).setParameter(1,postid).getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        return result;
    }


}