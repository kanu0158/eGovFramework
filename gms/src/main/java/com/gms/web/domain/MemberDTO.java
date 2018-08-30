package com.gms.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Lazy
@Data
public class MemberDTO {
	private String userId,
	ssn, 
	name,
	gender,
	age,
	roll, 
	teamId,
	password,
	subject;
}
