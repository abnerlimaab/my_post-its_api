package com.abnerlima.my_post_its.repository;

import com.abnerlima.my_post_its.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
}
