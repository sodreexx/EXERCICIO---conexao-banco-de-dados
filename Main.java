import java.sql.ResultSet;
import java.util.Scanner;

import Data.DbContext;
import Models.Conta.ContaCorrente;
import Models.Conta.ContaPoupanca;
import Models.Pessoa;

public class Main {

	public static void main(String[] args) {

		inicio();
	}

	// MÉTODO PRINCIPAL
	public static void inicio() {
		System.out.println("---- Seja bem-vindo(a) ao nosso banco! ----\n");

		System.out.println("Selecione uma  do nosso menu: \n");
		System.out.println("1 - Abrir conta");
		System.out.println("2 - Consultar saldo");
		System.out.println("3 - Depositar");
		System.out.println("4 - Sacar");

		System.out.print("\n OPÇÃO: ");

		Scanner scanner = new Scanner(System.in);

		if (scanner.hasNextInt()) {
			int opcaoSelecionada = scanner.nextInt();

			if (opcaoSelecionada >= 1 && opcaoSelecionada <= 4) {
				executaOpcao(opcaoSelecionada);
			} else {
				mensagemStatus("Opção Inválida.");
			}

			inicio();
		} else {
			mensagemStatus("Opção Inválida.");
		}

		scanner.nextLine();

		inicio();

}	// class inicio()

	// MÉTODO QUE VAI CHAMAR A EXECUÇÃO DAS OPERAÇÕES DE ACORDO COM A OPÇÃO SELECIONADA  

	public static void executaOpcao(int opcaoSelecionada) {
		switch (opcaoSelecionada) {
			case 1:
				abrirConta();
				break;
			case 2:
				consultarSaldo();
				break;
			case 3:
				depositar();
				break;
			case 4:
				sacar();
				break;
			default:
				break;
		}
	}

	public static void abrirConta() {
	System.out.println("\n Informe o seu nome: ");
	Scanner scanner = new Scanner(System.in);

	if (scanner.hasNext()) {
		String nomeCliente = scanner.nextLine();
		// aqui abri a conta e salva no banco de dados
		DbContext database = new DbContext();

			try {
				database.conectarBanco();

				boolean statusQuery = database
						.executarUpdateSql("INSERT INTO public.clientes(nome) VALUES ('" + nomeCliente + "')");

				if (statusQuery) {
					 mensagemStatus("Conta aberta com sucesso para o cliente " + nomeCliente);
				}

				database.desconectarBanco();

			} catch (Exception e) {
			}
	}

	inicio();
}

	public static void consultarSaldo() {
		System.out.println("\n Informe o número da conta: ");
		Scanner scanner = new Scanner(System.in);

		if (scanner.hasNextInt()) {
			int numeroConta = scanner.nextInt();
		// consultar o saldo da conta no banco de dados
		DbContext database = new DbContext();

			try {
				database.conectarBanco();

				boolean statusQuery = database
						.executarUpdateSql("INSERT INTO public.clientes(nome) VALUES ('" + ? + ? "')");

				if (statusQuery) {
					mensagemStatus("Saldo da conta " + numeroConta + ": R$ " + saldo);
				}

				database.desconectarBanco();

			} catch (Exception e) {
			}
	}

	inicio();
}


	public static void depositar() {
		System.out.println("\n Informe o número da conta: ");
		Scanner scanner = new Scanner(System.in);

		if (scanner.hasNextInt()) {
			int numeroConta = scanner.nextInt();
			System.out.println("\n Informe o valor a ser depositado: ");
		
			if (scanner.hasNextDouble()) {
			double valorDeposito = scanner.nextDouble();
			// realizar o depósito na conta no banco de dados
			DbContext database = new DbContext();

			try {
				database.conectarBanco();

				boolean statusQuery = database.executarUpdateSql("DELETE FROM public.clientes WHERE id = " + depositar;);

				if (statusQuery) {
				mensagemStatus("Depósito de R$ " + valorDeposito + " realizado na conta " + numeroConta);
				}

				database.desconectarBanco();

			} catch (Exception e) {
			}
		}
	}

	inicio();
}

	public static void sacar() {
		System.out.println("\n Informe o número da conta: ");
		Scanner scanner = new Scanner(System.in);

		if (scanner.hasNextInt()) {
			int numeroConta = scanner.nextInt();
			System.out.println("\n Informe o valor a ser sacado: ");
		
			if (scanner.hasNextDouble()) {
			double valorSaque = scanner.nextDouble();
			// fazer o saque na conta no banco de dados
			DbContext database = new DbContext();

				try {
					database.conectarBanco();

					boolean statusQuery = database.executarUpdateSql(
							"UPDATE public.clientes SET nome = '" + novoSaque + "' WHERE id = " + sacar);

					if (statusQuery) {
						mensagemStatus("Saque de R$ " + valorSaque + " realizado na conta " + numeroConta);
					}

					database.desconectarBanco();

				} catch (Exception e) {
				}
		}

	}
	inicio();
}

	// MÉTODO RESPONSÁVEL POR EXIBIR UMA MENSAGEM NA TELA
	public static void mensagemStatus(String mensagem) {
		System.out.print("\n");
		System.out.print("---------------------");
		System.out.print("\n " + mensagem + " \n");
		System.out.print("---------------------");
		System.out.print("\n");
}

} // fim da class Main