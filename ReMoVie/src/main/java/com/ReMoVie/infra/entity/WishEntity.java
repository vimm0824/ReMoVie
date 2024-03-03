package com.ReMoVie.infra.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="wish")
public class WishEntity {

	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "movieId", nullable = false)
	private Long movieId;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
}
