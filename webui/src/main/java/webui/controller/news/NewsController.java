package webui.controller.news;

import domain.entity.news.Blog;
import infrastructure.service.news.INewsService;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webui.viewmodel.news.BlogViewModel;

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
    public @ResponseBody
    BlogViewModel loadBlog(@PathVariable Long id) {
        return new BlogViewModel(newsService.findBlog(id));
    }


    @RequestMapping(value = "/latestblog", method = RequestMethod.GET)
    public @ResponseBody
    List<BlogViewModel> latestBlog() {
        return newsService.findLatestBlog().stream().map(BlogViewModel::new).collect(Collectors.toList());
    }


}
