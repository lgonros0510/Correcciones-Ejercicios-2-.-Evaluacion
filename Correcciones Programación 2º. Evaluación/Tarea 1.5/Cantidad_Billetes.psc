Algoritmo Cantidad_Billetes
	Definir cantidadDinero, billete500, billete200, billete100, billete50, billete20, billete10, billete5 Como Entero;
	Escribir "Introduzca una cantidad de dinero a dividir en billetes (Debe ser mayor o igual a 5 y múltiplo de 5): ";
	Leer cantidadDinero;
	Si cantidadDinero < 5 O cantidadDinero MOD 5 <> 0 Entonces
		Escribir "La cantidad de euros debe ser un múltiplo de 5 y mayor o igual a 5.";
	Sino
		billete500 <- cantidadDinero / 500;
		cantidadDinero <- cantidadDinero % 500;
		billete200 <- cantidadDinero / 200;
		cantidadDinero <- cantidadDinero % 200;
		billete100 <- cantidadDinero / 100;
		cantidadDinero <- cantidadDinero % 100;
		billete50 <- cantidadDinero / 50;
		cantidadDinero <- cantidadDinero % 50;
		billete20 <- cantidadDinero / 20;
		cantidadDinero <- cantidadDinero % 20;
		billete10 <- cantidadDinero / 10;
		cantidadDinero <- cantidadDinero % 10;
		billete5 <- cantidadDinero / 5;
		Escribir "Para dicha cantidad introducida, se necesitan los siguientes billetes:";
		Si billete500 > 0 Entonces
			Escribir billete500, " billete(s) de 500 euros.";
		Fin Si
		Si billete200 > 0 Entonces
			Escribir billete200, " billete(s) de 200 euros.";
		Fin Si
		Si billete100 > 0 Entonces
			Escribir billete100, " billete(s) de 100 euros.";
		Fin Si
		Si billete50 > 0 Entonces
			Escribir billete50, " billete(s) de 50 euros.";
		Fin Si
		Si billete20 > 0 Entonces
			Escribir billete20, " billete(s) de 20 euros.";
		Fin Si
		Si billete10 > 0 Entonces
			Escribir billete10, " billete(s) de 10 euros.";
		Fin Si
		Si billete5 > 0 Entonces
			Escribir billete5, " billete(s) de 5 euros.";
		Fin Si
	Fin Si
FinAlgoritmo