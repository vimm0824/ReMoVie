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
@Table(name="certify")
public class CertifyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "code", nullable = false)
	private String code;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
}
