package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.CurrentAccount;
import conta_bancaria.model.SavingsAccount;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();
		
		
		int opcao,numero,agencia,tipo;
		String titular,dt_niver;
		float saldo,limite;

		CurrentAccount cC1 = new CurrentAccount(contas.gerarNumero(),33,1,"ateu",4000.0f,3000.0f);
		contas.cadastrar(cC1);
		
		SavingsAccount cS1 = new SavingsAccount(contas.gerarNumero(),33,2,"tadeu",4000.0f,"10/10/2000");
		contas.cadastrar(cS1);

		while (true) {

			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_BLACK_BACKGROUND_BRIGHT
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO COM B               ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLACK_BOLD + "\n Obrigado pela preferencia");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
					System.out.println("digite o numero da agencia");
					agencia=leia.nextInt();

					
					System.out.println("digite nome do titular");
					leia.skip("\\R");
					titular=leia.nextLine();
					
					System.out.println("digite o tipo");
					System.out.print("\n1	-	Current Account");
					System.out.print("\n2	-	Savings Account \n");
					tipo=leia.nextInt();
					
					System.out.println("digite o saldo da conta");
					saldo=leia.nextFloat();
					
					switch(tipo) {
					case 1:{
						System.out.println("digite o limite da conta");
						limite=leia.nextFloat();
						contas.cadastrar(new CurrentAccount(contas.gerarNumero(), agencia,tipo, titular, saldo, limite));
					}
					
					case 2:{
						System.out.println("digite o dia do aniversario da conta");
						leia.skip("\\R");
						dt_niver=leia.nextLine();
						contas.cadastrar(new SavingsAccount(contas.gerarNumero(), agencia, tipo, titular, saldo,  dt_niver));
					}
				}
			
		}
		}
	}
					//                    break;
//				case 2:
//					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
//
//					break;
//				case 3:
//					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
//
//					break;
//				case 4:
//					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
//
//					break;
//				case 5:
//					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
//
//					break;
//				case 6:
//					System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
//
//					break;
//				case 7:
//					System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
//
//					break;
//				case 8:
//					System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
//
//					break;
//				default:
//					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
//					break;
//			}
//		}
//
//	}
//
	public static void sobre() {
		System.out.println(Cores.TEXT_BLACK_BOLD);
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("pedro henrique santos bernardo");
		System.out.println("*********************************************************");
		System.out.println(Cores.TEXT_RESET);
	}
	}
