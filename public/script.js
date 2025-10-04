// - SIGN IN DUGME
let signDugme = document.querySelector("#sign-in-btn");

signDugme.addEventListener("click", (e) => {
  e.preventDefault();
  window.location.href = "./panel.html";
});
