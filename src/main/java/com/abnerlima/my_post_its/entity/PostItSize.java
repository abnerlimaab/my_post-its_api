package com.abnerlima.my_post_its.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postit_sizes")
public class PostItSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "char_length")
    private Integer charLength;

    public PostItSize() {
    }

    public PostItSize(String name, Integer charLength) {
        this.name = name;
        this.charLength = charLength;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCharLength() {
        return charLength;
    }

    public void setCharLength(Integer charLength) {
        this.charLength = charLength;
    }
}
