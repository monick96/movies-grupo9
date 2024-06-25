-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2024 a las 21:58:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peliculas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actores`
--

CREATE TABLE `actores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `actores`
--

INSERT INTO `actores` (`id`, `nombre`, `apellido`) VALUES
(1, 'Owen', 'Teague'),
(2, 'Freya', 'Allan'),
(3, 'Kevin', 'Durand'),
(4, 'Peter', 'Macon'),
(5, 'Will', 'Smith'),
(6, 'Martin', 'Lawrence'),
(7, 'Vanessa', 'Hudgens'),
(8, 'Alexander', 'Ludwig');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `directores`
--

CREATE TABLE `directores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `directores`
--

INSERT INTO `directores` (`id`, `nombre`, `apellido`) VALUES
(1, 'Wes', 'Ball'),
(2, 'Bilall', 'Fallah'),
(3, 'Adil', 'El Arbi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `id` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id`, `tipo`) VALUES
(1, 'Ciencia Ficcion'),
(2, 'Accion'),
(3, 'Aventura'),
(4, 'Terror'),
(5, 'Suspenso'),
(6, 'Comedia'),
(7, 'Drama'),
(8, 'Fantasia'),
(9, 'Romance'),
(10, 'Crimen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guionistas`
--

CREATE TABLE `guionistas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `guionistas`
--

INSERT INTO `guionistas` (`id`, `nombre`, `apellido`) VALUES
(1, 'Josh', 'Friedman'),
(2, 'Will', 'Beall'),
(3, 'Chris', 'Bremner');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fechaLanzamiento` date NOT NULL,
  `puntuacion` tinyint(3) UNSIGNED NOT NULL,
  `duracion` time NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `idioma` varchar(50) NOT NULL,
  `estrenada` tinyint(1) NOT NULL,
  `portada` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `titulo`, `fechaLanzamiento`, `puntuacion`, `duracion`, `descripcion`, `idioma`, `estrenada`,`portada`) VALUES
(1, 'Kingdom of the Planet of the Apes', '2024-05-09', 7, '02:25:00', 'Descripción del planeta de los simios', 'Ingles', 1, 'https://image.tmdb.org/t/p/w500//gKkl37BQuKTanygYQG1pyYgLVgf.jpg'),
(2, 'Bad Boys: Ride or Die', '2024-06-07', 7, '01:55:00', 'Descripción de pelicula Bad Boys', 'Ingles', 1, 'https://image.tmdb.org/t/p/w500//nP6RliHjxsz4irTKsxe8FRhKZYl.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelis_actores`
--

CREATE TABLE `pelis_actores` (
  `pelicula_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelis_actores`
--

INSERT INTO `pelis_actores` (`pelicula_id`, `actor_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelis_directores`
--

CREATE TABLE `pelis_directores` (
  `pelicula_id` int(11) NOT NULL,
  `director_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelis_directores`
--

INSERT INTO `pelis_directores` (`pelicula_id`, `director_id`) VALUES
(1, 1),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelis_genero`
--

CREATE TABLE `pelis_genero` (
  `pelicula_id` int(11) NOT NULL,
  `genero_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelis_genero`
--

INSERT INTO `pelis_genero` (`pelicula_id`, `genero_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 6),
(2, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelis_guionistas`
--

CREATE TABLE `pelis_guionistas` (
  `pelicula_id` int(11) NOT NULL,
  `guionista_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelis_guionistas`
--

INSERT INTO `pelis_guionistas` (`pelicula_id`, `guionista_id`) VALUES
(1, 1),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelis_productores`
--

CREATE TABLE `pelis_productores` (
  `pelicula_id` int(11) NOT NULL,
  `productor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelis_productores`
--

INSERT INTO `pelis_productores` (`pelicula_id`, `productor_id`) VALUES
(1, 1),
(1, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productores`
--

CREATE TABLE `productores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productores`
--

INSERT INTO `productores` (`id`, `nombre`, `apellido`) VALUES
(1, 'Amanda', 'Silver'),
(2, 'Rick', 'Jaffa'),
(3, 'George', 'Gallo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actores`
--
ALTER TABLE `actores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `directores`
--
ALTER TABLE `directores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `guionistas`
--
ALTER TABLE `guionistas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pelis_actores`
--
ALTER TABLE `pelis_actores`
  ADD PRIMARY KEY (`pelicula_id`,`actor_id`),
  ADD KEY `actor_id` (`actor_id`);

--
-- Indices de la tabla `pelis_directores`
--
ALTER TABLE `pelis_directores`
  ADD PRIMARY KEY (`pelicula_id`,`director_id`),
  ADD KEY `director_id` (`director_id`);

--
-- Indices de la tabla `pelis_genero`
--
ALTER TABLE `pelis_genero`
  ADD PRIMARY KEY (`pelicula_id`,`genero_id`),
  ADD KEY `genero_id` (`genero_id`);

--
-- Indices de la tabla `pelis_guionistas`
--
ALTER TABLE `pelis_guionistas`
  ADD PRIMARY KEY (`pelicula_id`,`guionista_id`),
  ADD KEY `guionista_id` (`guionista_id`);

--
-- Indices de la tabla `pelis_productores`
--
ALTER TABLE `pelis_productores`
  ADD PRIMARY KEY (`pelicula_id`,`productor_id`),
  ADD KEY `productor_id` (`productor_id`);

--
-- Indices de la tabla `productores`
--
ALTER TABLE `productores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actores`
--
ALTER TABLE `actores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `directores`
--
ALTER TABLE `directores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `guionistas`
--
ALTER TABLE `guionistas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productores`
--
ALTER TABLE `productores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pelis_actores`
--
ALTER TABLE `pelis_actores`
  ADD CONSTRAINT `pelis_actores_ibfk_1` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id`),
  ADD CONSTRAINT `pelis_actores_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `actores` (`id`);

--
-- Filtros para la tabla `pelis_directores`
--
ALTER TABLE `pelis_directores`
  ADD CONSTRAINT `pelis_directores_ibfk_1` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id`),
  ADD CONSTRAINT `pelis_directores_ibfk_2` FOREIGN KEY (`director_id`) REFERENCES `directores` (`id`);

--
-- Filtros para la tabla `pelis_genero`
--
ALTER TABLE `pelis_genero`
  ADD CONSTRAINT `pelis_genero_ibfk_1` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id`),
  ADD CONSTRAINT `pelis_genero_ibfk_2` FOREIGN KEY (`genero_id`) REFERENCES `generos` (`id`);

--
-- Filtros para la tabla `pelis_guionistas`
--
ALTER TABLE `pelis_guionistas`
  ADD CONSTRAINT `pelis_guionistas_ibfk_1` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id`),
  ADD CONSTRAINT `pelis_guionistas_ibfk_2` FOREIGN KEY (`guionista_id`) REFERENCES `guionistas` (`id`);

--
-- Filtros para la tabla `pelis_productores`
--
ALTER TABLE `pelis_productores`
  ADD CONSTRAINT `pelis_productores_ibfk_1` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id`),
  ADD CONSTRAINT `pelis_productores_ibfk_2` FOREIGN KEY (`productor_id`) REFERENCES `productores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
