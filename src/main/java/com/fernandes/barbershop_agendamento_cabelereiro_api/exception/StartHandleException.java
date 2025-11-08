package com.fernandes.barbershop_agendamento_cabelereiro_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartHandleException {

    private String error;
    private String msg;
    private HttpStatus status;
}
