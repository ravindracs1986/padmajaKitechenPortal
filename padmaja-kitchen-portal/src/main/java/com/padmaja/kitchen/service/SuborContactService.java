package com.padmaja.kitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.padmaja.kitchen.core.GenericRepository;
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.entity.SubsorContacts;
import com.padmaja.kitchen.persist.repo.BlogDetailsRepo;
import com.padmaja.kitchen.persist.repo.SuborContactRepo;



@Service("suborContactService")
@Scope("prototype")
@Qualifier("suborContactService")
@Transactional
public class SuborContactService extends com.padmaja.kitchen.core.AbstractService<SubsorContacts,Integer>{

	
	@Autowired SuborContactRepo suborContactRepo;
	@Override
	public GenericRepository<SubsorContacts> primaryDao() {
		return suborContactRepo;
	}
	
	

}
