Algoritmo Positivos_Y_Negativos
	Definir numPositivo, numNegativo, numero Como Entero;
    numPositivo <- 0;
    numNegativo <- 0;
    Para i <- 1 Hasta 100
        Escribir "Introduzca el número ", i, ", por favor: ";
        Leer numero;
        Mientras numero = 0
            Escribir "ERROR. El número introducido NO puede ser 0.";
            Escribir "Introduzca el número ", i, " nuevamente: ";
            Leer numero;
        Fin Mientras
        Si numero > 0
            numPositivo <- numPositivo + 1;
        Sino
            numNegativo <- numNegativo + 1;
        Fin Si
    Fin Para
    Escribir "Se han introducido por teclado ", numPositivo, " números positivos.";
    Escribir "Se han introducido por teclado ", numNegativo, " números negativos.";
FinAlgoritmo