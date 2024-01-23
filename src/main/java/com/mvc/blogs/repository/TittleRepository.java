package com.mvc.blogs.repository;

import com.mvc.blogs.model.Tittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TittleRepository extends JpaRepository<Tittle,Long> {
}
