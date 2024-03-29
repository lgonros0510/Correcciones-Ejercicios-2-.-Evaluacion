Algoritmo Secuencia_Numeros_Positivos_Negativos
	Definir numPositivos, numNegativos, numero Como Entero;
    numPositivos <- 0;
    numNegativos <- 0;
    Escribir "Introduzca un número cualquiera (pulsa 0 para terminar): ";
    Leer numero;
    Mientras numero <> 0
        Si numero < 0
            numNegativos <- numNegativos + 1;
        Sino
            numPositivos <- numPositivos + 1;
        Fin Si
        Escribir "Introduzca otro número cualquiera (pulsa 0 para terminar): ";
        Leer numero;
    Fin Mientras
    Si numNegativos > 0
        Escribir "Se ha leído al menos un número negativo.";
    Sino
        Escribir "No se ha leído ningún número negativo.";
    Fin Si
    Escribir "Se han introducido por teclado ", positivos, " números positivos.";
    Escribir "Se han introducido por teclado ", negativos, " números negativos.";
FinAlgoritmo