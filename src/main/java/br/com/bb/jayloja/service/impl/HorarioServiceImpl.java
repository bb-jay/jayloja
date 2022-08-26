package br.com.bb.jayloja.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import br.com.bb.jayloja.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
	public String getHorario() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime agora = LocalDateTime.now();
		return agora.format(formato);
	}
}
