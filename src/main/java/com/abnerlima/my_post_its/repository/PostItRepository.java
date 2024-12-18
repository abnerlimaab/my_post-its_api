package com.abnerlima.my_post_its.repository;

import com.abnerlima.my_post_its.entity.PostIt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostItRepository extends CrudRepository<PostIt, Integer> {

    public List<PostIt> findByBoardId(Integer boardId);
}
