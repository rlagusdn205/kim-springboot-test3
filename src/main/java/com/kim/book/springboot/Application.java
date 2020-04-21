package com.kim.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정해준다.
//SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야 한다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS(Web Application Sever)를 실행한다.
        // 내장 WAS는 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는것을 말한다.
        // 내장 WAS는 언제 어디서나 같은 환경에서 스프링 부트를 배포 할 수 있다.
    }
}
