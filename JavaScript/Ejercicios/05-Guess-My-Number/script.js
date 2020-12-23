'use strict';
let secretNumber = Math.trunc(Math.random() * 20) + 1;
let scoreNombre = 20;
let maxScore = 0;

document.querySelector('.again').addEventListener('click', function () {
  //Almacenamos la puntuacion
  if (maxScore < scoreNombre) maxScore = scoreNombre;
  //Calculamos un nuevo numero aleatorio
  secretNumber = Math.trunc(Math.random() * 20) + 1;
  //Ponemos los valores a cero
  scoreNombre = 20;
  document.querySelector('.highscore').textContent = maxScore;
  document.querySelector('.message').textContent = 'Start guessing...';
  document.querySelector('.guess').value = '';
  document.querySelector('body').style.backgroundColor = '#222';
  document.querySelector('.number').style.width = '15rem';
  document.querySelector('.number').textContent = '?';
  document.querySelector('.score').textContent = scoreNombre;
});

document.querySelector('.check').addEventListener('click', function () {
  const guess = Number(document.querySelector('.guess').value);
  console.log(guess, typeof guess);
  if (!guess) {
    document.querySelector('.message').textContent = 'No number';
  } else if (guess === secretNumber) {
    //El jugador gana
    document.querySelector('.message').textContent = 'Correct number!!!';
    //Manipulamos el CSS
    document.querySelector('body').style.backgroundColor = '#60b347';
    document.querySelector('.number').style.width = '30rem';
    document.querySelector('.number').textContent = secretNumber;
  } else if (guess > secretNumber) {
    if (scoreNombre > 1) {
      document.querySelector('.message').textContent = 'Too high!';
      scoreNombre--;
    } else {
      scoreNombre = 0;
      document.querySelector('.message').textContent = 'you lost the game';
    }
  } else if (guess < secretNumber) {
    if (scoreNombre > 1) {
      document.querySelector('.message').textContent = 'Too low!';
      scoreNombre--;
    } else {
      scoreNombre = 0;
      document.querySelector('.message').textContent = 'you lost the game';
    }
  }
  document.querySelector('.score').textContent = scoreNombre;
});
