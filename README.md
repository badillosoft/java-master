# Curso de Java Master

Alan Badillo Salas <badillo.soft@hotmail.com>

# Contenido

### 1. Streams
### 2. Redes
### 3. Hilos
### 4. RMI (Remote Method Invocation)
### 5. JMX (Java Management Extensions)
### 6. JAXB (JAVA ARQUITECTURE FOR XML BINDING)
### 7. Seguridad

# Tareas

* Crear un programa que utilice la clase `Scanner` para leer los siguientes datos de una persona:

`Nombre Completo` de tipo `String`, `Edad` de tipo `Entero`, `Estatura` de tipo `Flotante` y `Peso` de tipo `Doble`.

Mostrar los datos con el siguiente formato reemplazando los valores de las comillas por los ingresados:

  Nombre: `John Doe`| Edad: `34` | Estatura: `1.80`m | Peso: `56`kg
  
* Crear un programa que lea los bytes de un archivo mediante las clases `FileInputStream` y `BufferInputStream`.
El programa deberá mostrar para cada byte leido si es par o impar (puede utilizar `n % 2 == 0` para checar si un número es par).

* Leer las notas disponibles en la carpeta de material [El modelo OSI y los protocolos de red](https://github.com/badillosoft/java-master/blob/master/material/Redes%20con%20Java%20-%20El%20modelo%20OSI%20y%20Protocolos%20de%20Red.pdf) y escribir que es un protocolo de red y en que consiste cada una de las 7 capas del modelo OSI.

* Crear la clase `Mensaje` que contenga un _string_ llamado `Contenido` y un _booleano_ llamado `Visto`. Transmitir el mensaje de un cliente al servidor mediante el uso de _sockets_ y las clases de `ObjectStream`.
