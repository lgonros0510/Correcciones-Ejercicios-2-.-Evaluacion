Algoritmo Suma_Producto_Numeros_Naturales
	Definir suma, producto Como Entero;
    suma <- 0;
    producto <- 1;
    Para i <- 1 Hasta 10
        suma <- suma + i;
        producto <- producto * i;
    Fin Para
    Escribir "La suma de los 10 primeros números naturales es ", suma;
    Escribir "El producto de los 10 primeros números naturales es ", producto;
FinAlgoritmo