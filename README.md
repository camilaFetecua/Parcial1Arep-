# TALLER DE VERIFICACIÓN DE CONOCIMIENTOS TÉCNICOS-GRUPO 2

##Maria Camila Fetecua Garcia 

# Prerrequisitos 
  + Git version 2.25.1
  + Apavhe Maven version 4.0.0
  + Java version 11.0.11
  
 Para verificar que esten instalados los programas puede usar los suguientes comandos
    + mvn --version
    + git version
    +java --version

Para ejecutar el proyecto debe pirmero clonar el repositorio:

git clone https://github.com/camilaFetecua/Parcial1Arep-.git

 Para ejecutar el ejecicio utilice el siguiente comando:
   
    java -cp java -cp ArepaParcial-1.0-SNAPSHOT.jar co.edu.escuelaing.arep.HttpServer.HttpServer


1. Construir una  aplicación web usando sockets que reciba un número y una cadena de tres caracteres. La cadena puede ser una de tres opciones: "cos", "sin", "tan".
La aplicación asume que el número que recibe está en radianes y muestra el valor de la función trigonométrica correspondiente.
2. Arquitectura:
  + La aplicación tendrá tres componentes distribuidos: Una fachada de servicios, un servicio de calculadora trigonomética, y un cliente web (html +js).
  + Los servicios de la fachada y de la calculadora deben estar desplegados en dynos diferentes.
  + El cliente se descarga desde un servicio en la fachada (Puede entregar el cliente directamente desde un método no es necesario que lo lea desde el disco).
  + La comunicación se hace usando http y las respuestas de los servicios son en formato JSON.
  
 3. La caculadora trigonométrica (TrigCalculator) es la que hace el computo real de las funciones. La fachada de servicios (ServiceFacade) solo delega el ccomputo al TrigCalculator.
 4. Su diseño debe soportar la composición de nuevas operaciones para modificar servicios existentes o componer nuevos servicios. Por ejemplo, piense que en el futuro podemos solicitar que se creen nuevos servicios sobre  el API web, es decir,  debe ser fácilmente extensible.
 5. El diseño de los servicios WEB debe tener en cuenta buenas prácticas de diseño OO.
 6. Despliegue los servicios en Heroku en dynos separados.
  7. Los llamados al servicio de calculadora desde el cliente deben ser asíncronos usando el mínimo JS prosible. No actualice la página en cada llamado, solo el resultado.



Para 
