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
@Table(name="gift")
public class GiftEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "ticketId", nullable = false)
	private Long ticketId;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
}
