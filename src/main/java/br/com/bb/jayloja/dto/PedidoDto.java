package br.com.bb.jayloja.dto;

import java.time.LocalDateTime;

import br.com.bb.jayloja.models.Cliente;
import br.com.bb.jayloja.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoDto {
	private long id;
	private Cliente cliente;
	private Produto produto;
	private LocalDateTime data;
	private long desconto;
	private boolean cancelado;
}
