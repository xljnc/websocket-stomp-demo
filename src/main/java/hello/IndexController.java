package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 埼玉
 * @Date: 2019/2/12 21:53
 * @Description:
 */
@Controller
@RequestMapping("/hello")
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}

