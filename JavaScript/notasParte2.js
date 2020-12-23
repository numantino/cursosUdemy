"use strict";
//Activacion Strict Mode, tendremos que poner estas lineas en el inicion del fichero
//Sirve para escribir el codigo con meyor seguridad, elimina muchos errores de escritura

// ************* DECLARACION DE FUNCIONES **************************************
//Function declaration; Se puede llamar a la funcion antes de que este declarada en el codigo
function ejemplo2(p1) {
  return p1;
}
const a = ejemplo2(2);

//Function expression
const ejemplo3 = function (p1) {
  return p1;
};
const a2 = ejemplo3(2);

//Arrow function, seran usadas para funciones muy faciles que se puedan escribir en una sola linea
//y que no tengan mucha logica
const ejemplo4 = (p1) => p1;
const e3 = ejemplo4(2);
//si necesitamos escribir mas lineas, logica y parametros, se podria realizar (mas complejo de leer)
const ejemplo5 = (p2, p3) => {
  const valor1 = 20 + p2;
  const valor3 = p3 + valor1;
  return valor3;
};
const e4 = ejemplo4(2, 4);
//*********************************************************************************************
//ARRAY
const ejemploArray = [2, 3, "hola", true];
//insertar elementos
ejemploArray.push("otro");
//Insertamos un elemento, pero obtenemos el numero de elementos del array
const valorArray = ejemploArray.push(2);
//Insertamos el elemento en el inicio del array
ejemploArray.unshift(false);
//eliminar un elemento
ejemploArray.pop();
//eliminamos el primer elemento
ejemploArray.shift();
//devuelve la posicion del elemento buscado
const pos = ejemploArray.indexOf("hola");
//Indica si un elemento existe en el array
ejemploArray.includes("hola");
//*********************************************************************************************
//OBJECT
//La forma mas facil de crearlos es de la siguiente manera
const raul = {
  nombre: "Raul",
  apellido: "Gonzalez",
  nacimientoEdad: 9,
  muerteEdad: 10,
  deportes: ["futbol", "tenis"],
};
//1 - Recuperar los datos (de esta manera tenemos mas funcionalidades)
const dato1 = raul.nombre;
const tamDato1 = raul.nombre.length;
//2 - Recuperar los datos mediante parentesis, es mas para este tipo de casos
const dato2 = raul["edad"];
const val = "Edad";
const dato3 = raul["nacimento" + val];
const dato4 = raul["muerte" + val];
//Tambien podemos crear funciones (como expresiones) dentro de los objetos
const raul2 = {
  nombre: "Raul",
  apellido: "Gonzalez",
  nacimientoEdad: 9,
  muerteEdad: 10,
  deportes: ["futbol", "tenis"],

  calcEdad: function (datoIn) {
    return datoIn - this.nacimientoEdad;
  },
};
raul2.calcEdad(9);
//*********************************************************************************************
//FOR loop
for (let rep = 1; rep <= 10; rep++) {
  //codigo de las iteraciones
  //Si se quiere salir, pondremos la sentencia 'break'
}
//*********************************************************************************************
//WHILE loop
let rep2 = 1;
while (rep2 <= 10) {
  //codigo para las iteraciones
  rep2++;
}
//Para realizar el debugg del codigo se realiza desde el nevegador, con puntos de interrucion, pero
//tambien podemos nosotros indicarselo en el codigo por medio de la siguiente palabra
debugger;
