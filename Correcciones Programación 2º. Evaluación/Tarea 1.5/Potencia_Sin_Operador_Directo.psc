Algoritmo Potencia_Sin_Operador_Directo
	Definir primerNumero, segundoNumero, potencia Como Entero;
    Escribir "Ingrese el valor del primer número: ";
    Leer primerNumero;
    Escribir "Ingrese el valor del segundo número: ";
    Leer segundoNumero;
    potencia <- 1;
    Para i <- 1 Hasta segundoNumero
        potencia <- potencia * primerNumero;
    Fin Para
    Escribir "El resultado de ", primerNumero, " elevado a ", segundoNumero, " es ", potencia;
FinAlgoritmo