Algoritmo Secuencia_Notas
	Definir notaDiez Como Logico;
	Definir nota Como Entero;
    notaDiez <- Falso;
    Escribir "Introduzca la primera nota (Las notas deben ser de 0 a 10. Escribe -1 para terminar): ";
    Leer nota;
    Mientras nota <> -1
        Si nota == 10
            hubo_nota_10 <- Verdadero;
        Fin Si
        Escribir "Introduzca otra nota (Las notas deben ser de 0 a 10. Escribe -1 para terminar): ";
        Leer nota;
    Fin Mientras
    Si hubo_nota_10
        Escribir "Se ha encontrado al menos una nota con un valor igual a 10.";
    Sino
        Escribir "No se ha encontrado ninguna nota con un valor igual a 10.";
    Fin Si
FinAlgoritmo