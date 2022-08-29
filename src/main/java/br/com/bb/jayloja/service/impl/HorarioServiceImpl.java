package br.com.bb.jayloja.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {

	Logger log = LoggerFactory.getLogger(HorarioServiceImpl.class);

	public String getHorario() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime agora = LocalDateTime.now();
		log.trace("PEDIRAM A HORA!! TÁ NA MÃO: " + agora);
		return agora.format(formato);
	}
}
