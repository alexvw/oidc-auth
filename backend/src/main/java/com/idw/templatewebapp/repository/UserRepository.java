package com.idw.templatewebapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.idw.templatewebapp.domain.User;
/*
 * @author avanderwoude 8/8/2017
 */
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByCredential(@Param("credential") String credential);
}
