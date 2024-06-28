//capturamos los elementos
const fetchMoviesButton = document.getElementById('fetchMovies');

const moviesTableBody = document.getElementById('moviesTableBody');

// llama a la APi de java
function getPelis() {
    const respuesta = fetch(`http://localhost:8080/listarPeliculas`);

    //2 invocar
    respuesta
        .then(response => response.json())
        .then(response => renderMovies(response))//fulfilled
        .catch(error => dibujarError(error))//rejected
}

// Function to render movies in the table
function renderMovies(movies) {
    moviesTableBody.innerHTML = '';
    movies.forEach((movie, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
                <td>${movie.titulo}</td>
                <td>${movie.fechaLanzamiento}</td>
                <td>${movie.duracion}</td>
                <td>${movie.puntuacion}</td>
                <td><img src="${movie.portada}" alt="${movie.titulo}" width="150"></td>
                <td>
                    <button class="btn btn-danger btn-sm delete-movie" onclick="deletePeli(${movie.id})"">Delete</button>
                </td>
            `;
        moviesTableBody.appendChild(row);
    });
}


// Delete peli
function deletePeli(id) {
    //apuntamos al endpoint de nuestro controller
    const response= fetch(`http://localhost:8080/deletePelicula/${id}`, {
        method: 'DELETE',
    });

    //2 invocar
    response
        .then(response => okDel(response))//fulfilled
        .catch(error => dibujarError(error))//rejected
}

function okDel(response) {
    document.querySelector('#moviesTableBody').innerHTML = "Se eliminó exitosamente";
}

function dibujarError(error) {
    document.querySelector('#moviesTableBody').innerHTML = error;
}
