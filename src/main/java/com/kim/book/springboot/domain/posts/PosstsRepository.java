package com.kim.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PosstsRepository extends JpaRepository<Posts, Long> {
}
