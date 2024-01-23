package com.mvc.blogs.controller;

import com.mvc.blogs.model.Blog;
import com.mvc.blogs.repository.BlogRepository;
import com.mvc.blogs.repository.TittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/blogs")
public class BlogApi {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    TittleRepository tittleRepository;
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(blogRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Blog blog){
        return new ResponseEntity<>(blogRepository.save(blog),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Blog blog,@PathVariable Long id){
        blog.setId(id);
        return new ResponseEntity<>(blogRepository.save(blog),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        blogRepository.deleteById(id);
        return new ResponseEntity<>("Delete Done",HttpStatus.OK);
    }
    @GetMapping("search/{name}")
    public ResponseEntity search(@PathVariable String name){
        return new ResponseEntity<>(blogRepository.findAllByTittle_NameAndNameContaining(name),HttpStatus.OK);
    }
    @GetMapping("status")
    public ResponseEntity search(){
        return new ResponseEntity<>(blogRepository.searchStatus(),HttpStatus.OK);
    }
    @GetMapping("public")
    public ResponseEntity searchPublic(){
        return new ResponseEntity<>(blogRepository.searchPublic(),HttpStatus.OK);
    }
    @GetMapping("sort")
    public ResponseEntity sortCreateTime(){
        return new ResponseEntity<>(blogRepository.findAllByOrderByCreateAtDesc(),HttpStatus.OK);
    }
}
