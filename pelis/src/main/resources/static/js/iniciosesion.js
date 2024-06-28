const username = document.getElementById('usuario');
const password = document.getElementById('password');
const boton = document.getElementById('boton-enviar');

boton.addEventListener('click', (evento) => {
    
    evento.preventDefault();
    
    if (username.value == "admin" && password.value == "admin")
        alert("Usted a Iniciado Sesión correctamente");
    else
        document.getElementById('datos-incorrectos').classList.replace("text-datosIncorrectos", "text-datosIncorrectos-mostrar");
    
        
})
