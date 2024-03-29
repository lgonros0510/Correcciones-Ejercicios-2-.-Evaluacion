Algoritmo Adivinar_Numero_Usuario
    Definir numPensado, minimo, maximo, igual Como Entero;
    Definir respuesta, indicacion Como Caracter;
    minimo <- 1;
    maximo <- 100;
    igual <- 0;
    Escribir "Piensa en un número del 1 al 100. El ordenador intentará adivinarlo posteriormente.";
    Escribir "Cuando lo hayas pensado, daremos comienzo el juego.";
    Mientras minimo <= maximo Y igual = 0 hacer
        numPensado <- Aleatorio(minimo, maximo);
        Escribir "¿Es ", numPensado, " el número que has pensado? (s/n)";
        Leer respuesta;
        Si respuesta = "s" entonces
            Escribir "He logrado adivinar el número que has pensado.";
            igual <- numPensado;
        Sino 
            Si respuesta = "n" entonces
                Escribir "¿Es mayor o menor que ", numPensado, "? (mayor/menor)";
                Leer indicacion;
                Si indicacion = "mayor" entonces
                    minimo <- numPensado + 1;
                Sino
                    maximo <- numPensado - 1;
                Fin Si
            Fin Si
        Fin Si
    Fin Mientras
    Si igual <> 0 entonces
        Escribir "El número que has pensado es ", igual, ". Gracias por jugar conmigo :)";
    Sino
        Escribir "Parece que no has seguido las instrucciones. Vuelve a intentarlo otra vez :(";
    Fin Si
FinAlgoritmo