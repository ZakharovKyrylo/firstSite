package com.example1.demo1.repo;

import org.springframework.data.repository.CrudRepository;
import com.example1.demo1.models.Post;
import javax.transaction.Transactional;


@Transactional
public interface PostRepository extends CrudRepository<Post, Long>{
}
