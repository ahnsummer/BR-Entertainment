package com.brEnt.brFamily.mail.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brEnt.brFamily.mail.model.dao.MailDao;
import com.brEnt.brFamily.mail.model.vo.MailFile;
import com.brEnt.brFamily.mail.model.vo.ReceiveMail;
import com.brEnt.brFamily.mail.model.vo.SendMail;

@Service
public class MailServiceImpl implements MailService {
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MailDao mDao;

	@Override
	public ArrayList<ReceiveMail> receiveMailListView(String email) {
		
		return mDao.receiveMailListView(email, sqlSession);
	}

	@Override
	public ArrayList<SendMail> sendMailListView(String email) {
		
		return mDao.sendMailListView(email, sqlSession);
	}

	@Override
	public ArrayList<ReceiveMail> receiverList(String email) {
		return mDao.receiverList(email, sqlSession);
	}

	@Override
	public ArrayList<SendMail> TempboxListView(String email) {
		return mDao.TempboxListView(email, sqlSession);
	}

	@Override
	public ArrayList<SendMail> recycleBinList(String email) {
		return mDao.recycleBinList(email, sqlSession);
	}

	@Override
	public ArrayList<ReceiveMail> recycleBinRList(String email) {
		return mDao.recycleBinRList(email, sqlSession);
	}

	@Override
	public int insertSMail(SendMail s) {
		return mDao.insertSMail(s, sqlSession);
	}

	@Override
	public int insertRMail(ArrayList<ReceiveMail> rlist) {
		return mDao.insertRMail(rlist, sqlSession);
	}


	@Override
	public int insertMFMail(MailFile mf) {
		return mDao.insertMFMail(mf, sqlSession);
	}

	@Override
	public int tempSMail(SendMail s) {
		return mDao.tempSMail(s, sqlSession);
	}

	@Override
	public int tempRMail(ArrayList<ReceiveMail> rlist) {
		return mDao.tempRMail(rlist, sqlSession);
	}

	@Override
	public int tempMFMail(MailFile mf) {
		return mDao.tempMFMail(mf, sqlSession);
	}

	@Override
	public int deleteMail(Map<String, Object> map) {
		return mDao.deleteMail(map, sqlSession);
	}
	
	@Override
	public int readMail(ReceiveMail rmail) {
		return mDao.readMail(rmail, sqlSession);
	}

	@Override
	public ReceiveMail detailRMail(ReceiveMail rmail) {
		
		return mDao.detailRMail(rmail, sqlSession);
	}

	@Override
	public ArrayList<MailFile> detailMFMail(ReceiveMail rmail) {
		return mDao.detailMFMail(rmail, sqlSession);
	}

	@Override
	public int updateImpor(ReceiveMail r) {
		return mDao.updateImpor(r, sqlSession);
	}

	@Override
	public ArrayList<ReceiveMail> imporListView(ReceiveMail r) {
		return mDao.imporListView(r, sqlSession);
	}

	@Override
	public ReceiveMail reply(ReceiveMail r) {
		return mDao.reply(r, sqlSession);
	}

	@Override
	public ArrayList<MailFile> replyMF(ReceiveMail r) {
		return mDao.replyMF(r, sqlSession);
	}

	@Override
	public ReceiveMail forwardMail(ReceiveMail r) {
		return mDao.forwardMail(r, sqlSession);
	}

	@Override
	public ArrayList<MailFile> forwarMFMail(ReceiveMail r) {
		return mDao.forwarMFMail(r, sqlSession);
	}

	@Override
	public SendMail detailSMail(SendMail smail) {
		return mDao.detailSMail(smail, sqlSession);
	}

	@Override
	public ArrayList<MailFile> detailMFMail(SendMail smail) {
		return mDao.detailMFMail(smail, sqlSession);
	}

	@Override
	public SendMail forwardSMail(SendMail s) {
		return mDao.forwardSMail(s, sqlSession);
	}

	@Override
	public ArrayList<MailFile> forwarMFSMail(SendMail s) {
		return mDao.forwardMFSMail(s, sqlSession);
	}

	@Override
	public int deleteTMail(Map<String, Object> map) {
		return mDao.deleteTMail(map, sqlSession);
	}

	@Override
	public int ttDeleteMail(Map<String, Object> map) {
		return mDao.ttDeleteMail(map, sqlSession);
	}




}
