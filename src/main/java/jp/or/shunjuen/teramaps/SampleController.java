package jp.or.shunjuen.teramaps;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class SampleController {

    @RequestMapping(value = "/sample",method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("name", "草苅API");
        model.addAttribute("get", "GET /sample");
        model.addAttribute("post", "POST /sample");
        return "sample/index";
    }

}