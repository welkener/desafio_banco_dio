

import java.util.List;


public class ValidacaoHelper {
	
	public static boolean isPossivelCadastrarConta(Conta conta) {
		if(!verificarDadosPessoa(conta)) {
			System.out.println("Conta não cadastrada!");
			return false;
		}
		
		return true;
	}
	
	public static boolean verificarDadosPessoa(Conta conta) {
		if(conta == null) {
			System.out.println("Conta não foi informada.");
			
			return false;
		}
		
		if(conta.getPessoa().getNome().isEmpty()) {
			System.out.println("Nome não informado.");
			
			return false;
		}
		
		if(conta.getPessoa().getCpf().isEmpty()) {
			System.out.println("CPF não informado.");
			
			return false;
		}
		
		if(conta.getPessoa().getGenero().isEmpty()) {
			System.out.println("Gênero não informado.");
			
			return false;
		}
		
		if(conta.getPessoa().getDataNascimento() == null) {
			System.out.println("Data de Nascimento não informado.");
			
			return false;
		}
		
		if(conta.getNumero().isEmpty()) {
			System.out.println("Nº da Conta não informada.");
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isPossivelRealizarOperacaoBancaria(Conta conta, double valor) {
		if(valor <= conta.getSaldo()) {
			return true;
		}else{
			System.out.println("Operação não realizada, verifique o valor!");
			
			return false;
		}
	}
	
	public static boolean isPossivelRealizarDeposito(double valor) {
		if(valor > 0) {
			return true;
		} else {
			System.out.println("Não foi possível depositar, verifique o valor informado!");
			
			return false;
		}
	}
	
	
	public static boolean isContaExistente(List<Conta> contas, String cpf) {
		if(!contas.isEmpty()) {
			for (Conta conta : contas) {
				if(conta.getPessoa().getCpf().equals(cpf)) {
					return true;
				}
			}
		}
		
		System.out.println("O CPF informado não tem conta vinculada!");
		
		return false;
	}
}
