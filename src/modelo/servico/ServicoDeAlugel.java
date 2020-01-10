package modelo.servico;

import modelo.entidades.AlugelDeCarro;
import modelo.entidades.NotaDeServico;

public class ServicoDeAlugel {

	private Double precoPorDia;
	private Double precoPorHora;
	
	private TaxaDeServico taxaDeServico;

	public ServicoDeAlugel(Double precoPorDia, Double precoPorHora, TaxaDeServico taxaDeServico) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaDeServico = taxaDeServico;
	}
	
	public void procesoDeNota(AlugelDeCarro alugelDeCarro) {
		long t1 = alugelDeCarro.getInicio().getTime(); //Pegaa a hora em milesegundos
		long t2 = alugelDeCarro.getFim().getTime();
		double horas = (double)(t2-t1)/1000 / 60 / 60; // /1000 - segundos /60 - minutos /60 - Horas
		
		double valorBasico;
		if (horas <= 12.0) {
			valorBasico = Math.ceil(horas) * precoPorHora;
		}
		else {
			valorBasico = Math.ceil(horas/24) * precoPorDia;
		}
	
		double taxa = taxaDeServico.taxa(valorBasico);
		
		alugelDeCarro.setNotaDeServiço(new NotaDeServico(valorBasico, taxa));
		
	}
}
