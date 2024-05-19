// Definimos la URL de la api de donde se traen los datos de las peliculas 
const ApiMovie = 'https://api.themoviedb.org/3';
//guardo en una constante la llave para acceder a los datos de la API
const ApiKey = 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTJjYTAwZDYxZWIzOTEyYjZlNzc4MDA4YWQ3ZmNjOCIsInN1YiI6IjYyODJmNmYwMTQ5NTY1MDA2NmI1NjlhYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4MJSPDJhhpbHHJyNYBtH_uCZh4o0e3xGhZpcBIDy-Y8';

//definimos el objeto options  que contiene las configuraciones necesarias para la solicitud fetch
const options = {
    method: 'GET', // Método de la petición (GET)
    headers: {
        accept: 'application/json', // Tipo de respuesta esperada (JSON)
        Authorization: ApiKey
        
    }
};

//variable para rastrear la página actual. Inicializa la pagina con el valor 1.
let currentPage = 1;

// Fetch para cargar trend Movies
function fetchMoviesTrend (page = 1){
    // Realizamos una petición fetch a la API para obtener las películas populares
    fetch(`${ApiMovie}/movie/popular?page=${page}`, options)
        .then(response => response.json()) // Convertimos la respuesta a JSON
        .then(data => {
            // Extraemos las películas de la respuesta y pasamos 
            //como argumento a la  funcion  para renderizarlas
            renderTrendMovies(data.results);
            //obtengo el elemeto  y seteo el data-page a la pagina actual
            document.querySelector('#trend').setAttribute('data-page', page);
        })
        .catch(error => console.error('Error fetching popular movies:', error));//manejo de error 
}



//Funcion para renderizar los datos obtenidos de la API en trends movies
function renderTrendMovies(movies) {
    const moviesResult = movies;
    let template = '';
    for(let movie of moviesResult) {
        template += 
        `
        <div class="trendMovies">
                        <a href="./peliInfo.html">
                            <div class="movie">
                                <img src="https://image.tmdb.org/t/p/w500/${movie.poster_path}" alt="${movie.title}"
                                    loading="lazy">
                                <div class="movieTittle">
                                    <h4>${movie.title}</h4>
                                </div>
                            </div>
                        </a>
        </div>
        `
    }
    // document.getElementById("trendContainer").innerHTML = template;
    document.querySelector('#trendContainer').innerHTML = template;
}

// Ejecutamos la función que obtiene los datos de peliculas de la API
fetchMoviesTrend();

// Event listeners para los botones de paginación
//before button
document.querySelector('#prev').addEventListener('click', () => {
    if (currentPage > 1) {
        currentPage --;
        fetchMoviesTrend(currentPage);
    }
});

//next button
document.querySelector('#buttonNext').addEventListener('click', () => {
    currentPage++;
    fetchMoviesTrend(currentPage);
});