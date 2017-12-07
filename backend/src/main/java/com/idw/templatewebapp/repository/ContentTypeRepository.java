package com.idw.templatewebapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.idw.templatewebapp.domain.ContentType;
/*
 * @author avanderwoude 8/8/2017
 */
public interface ContentTypeRepository extends CrudRepository<ContentType, Long> {
	List<ContentType> findByShortName(@Param("shortname") String shortName);
}
