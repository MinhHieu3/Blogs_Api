package com.mvc.blogs.repository;

import com.mvc.blogs.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query("SELECT b FROM Blog b WHERE b.tittle.name LIKE %:name% OR b.name LIKE %:name%")
    List<Blog>findAllByTittle_NameAndNameContaining(String name);
    @Query("SELECT b FROM Blog b WHERE b.status LIKE 'Public' OR b.status LIKE 'OnlyMe'")
    List<Blog>searchStatus();
    @Query("SELECT b FROM Blog b WHERE b.status LIKE 'Public'")
    List<Blog>searchPublic();
    List<Blog>findAllByOrderByCreateAtDesc();
}
