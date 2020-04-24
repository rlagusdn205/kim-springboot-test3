package com.kim.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //@Getter와 @NoArgsConstructor는 롬복의 어노테이션이다. 롬복은 코드를 단순화 시켜주지만 필수 어노테이션은 아니다.
@NoArgsConstructor // 기본 생성자를 자동 추가한다. public Posts(){}와 같은 효과이다.
@Entity //JPA의 어노테이션이다. 주요 어노테이션이기 때문에 롬복의 어노테이션보다 클래스에 가깝게 쓴다. -> 위의 어노테이션을 쉽게 삭제할 수 있다.
// Entity는 기본값로 클래스의 카멜케이스 이름을 언더코어(_) 네이밍으로 테이블 이름을 매칭한다. ex) abc.java -> abc_java
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValuesms는 PK의 생성 규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    private String content;

    private String author;

    @Builder // 클래스 내 모든 필드의 Getter 메소드를 자동생성한다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
