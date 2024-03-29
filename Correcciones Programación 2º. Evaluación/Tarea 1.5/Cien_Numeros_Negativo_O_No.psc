Algoritmo Cien_Numeros_Negativo_O_No
	Definir contadorNegativos, numero Como Entero;
	contadorNegativos <- 0;
    Para i <- 1 Hasta 100
        Escribir "Introduzca el número ", i, ", por favor: ";
        Leer numero;
        Mientras numero = 0
            Escribir "ERROR. El número introducido NO puede ser 0.";
            Escribir "Introduzca el número ", i, " nuevamente: ";
            Leer numero;
        Fin Mientras
        Si numero < 0
            contadorNegativos <- contadorNegativos + 1;
        Fin Si
    Fin Para
    Si contadorNegativos > 0
        Escribir "Se ha leído al menos un número negativo.";
    Sino
        Escribir "No se ha leído ningún número negativo.";
    Fin Si
FinAlgoritmo