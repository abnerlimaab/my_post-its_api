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

    @Column(name = "board_id")
    private Integer boardId;

    @Column(name = "color_id")
    private Integer colorId;

    @Column(name = "size_id")
    private Integer sizeId;

    public PostIt() {
    }

    public PostIt(String text, Integer boardId, Integer colorId, Integer sizeId) {
        this.text = text;
        this.boardId = boardId;
        this.colorId = colorId;
        this.sizeId = sizeId;
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

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }
}
