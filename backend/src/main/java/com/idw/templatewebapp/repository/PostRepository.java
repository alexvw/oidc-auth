package com.idw.templatewebapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.idw.templatewebapp.domain.Post;
/*
 * @author avanderwoude 8/8/2017
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
