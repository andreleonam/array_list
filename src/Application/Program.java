package Application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import Entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		// cadastrar contas

		System.out.println("How many employees will be registered?");
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde; i++) {
			System.out.println();
			System.out.println("Emplyoee #" + i + ":");

			System.out.print("id: ");
			int cod = sc.nextInt();
			while (buscaId(list, cod)) {
				System.out.println("Id ja existe. tente novamente: ");
				cod = sc.nextInt();
			}

			System.out.print("nome: ");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.print("salario: ");
			double valor = sc.nextDouble();
			list.add(new Funcionario(cod, nome, valor));
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase : ");
		int id = sc.nextInt();

		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (func == null) {
			System.out.println("funcionario nao existe");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			func.aumentarSalario(percent);
		}

		
		System.out.println();
		System.out.println("List of employees:");
		for (Funcionario x : list) {
			System.out.println(x.toString());
		
		sc.close();

		}


	}

	public static boolean buscaId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}

}
