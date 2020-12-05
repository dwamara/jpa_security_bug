package com.dwitech.security.jpa.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "credentials")
@UserDefinition
public class Credentials extends PanacheEntity {
	@Username @Column(name = "username") public String username;
	@Password @JsonbTransient @Column(name = "password") public String password;
	@Roles @Column(name = "role") public String role;

	public static void add(final String username, final String password, final String role) {
		Credentials credentials = new Credentials();
		credentials.username = username;
		credentials.password = BcryptUtil.bcryptHash(password);
		credentials.role = role;
		credentials.persist();
	}
}