package com.sample.biblio.model.core;

import com.sample.frame.core.entity.GenericEntity;

public class BiblioBaseEntity extends GenericEntity{
	
	BiblioTicket ticket ;

	public BiblioTicket getTicket() {
		return ticket;
	}

	public void setTicket(BiblioTicket ticket) {
		this.ticket = ticket;
	}

}
