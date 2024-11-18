# ADTWorkshop

**Curso:** Programación III  
**Profesor:** PhD (c). Luis Fernando Aguas Bucheli  
**Ubicación:** Quito, Ecuador

## Objetivo

El objetivo de este taller es reforzar el conocimiento y comprensión de las estructuras de datos Pilas, Colas, Colas de Prioridad, y la implementación de la Forma Polaca Inversa (RPN) a través de problemas prácticos.

## Instrucciones

1. Lee cuidadosamente cada problema.
2. Implementa las soluciones utilizando Java en interfaz gráfica.
3. Al finalizar, deberás presentar el código y una breve explicación de cómo funciona tu solución para cada ejercicio.

## Ejercicios

### Ejercicio 1: Revertir una secuencia con Pilas

**Descripción:**  
Escribe un programa que tome una secuencia de números enteros y los devuelva en el orden inverso utilizando una Pila. No debes usar estructuras de datos adicionales como arreglos o listas para revertir la secuencia.

**Entrada:**  
Una secuencia de números enteros separados por espacios.

**Salida:**  
La secuencia de números en orden inverso.

**Ejemplo:**  
Entrada: `1 2 3 4 5`  
Salida: `5 4 3 2 1`

### Ejercicio 2: Gestión de una fila en un banco usando Colas

**Descripción:**  
Simula el comportamiento de una fila en un banco utilizando una Cola. Los clientes llegarán en diferentes momentos, y tu programa deberá procesar la cola a medida que cada cliente es atendido. Imprime el orden en que los clientes son atendidos.

**Entrada:**  
La cantidad de clientes que llegan y sus nombres.

**Salida:**  
El nombre de cada cliente en el orden en que es atendido.

**Ejemplo:**  
Entrada: `5 Ana Carlos Luis Sofía Pedro`  
Salida:  
Ana
Carlos
Luis
Sofía
Pedro


### Ejercicio 3: Sistema de Prioridades para una Emergencia (Cola de Prioridad)

**Descripción:**  
En un hospital, las personas que llegan a la sala de emergencias tienen diferentes niveles de prioridad (1 = alta, 2 = media, 3 = baja). Escribe un programa que gestione la atención de pacientes utilizando una Cola de Prioridad, donde los pacientes con mayor prioridad sean atendidos antes.

**Entrada:**  
La cantidad de pacientes que llegan y sus nombres, junto con su nivel de prioridad (1, 2 o 3).

**Salida:**  
El nombre de cada paciente en el orden en que es atendido, de acuerdo con su prioridad.

**Ejemplo:**  
Entrada: `5 Pedro 3 Ana 1 Carlos 2 Luis 1 Sofía 2`  
Salida:  
Ana ha sido atendida (prioridad 1).
Luis ha sido atendido (prioridad 1).
Carlos ha sido atendido (prioridad 2).
Sofía ha sido atendida (prioridad 2).
Pedro ha sido atendido (prioridad 3).


### Ejercicio 4: Expresiones Balanceadas con Pilas

**Descripción:**  
Escribe un programa que determine si una expresión matemática con paréntesis está balanceada. Utiliza una Pila para resolver el problema. La expresión está balanceada si cada paréntesis abierto tiene su correspondiente cierre.

**Entrada:**  
Una expresión matemática que contiene `()`, `{}`, y `[]`.

**Salida:**  
"Balanceada" si la expresión está correctamente balanceada, o "No balanceada" si no lo está.

**Ejemplo:**  
Entrada: `( { [ ] } )`  
Salida: `Balanceada`  
Entrada: `( { [ ] )`  
Salida: `No balanceada`

### Ejercicio 5: Evaluación de expresiones en Forma Polaca Inversa (RPN)

**Descripción:**  
La Forma Polaca Inversa (RPN) es una notación en la que los operadores siguen a sus operandos, lo que permite evaluar expresiones matemáticas sin necesidad de paréntesis. Escribe un programa que evalúe una expresión en Forma Polaca Inversa utilizando una Pila.

**Entrada:**  
Una expresión en Forma Polaca Inversa que contenga números enteros y operadores `+`, `-`, `*`, `/`.

**Salida:**  
El resultado de evaluar la expresión.

**Ejemplo:**  
Entrada: `5 1 2 + 4 * + 3 -`  
Salida: `14`

**Explicación:**  
- `1 + 2 = 3`  
- `3 * 4 = 12`  
- `5 + 12 = 17`  
- `17 - 3 = 14`

## Recomendaciones

- Utiliza una pila para almacenar los operandos.
- Lee la expresión desde el principio hasta el final.
- Si el elemento es un número, colócalo en la pila.
- Si el elemento es un operador, extrae dos números de la pila, aplica el operador, y coloca el resultado en la pila.

## Entrega

Debe entregarse los siguientes elementos:
- Un documento en Word donde se explique detalladamente la solución de cada ejercicio. (Formato adjunto)
- El código fuente comprimido en un archivo `.zip` o `.rar`.

## Bibliografía

- Aguas Bucheli, L. F. (2023a). *Dominando la Programación Orientada a Objetos con Java en NetBeans*. Our Knowledge Publishing.
- Aguas Bucheli, L. F. (2023b). *Manos a la Obra: Prácticas de Laboratorio en Estructuras de Datos*. Our Knowledge Publishing.
- Bloch, J. (2018). *Effective Java* (3rd ed.). Addison-Wesley.
- Horstmann, C. S. (2018). *Core Java Volume I--Fundamentals* (11th ed.). Prentice Hall.
- Sierra, K., & Bates, B. (2014). *Head First Java*. O'Reilly Media.

