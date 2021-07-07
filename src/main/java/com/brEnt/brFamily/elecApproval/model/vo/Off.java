package com.brEnt.brFamily.elecApproval.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Off {
	
	private int ecDocNo;
	private int memNo;
	private String ecDocName;
	private String ecWriter;
	private String ecTitle;
	private String ecCnt;
	private String ecCode;
	private String ecEnrolldate;
	private String ecUpdatedate;
	private String ecCompdate;
	private String ecCanceldate;
	private String ecStatus; 
	
	private String offStart;
	private String offEnd;
	private String offReason;

	private String deptName;
	private String posiName;
	
}
