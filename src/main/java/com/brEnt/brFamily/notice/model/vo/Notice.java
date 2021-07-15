package com.brEnt.brFamily.notice.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import oracle.sql.CLOB;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {
	
	private int noticeNo;
	private String title;
	private CLOB content;
	private String enrolldate;
	private String changedate;
	private int count;
	private String status;

}
