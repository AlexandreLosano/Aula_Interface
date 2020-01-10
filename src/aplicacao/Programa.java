package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.AlugelDeCarro;
import modelo.entidades.Veiculo;
import modelo.servico.ServicoDeAlugel;
import modelo.servico.TaxaBrasileiraDeServico;

public class Programa {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Detalhe o alugel");
		System.out.print("Modelo do Carro ");
		String modeloCarro = sc.nextLine();
		System.out.print("Retirada do veiculo (dd/MM/yyyy hh:ss): ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Entrega do veiculo (dd/MM/yyyy hh:ss): ");
		Date fim = sdf.parse(sc.nextLine());
		
		AlugelDeCarro ac = new AlugelDeCarro(inicio, fim, new Veiculo(modeloCarro));
		
		System.out.print("Valor por Hora ");
		double valorHora = sc.nextDouble();
		System.out.print("Valor por Dia ");
		double valorDia = sc.nextDouble();
		
		ServicoDeAlugel servicoDeAlugel = new ServicoDeAlugel(valorDia, valorHora, new TaxaBrasileiraDeServico());
		
		servicoDeAlugel.procesoDeNota(ac);
		
		System.out.println("NOTA:");
		System.out.println("Pagamento Básico: " + String.format("%.2f", ac.getNotaDeServiço().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f", ac.getNotaDeServiço().getTaxa()));
		System.out.println("Pagamento Total: " + String.format("%.2f", ac.getNotaDeServiço().getPagamentoTotal()));
		
		sc.close();
	}

}
