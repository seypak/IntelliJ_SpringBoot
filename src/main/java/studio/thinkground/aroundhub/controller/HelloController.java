package studio.thinkground.aroundhub.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class HelloController {

    //http://localhost:8080/api/v1/get-api/hello
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello world";
    }

    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    //@pathVariable 변수값과 url 형식의 {변수값} 이 동일해야함.
    //http://localhost:8080/api/v1/get-api/variable1/variable1test
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    //http://localhost:8080/api/v1/get-api/variable2/variable2test
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=flature&email=seypak77@gmail.com&organization=seypark
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, Object> param) {
        StringBuilder sb = new StringBuilder();
        return null;
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(@RequestParam MemberDTO memberDTO) {
        return null;
    }
}
