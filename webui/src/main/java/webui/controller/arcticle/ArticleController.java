package webui.controller.arcticle;

import infrastructure.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webui.viewmodel.news.NewsViewModel;

/**
 * Created by ShchykalauM on 05.05.2017.
 */

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    private INewsService newsService;

    @Autowired
    public ArticleController(INewsService newsService) {
        this.newsService = newsService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String article() {
        return "article/article";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> saveBlog(@RequestBody NewsViewModel newsViewModel) {

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
