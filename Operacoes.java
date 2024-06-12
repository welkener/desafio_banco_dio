
import java.text.ParseException;




public interface Operacoes {
	
	public void sacar(Conta conta, double valor);
	

	public void depositar(Conta conta, double valor);
	
	public void transferir(Conta suaConta, Conta contaDestino, double valor);
	
	public void exibirDadosBancarios(Conta conta);
}
