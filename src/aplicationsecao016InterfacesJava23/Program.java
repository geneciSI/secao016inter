package aplicationsecao016InterfacesJava23;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entitiessecao016InterfacesJava23.CarRental;
import model.entitiessecao016InterfacesJava23.Vehicle;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Enbtre com os dados do aluguel:");
		System.out.println("Modelo do carro:");
		String carModel = sc.nextLine();
		System.out.println("Retirado do veículo (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Devolvido para (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		
		
		
		sc.close();
	}

}
