Algoritmo Secuencia_Numeros_Positivos_Negativos
	Definir numPositivos, numNegativos, numero Como Entero;
    numPositivos <- 0;
    numNegativos <- 0;
    Escribir "Introduzca un n�mero cualquiera (pulsa 0 para terminar): ";
    Leer numero;
    Mientras numero <> 0
        Si numero < 0
            numNegativos <- numNegativos + 1;
        Sino
            numPositivos <- numPositivos + 1;
        Fin Si
        Escribir "Introduzca otro n�mero cualquiera (pulsa 0 para terminar): ";
        Leer numero;
    Fin Mientras
    Si numNegativos > 0
        Escribir "Se ha le�do al menos un n�mero negativo.";
    Sino
        Escribir "No se ha le�do ning�n n�mero negativo.";
    Fin Si
    Escribir "Se han introducido por teclado ", positivos, " n�meros positivos.";
    Escribir "Se han introducido por teclado ", negativos, " n�meros negativos.";
FinAlgoritmo