package com.rockie.stock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by froilan on 8/18/15.
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;

}
