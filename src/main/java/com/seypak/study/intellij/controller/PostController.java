package com.seypak.study.intellij.controller;

import org.springframework.web.bind.annotation.*;
import com.seypak.study.intellij.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World";
    }

    //http://localhost:8080/api/v1/post-api/member

    /**
     * {
     *   "name" : "seyoungPark"
     *   ,"email" : "seypak77@gmail.com"
     *   ,"organization" : "seypark"
     * }
     */
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/post-api/member2

    /**
     * {
     *   "name" : "seyoungPark"
     *   ,"email" : "seypak77@gmail.com"
     *   ,"organization" : "seypark"
     * }
     */
    @PostMapping(value = "/member2")
    public String postMember2(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
