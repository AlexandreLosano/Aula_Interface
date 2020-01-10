package modelo.entidades;

import java.util.Date;

public class AlugelDeCarro {

	private Date inicio;
	private Date fim;
	
	private Veiculo veiculo;
	private NotaDeServico notaDeServi�o;
	
	public AlugelDeCarro () {
	}

	public AlugelDeCarro(Date inicio, Date fim, Veiculo veiculo) {
		this.inicio = inicio;
		this.fim = fim;
		this.veiculo = veiculo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaDeServico getNotaDeServi�o() {
		return notaDeServi�o;
	}

	public void setNotaDeServi�o(NotaDeServico notaDeServi�o) {
		this.notaDeServi�o = notaDeServi�o;
	}
	
}
