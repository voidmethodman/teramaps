package jp.or.shunjuen.teramaps;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class SampleController {

    @RequestMapping(value = "/sample",method = RequestMethod.POST)
    public String test(Model model,@RequestParam("message") String message) throws RuntimeException, IOException {
    	Logger logger = Logger.getLogger(SampleController.class.getName());
        logger.setLevel(Level.INFO);

        // ハンドラーを作成してロガーに登録
        Handler handler = new FileHandler("C:\\Users\\kots\\Desktop\\latlng.log");
        logger.addHandler(handler);

        // フォーマッターを作成してハンドラーに登録
        Formatter formatter =  new SimpleFormatter();
        handler.setFormatter(formatter);

        // INFOメッセージを出力
        logger.log(Level.INFO, message);
        return "sample/index";
    }

}