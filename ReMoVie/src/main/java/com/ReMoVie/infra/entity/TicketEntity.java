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
@Table(name="ticket")
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "movieId", nullable = false)
	private Long movieId;
	@Column(name = "plan", nullable = false)
	private Date plan;
	@Column(name = "seat", nullable = false)
	private String seat;
	@Column(name = "gift", nullable = false)
	private boolean gift;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
}
