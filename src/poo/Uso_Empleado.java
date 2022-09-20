package poo;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*Empleado empleado1=new Empleado("Bilal", 85000, 1990, 12, 17);
		
		Empleado empleado2=new Empleado("Ali", 22000, 1992, 12, 17);
		
		Empleado empleado3=new Empleado("Bill", 90000, 2002, 11, 15);
		
		empleado1.subeSueldo(5);
		
		empleado2.subeSueldo(5);
		
		empleado3.subeSueldo(5);
		
		
		System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo: " + empleado1.dameSueldo()
		+ " Fecha de alta: " + empleado1.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo: " + empleado2.dameSueldo()
		+ " Fecha de alta: " + empleado2.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo: " + empleado3.dameSueldo()
		+ " Fecha de alta: " + empleado3.dameFechaContrato());*/


		
		
		Jefatura jefe_RRHH=new Jefatura("Bilal ", 55000, 2022,9,13);
		
		jefe_RRHH.estableceIncentivo(2570);
		
		
		
		
		Empleado[] misEmpleados=new Empleado[6];
		
		 
		misEmpleados[0]=new Empleado("Bilal ", 85000, 1990, 12, 17);
		
		misEmpleados[1]=new Empleado("Ali ", 22000, 1992, 12, 17);
		
		misEmpleados[2]=new Empleado("Bill ", 90000, 2002, 11, 15);
		
		misEmpleados[3]=new Empleado("Marta ");
		
		misEmpleados[4]=jefe_RRHH; //Polimorfismo, Principio de sustitucion.
		
		misEmpleados[5]=new Jefatura("Maria ", 95000,1999,05,20);
		
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
		
		jefa_Finanzas.estableceIncentivo(5000);
		
		
		/*for(int i=0;i>3;i++) {
			
			misEmpleados[i].subeSueldo(5);
		}*/
		
		
		for(Empleado e: misEmpleados) {
			
			e.subeSueldo(5);
			
		}
		
		
		
		/*for(int i=0;i<3;i++) {
			
			System.out.println("Nombre: " + misEmpleados[i].dameNombre()
					+ "Sueldo: " +misEmpleados[i].dameSueldo()
					+ " Fecha de alta: " + misEmpleados[i].dameFechaContrato());
		}*/
		
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados) {
			
			System.out.println("Nombre: " + e.dameNombre()
					+ " Sueldo: " + e.dameSueldo()
					+ " Fecha de alta: " + e.dameFechaContrato());
			
		}
		


				

	}

}


class Empleado implements Comparable {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		
		nombre=nom;
		
		sueldo=sue;
		
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, dia);
		
		altaContrato=calendario.getTime();
		
		Id=IdSiguiente;
		
		IdSiguiente++;
		
	}
	
	public Empleado(String nom) {
		
		this(nom, 30000, 2000,01,01);
	}
	
	
	
	
	public String dameNombre() { //getter
		
		return nombre + "Id: " + Id;
	}
	
	public double dameSueldo() { //getter
		
		return sueldo;
	}
	
	public Date dameFechaContrato() {
		
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) { //setter
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}
	
	
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado=(Empleado) miObjeto;
		
		if(this.sueldo<otroEmpleado.sueldo) {
			
			return -1;
		}
		
		if(this.sueldo>otroEmpleado.sueldo) {
			
			return 1;
		}
		
		return 0;
	}
	
	
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private static int IdSiguiente;
	
	private int Id;
	
}


 class Jefatura extends Empleado{
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom, sue, agno, mes, dia);
	}
	
	public void estableceIncentivo(double b) {
		
		incentivo=b;
	}
	
	public double dameSueldo(){
		
		double sueldoJefe=super.dameSueldo();
		
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;
	
	
}


/*class Director extends Jefatura{
	
	public Director(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom, sue, agno, mes, dia);
	}
}*/




































