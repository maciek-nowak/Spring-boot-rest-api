package com.codecool.krk.gamesapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiController {

    @GetMapping("")
    public String getDocumentation() {
        String link = "{\"api documentation\": \"https://github.com/CodecoolKRK20171/spring-boot-project-mcnowak-codecool\"}";
        return link;
    }
}
