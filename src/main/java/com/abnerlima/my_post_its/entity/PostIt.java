package com.abnerlima.my_post_its.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postits")
public class PostIt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @JoinColumn(name = "board_id")
    private Integer boardId;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PostItColor color;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PostItSize size;

    public PostIt() {
    }

    public PostIt(String text, Integer boardId, PostItColor color, PostItSize size) {
        this.text = text;
        this.boardId = boardId;
        this.color = color;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public PostItColor getColor() {
        return color;
    }

    public void setColor(PostItColor color) {
        this.color = color;
    }

    public PostItSize getSize() {
        return size;
    }

    public void setSize(PostItSize size) {
        this.size = size;
    }
}
