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
    public void createPost(String title, String content, Timestamp posttime) throws CreateException {
        if(title.length()<1 ) {
            throw new CreateException("Please enter title or content.");
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTime(posttime);

        try {
            em.persist(post);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    public List<Post> getPost() {
        List<Post> result;

        try{
            result = em.createQuery("SELECT a from post a order by time Desc ", Post.class).getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        return result;
    }

    public void createComment(String content, Timestamp posttime) throws CreateException {
        if(content.length()<1 ) {
            throw new CreateException("Please enter title or content.");
        }

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setTime(posttime);

        try {
            em.persist(comment);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    public List<Comment> getComment() {
        List<Comment> result;

        try{
            result = em.createQuery("SELECT a from comment a order by time Desc ", Comment.class).getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        return result;
    }


}