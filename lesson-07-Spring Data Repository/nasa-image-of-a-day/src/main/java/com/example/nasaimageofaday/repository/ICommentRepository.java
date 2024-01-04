package com.example.nasaimageofaday.repository;

import com.example.nasaimageofaday.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICommentRepository extends PagingAndSortingRepository<Comment,Integer>
{
}
