package com.ReMoVie.infra.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="review")
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "movieId", nullable = false)
	private Long movieId;
	@Column(name = "point", nullable = false)
	private double point;
	@Column(name = "review", nullable = false)
	private String review;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
}
