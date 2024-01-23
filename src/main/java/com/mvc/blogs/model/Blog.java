package com.mvc.blogs.model;

import jakarta.persistence.*;
import java.time.LocalTime;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String createAt;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Tittle tittle;

    public Blog() {
    }

    public Blog(Long id, String name, Status status, Tittle tittle) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.tittle = tittle;
    }
    @PrePersist
    public void prePersist() {
        this.createAt = LocalTime.now().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tittle getTittle() {
        return tittle;
    }

    public void setTittle(Tittle tittle) {
        this.tittle = tittle;
    }
}
