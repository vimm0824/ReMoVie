package com.ReMoVie.infra.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="follow")
public class FollowEntity {

	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "followerId", nullable = false)
	private Long followerId;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
}
