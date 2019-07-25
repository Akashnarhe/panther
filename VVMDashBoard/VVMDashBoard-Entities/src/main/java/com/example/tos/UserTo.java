package com.example.tos;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class UserTo {
	
	private int userId;
	private String userName;
	
}
