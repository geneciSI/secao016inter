package aplicationsecao016InterfacesJava23;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entitiessecao016InterfacesJava23.CarRental;
import model.entitiessecao016InterfacesJava23.Vehicle;
import modelsecao016InterfacesJava23.services.BrazilTaxService;
import modelsecao016InterfacesJava23.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Enbtre com os dados do aluguel:");
		System.out.print("Modelo do carro:");
		String carModel = sc.nextLine();
		System.out.print("Retirado do veículo (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Devolvido para (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		System.out.println("Fatura: ");
		System.out.println("Pagamento básco: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f",cr.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));
		sc.close();
	}
}
