package com.xxx.json;


import com.xxx.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("json")
@Controller
@ResponseBody
public class JsonController {

    @PostMapping("data")
    public String data(@RequestBody Person person) {
        System.out.println("person = " + person);   ;
    }
}
