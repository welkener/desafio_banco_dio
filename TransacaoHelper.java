
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TransacaoHelper implements Operacoes {

	@Override
	public void sacar(Conta conta, double valor) {
		if(ValidacaoHelper.isPossivelRealizarOperacaoBancaria(conta, valor)) {
			double novoSaldo = conta.getSaldo() - valor;
			conta.setSaldo(novoSaldo);
			
			System.out.println("Saque realizado no valor de: R$ " + valor);
		}
	}

	@Override
	public void depositar(Conta conta, double valor) {
		if(ValidacaoHelper.isPossivelRealizarDeposito(valor)) {
			double novoSaldo = conta.getSaldo() + valor;
			conta.setSaldo(novoSaldo);
			
			System.out.println("Deposito realizado no valor de: R$ " + valor);
		}
	}

	@Override
	public void transferir(Conta suaConta, Conta contaDestino, double valor) {
		if(ValidacaoHelper.isPossivelRealizarOperacaoBancaria(suaConta, valor)) {
			sacar(suaConta, valor);
			depositar(contaDestino, valor);
			
			System.out.println("Transferencia para " + contaDestino.getPessoa().getNome() + " o total de: R$ " + suaConta.getSaldo());
			System.out.println("Saldo é: R$ " + suaConta.getSaldo());
		}
	}
	

	@Override
	public void exibirDadosBancarios(Conta conta) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		System.out.println("Nome: " + conta.getPessoa().getNome());
		System.out.println("CPF: " + conta.getPessoa().getCpf());
		System.out.println("Gênero: " + Genero.getNomeGenero(conta.getPessoa().getGenero().getGenero()));
		System.out.println("Data de Nascimento: " + simpleDateFormat.format(conta.getPessoa().getDataNascimento()));
		System.out.println("Banco: " + conta.getNome());
		System.out.println("Agência: " + conta.getCodigo());
		System.out.println("Nº da Conta: " + conta.getNumero());
	}

}
