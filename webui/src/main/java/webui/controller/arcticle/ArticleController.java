package webui.controller.arcticle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ShchykalauM on 05.05.2017.
 */

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @RequestMapping(method = RequestMethod.GET)
    public String article() {
        return "article/article";
    }

}
