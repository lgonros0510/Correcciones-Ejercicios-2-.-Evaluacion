Algoritmo Suma_Pares_Impares
	Definir sumaPares, sumaImpares, numero Como Entero;
    sumaPares <- 0;
    sumaImpares <- 0;
    Para numero <- 100 Hasta 200
        Si numero % 2 == 0 Entonces
            sumaPares <- sumaPares + numero;
        Sino
            sumaImpares <- sumaImpares + numero;
        Fin Si
    Fin Para
    Escribir "La suma de los números pares entre 100 y 200 es ", sumaPares;
    Escribir "La suma de los números impares entre 100 y 200 es ", sumaImpares;
FinAlgoritmo