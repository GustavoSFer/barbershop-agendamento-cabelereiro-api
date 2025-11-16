package com.fernandes.barbershop_agendamento_cabelereiro_api.exception.AgendaException;

public class AgendaNotFoundException extends RuntimeException {

    public AgendaNotFoundException(String msg) {
        super(msg);
    }
}
