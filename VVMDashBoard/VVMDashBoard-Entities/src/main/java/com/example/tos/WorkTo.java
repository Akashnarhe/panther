package com.example.tos;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class WorkTo {
	
	private int workId;
	private String workName;
	
}
