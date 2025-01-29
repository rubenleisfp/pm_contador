# Objetivo

Entender el concepto de Hoisting con un sencillo ejemplo de un contador.
Disponemos de un contador que comienza en 0 y podemos SUMAR 1 o RESTAR 1
El valor actual del contador lo veremos en un texto que se situará justo
debajo de los botones

Mediante hoisting elevamos una variable a la funcion padre, que nos sevirá
para derivarla hacia las hijas que la necesiten.

En Kotlin no podemos modificar los parámetros recibidos de una función, por 
lo que la opción más ortodoxa que tenemos, es recibir una función lambda que 
se llamará dónde sea necesario modificar este valor.

