Algoritmo Factorial_Numero
	Definir numero, factorial Como Entero;
	Escribir "Introduzca un n�mero positivo cualquiera: ";
    Leer numero;
    Si numero < 0 Entonces
        Escribir "ERROR. El n�mero que has introducido NO es positivo.";
    Sino
        factorial <- 1;
        Para i <- 1 Hasta numero
            factorial <- factorial * i;
        Fin Para
        Escribir "El factorial de ", numero, " es ", factorial;
    Fin Si
FinAlgoritmo