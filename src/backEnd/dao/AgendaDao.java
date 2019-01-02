package backEnd.dao;

import backEnd.models.Agenda;

public interface AgendaDao extends Mapper<Agenda> {
	public Agenda selectByEvent(String event);
	
}

