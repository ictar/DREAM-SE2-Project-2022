package in.dream.ejb.services;

import in.dream.ejb.models.Comment;
import in.dream.ejb.models.Forum;
import in.dream.ejb.models.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ForumServiceTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private ForumService forumService = new ForumService();

    @Mock
    private TypedQuery<Object> query;

    private Forum forum;
    private Post post;
    private static final Long PID = 3L;
    private static final Long PID_NOTEXIST = 33L;
    private static final String TITLE = "post title";
    private static final String CONTENT = "post content";
    private static final Timestamp TIME = new Timestamp(System.currentTimeMillis());

    private Comment comment;


    @BeforeEach
    public void setup(){
        when(query.setParameter(anyString(), any())).thenReturn(query);
        when(query.setParameter(anyInt(), any())).thenReturn(query);

        forum = new Forum();
        forum.setForumid(1L);

        post = new Post();
        post.setPostid(PID);
        post.setTitle(TITLE);
        post.setContent(CONTENT);
        post.setTime(TIME);
        post.setForum(forum);
    }
    @AfterEach
    public void tearDown() {

    }

    private void comparePosts(Post a, Post b) {
        assertEquals(a.getPostid(), b.getPostid());
        assertEquals(a.getTitle(), b.getTitle());
        assertEquals(a.getContent(), b.getContent());
        assertEquals(a.getTime(), b.getTime());
        assertEquals(a.getForum().getForumid(), b.getForum().getForumid());
    }
    @Test
    void createPost() {
    }

    @Test
    void getPost() {
        // prepare
        when(em.createNamedQuery(eq("Post.findAll"), any())).thenReturn(query);

        List<Object> dummyResult = new ArrayList<Object>();
        when(query.getResultList()).thenReturn(dummyResult);

        // now begin
        List<Post> result = forumService.getPost();
        // did it request the named query?
        verify(em).createNamedQuery("Post.findAll", Post.class);
        // did it ask for the result list of the named query?
        verify(query).getResultList();
        // did it return the result list of the named query?
        assertSame(dummyResult, result);

        // success, it did all of the above!
    }

    @Test
    void getPostByID_notexist() {
        // prepare
        when(em.createNamedQuery(eq("Post.findOne"), any())).thenReturn(query);

        when(query.getSingleResult()).thenReturn(null);

        // begin
        Post ret = forumService.getPostByID(PID_NOTEXIST);

        assertNull(ret);
    }

    @Test
    void getPostByID_validid() {
        // prepare
        when(em.createNamedQuery(eq("Post.findOne"), any())).thenReturn(query);

        when(query.getSingleResult()).thenReturn(post);

        // begin
        Post ret = forumService.getPostByID(PID);

        assertNotNull(ret);
        assertEquals(PID, ret.getPostid());
        comparePosts(ret, post);
    }

    @Test
    void createComment() {
    }

}