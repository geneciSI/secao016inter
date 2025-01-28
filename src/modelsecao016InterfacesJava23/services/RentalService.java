package modelsecao016InterfacesJava23.services;

import java.time.Duration;

import model.entitiessecao016InterfacesJava23.CarRental;
import model.entitiessecao016InterfacesJava23.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	
	//private BrazilTaxService taxService;
	
	private TaxService taxService;
	
	//public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
	}
/*	public Double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public Double getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHou(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public TaxService getTaxService() {
		return taxService;
	}
	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}*/
	public void processInvoice(CarRental carRental) {
/*		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours1 = (double) (t2-t1) /1000 /60 /60;*/
		
		double minutes = Duration.between(carRental.getStart() , carRental.getFinish()).toMinutes();
		double hours = minutes/60;
		double basicPayment;
		if (hours<=12) {
			basicPayment =pricePerHour *Math.ceil(hours);
		}
		else {
			basicPayment =pricePerDay *Math.ceil(hours/24.0);
		}
		double tax = taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment,tax));
	}
}
