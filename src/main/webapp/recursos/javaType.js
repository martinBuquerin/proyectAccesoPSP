
let app = document.getElementById('typewriter');
 
let typewriter = new Typewriter(app, {
  loop: true,
  delay: 75,
});
 
typewriter
  .pauseFor(2500)
  .typeString('¿Qué servicio buscas?')
  .pauseFor(200)
  .deleteChars(10)
  .start();

 $('#modalRegistroAdmninistrador').on('shown.bs.modal', function () {
    $('#logIn').trigger('focus')
  })