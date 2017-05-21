package webui.controller.news;

import domain.entity.news.Blog;
import domain.entity.news.News;
import infrastructure.service.news.INewsService;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webui.viewmodel.news.BlogViewModel;
import webui.viewmodel.news.CommentaryViewModel;
import webui.viewmodel.news.NewsViewModel;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ShchykalauM on 12.05.2017.
 */

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    private final INewsService newsService;
    private final IUserService userService;

    @Autowired
    public NewsController(INewsService newsService, IUserService userService) {
        this.newsService = newsService;
        this.userService = userService;
    }

    @RequestMapping(value = "/createblog", method = RequestMethod.GET)
    public String createBlog() {
        return "news/createblog";
    }


    @RequestMapping(value = "/saveblog", method = RequestMethod.POST)
    public
    @ResponseBody
    Long saveBlog(@RequestBody BlogViewModel blogViewModel, Principal principal) {
        Blog blog = newsService.createBlog(blogViewModel.toNews(), userService.findByLogin(principal.getName()));
        return blog.getId();
    }

    @RequestMapping(value = "/readblog/{id}", method = RequestMethod.GET)
    public ModelAndView readBlog(@PathVariable Long id) {
        Blog blog = newsService.findBlog(id);
        if (blog != null)
            return new ModelAndView("/news/readblog", "blogId", id);
        else return new ModelAndView("/common/notfound");
    }

    @RequestMapping(value = "/loadblog/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    BlogViewModel loadBlog(@PathVariable Long id) {
        return new BlogViewModel(newsService.findBlog(id));
    }


    @RequestMapping(value = "/latestblog", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BlogViewModel> latestBlog() {
        return newsService.findLatestBlog().stream().map(BlogViewModel::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/readmoreblogs/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BlogViewModel> readMoreBlogs(@PathVariable Long id) {
        return newsService.findBlogForReadMore(id).stream().map(BlogViewModel::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/allblogs", method = RequestMethod.GET)
    public String allBlogs() {
        return "news/allblogs";
    }

    @RequestMapping(value = "/findallblogs", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BlogViewModel> findAllBlogs() {
        return newsService.findAllBlogs().stream().map(BlogViewModel::new).collect(Collectors.toList());
    }

    /*****************Статьи************************/
    @RequestMapping(value = "/createnews", method = RequestMethod.GET)
    public String createNews() {
        return "news/createnews";
    }


    @RequestMapping(value = "/savenews", method = RequestMethod.POST)
    public
    @ResponseBody
    Long saveNews(@RequestBody NewsViewModel newsViewModel, Principal principal) {
        News news = newsService.createNews(newsViewModel.toNews(), userService.findByLogin(principal.getName()));
        return news.getId();
    }

    @RequestMapping(value = "/readnews/{id}", method = RequestMethod.GET)
    public ModelAndView readNews(@PathVariable Long id) {
        News news = newsService.findNews(id);
        if (news != null)
            return new ModelAndView("/news/readnews", "newsId", id);
        else return new ModelAndView("/common/notfound");
    }

    @RequestMapping(value = "/loadnews/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    NewsViewModel loadNews(@PathVariable Long id) {
        return new NewsViewModel(newsService.findNews(id));
    }

    @RequestMapping(value = "/latestnews", method = RequestMethod.GET)
    public
    @ResponseBody
    List<NewsViewModel> latestNews() {
        return newsService.findLatestNews().stream().map(NewsViewModel::new).collect(Collectors.toList());
    }


    @RequestMapping(value = "/allnews", method = RequestMethod.GET)
    public String allNews() {
        return "news/allnews";
    }


    @RequestMapping(value = "/findallnews", method = RequestMethod.GET)
    public
    @ResponseBody
    List<NewsViewModel> findAllNews() {
        return newsService.findAllNews().stream().map(NewsViewModel::new).collect(Collectors.toList());
    }


    /***************************************Comments***********************/

    @RequestMapping(value = "/deletenewscommentary/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteNewsCommentary(@PathVariable Long id) {
        newsService.deleteNewsCommentary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/savenewscomment", method = RequestMethod.POST)
    public
    @ResponseBody
    CommentaryViewModel saveNewsComment(@RequestBody CommentaryViewModel commentaryViewModel, Principal principal) {
        return new CommentaryViewModel(newsService.addNewsComment(commentaryViewModel.toNewsCommentary()
                , userService.findByLogin(principal.getName()), newsService.findNews(commentaryViewModel.getNewsId())));

    }


    @RequestMapping(value = "/deleteblogcommentary/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteBlogCommentary(@PathVariable Long id) {
        newsService.deleteBlogCommentary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/saveblogcomment", method = RequestMethod.POST)
    public
    @ResponseBody
    CommentaryViewModel saveBlogComment(@RequestBody CommentaryViewModel commentaryViewModel, Principal principal) {
        return new CommentaryViewModel(newsService.addBlogComment(commentaryViewModel.toBlogCommentary()
                , userService.findByLogin(principal.getName()), newsService.findBlog(commentaryViewModel.getNewsId())));

    }


}
