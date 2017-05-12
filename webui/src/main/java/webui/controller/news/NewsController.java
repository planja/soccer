package webui.controller.news;

import domain.entity.news.News;
import infrastructure.service.news.INewsService;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webui.viewmodel.news.NewsViewModel;

import java.security.Principal;

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

    @RequestMapping(value = "/newscreator", method = RequestMethod.GET)
    public String newsCreator() {
        return "news/newscreator";
    }


    @RequestMapping(value = "/savenews", method = RequestMethod.POST)
    public
    @ResponseBody
    Long saveNews(@RequestBody NewsViewModel newsViewModel, Principal principal) {
        News news = newsService.createNews(newsViewModel.toNews(), userService.findByLogin(principal.getName()));
        return news.getId();
    }

    @RequestMapping(value = "/readnews/{id}", method = RequestMethod.GET)
    public ModelAndView loadNews(@PathVariable Long id) {
        return new ModelAndView("/news/readnews", "news", new NewsViewModel(newsService.findNews(id)));
    }


}
