// La forma de ejecutar el codigo desde el HTML (index.html) seria mediante el siguiente tag:
// <script src="nombreFihcero.js"></sript>
// sobre ese tag podriamos escribir el codigo tambien

//La convencion para las variables, es empezar con letra minuscula 
//y separar con mayusculas las diferentes palabras
//Cunando se crea una variable, no tenemos que indicarle de que tipo es
//Ademas podremos usar la misma variable para diferentes tipos
//No se puede empezar con un numero
//la palabra 'name' esta reservada, no se tendria que usar en el codigo
let ejemploDeVariable = 'ejemplo';
ejemploDeVariable = 2;
//Declaracion de constantes, este valor es inmutable
const ejemploConstante = 111;
//es una forma antigua de declarar variables (en desuso)
var ejemploVariable='valor';

//Escribir en consola
console.log("datos para escribir en la consola");

//Para saber que tipo de variable se usa, podemos usar la funcion 'typeof'
console.log(typeof ejemploDeVariable);

//String
let firstName='Raul';
//Podemos crear templates para facilitar la lectura del codigo, de esta manera
const raulName = `I'm ${firstName}`;
//Con esta forma podemos escribir palabras en diferentes lineas
console.log('Multiple lineas \n\
otra mas \n\
linea');

//Conversion variables a diferentes tipos
const vString = '1999';
const vNumero = 333;
Number(vString);
String(vNumero);
Boolean(0);  //Se puede insertar cualquier variable

//Operador de comparacion
const age=18;
if (age === 18) console.log("Comparacion extricto, no solo mira en contenido sino tambien el tipo que es");
else if (age == '18') console.log("Comparacion si el contenido es el mismo");
else if (age != 20) console.log("Valor inverso");
else console.log("Resto");

//Ternary operator (sustituya un if)
const age = 23;
const ejemploDos= age >= 18 ? 'Si es mayor ejecutamos esto' : 'Si es menor ejecutamos esto';

