package com.kim.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트를 진행 할때 Junit 에 내장된 실행자 외에 다른 실행자를 실행시킨다.
                             // SpringRunner 라는 스프링 실행자를 사용한다. 스프링 부트테스트와 JUnit 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class) //웹에 집중 할 수 있는 어노테이션이다. @Controller,@ControllerAdvice등을 사용 할 수 있게 한다.
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 빈(bean)을 주입 받는다.
    private MockMvc mvc; // 웹 API 테스트 할 때 사용 한다. 스프링 MVC 테스트의 시작이다. HTTP GET, POST 등에 대한 API테스트를 할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET을 요청한다.
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증한다. HTTP Header의 status를 검증한다. 200 404 500 등의 상태를 점검한다.
                .andExpect(content().string(hello)); // mvc.perform의 결과를 검증한다.응답 본문의 내용을 검증한다.

    }

    @Test
    public void helloDto가_리턴되다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))) // param 은 String 형태의 값만 허용된다.
                .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name", is(name))) // jsonPath : 응답값을 필드별로 검증할 수 있는 메소드이다.($를 기준으로 필드명을 명시한다.)
                        .andExpect(jsonPath("$.amount", is(amount)));

    }

}

