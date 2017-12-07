package com.idw.templatewebapp.domain;

import javax.persistence.*;

import lombok.Data;
/*
 * @author avanderwoude 8/8/2017
 */
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String credential;
	public User(){}
	public User(Long id, String credential) {
		this.id = id;
		this.credential = credential;
	}
}