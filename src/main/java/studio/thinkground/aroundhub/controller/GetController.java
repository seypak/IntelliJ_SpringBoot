package studio.thinkground.aroundhub.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {

    /**
     * GetMapping 테스트 코드 예제
     * @return String
     */

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
    //http://localhost:8080/api/v1/get-api/variable1/IntelliJ-SpringBoot
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    //http://localhost:8080/api/v1/get-api/variable2/IntelliJ-SpringBoot2
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=seyoungPark&email=seypak77@gmail.com&organization=seypark
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?name=seyoungPark&email=seypak77@gmail.com&organization=seypark
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, Object> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=seyoungPark&email=seypak77@gmail.com&organization=seypark
    @GetMapping(value = "/request3")
    public String getRequestParam3(@ModelAttribute MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
