Algoritmo Cien_Numeros_Negativo_O_No
	Definir contadorNegativos, numero Como Entero;
	contadorNegativos <- 0;
    Para i <- 1 Hasta 100
        Escribir "Introduzca el n�mero ", i, ", por favor: ";
        Leer numero;
        Mientras numero = 0
            Escribir "ERROR. El n�mero introducido NO puede ser 0.";
            Escribir "Introduzca el n�mero ", i, " nuevamente: ";
            Leer numero;
        Fin Mientras
        Si numero < 0
            contadorNegativos <- contadorNegativos + 1;
        Fin Si
    Fin Para
    Si contadorNegativos > 0
        Escribir "Se ha le�do al menos un n�mero negativo.";
    Sino
        Escribir "No se ha le�do ning�n n�mero negativo.";
    Fin Si
FinAlgoritmo