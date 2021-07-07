package com.brEnt.brFamily.mail.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReceiveMail {
	private int mailNo;
	private String mailWriter;
	private String mailRecevier;
	private String recycleBinStatus;
	private String receiveStatus;
	private String bookmark;
	
	private String mailTitle;
	private String mailSendDate;
	
	private int mailFNo;
	private String mailFSize;
	
	// mfIsHave = 0 : 첨부파일 없음
	// mfIsHave > 0 : 첨부파일 있음
	private String mfIsHave;
}
