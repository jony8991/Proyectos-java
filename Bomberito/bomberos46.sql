-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2023 a las 23:11:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bomberos`
--
CREATE DATABASE IF NOT EXISTS `bomberos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bomberos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

CREATE TABLE `bombero` (
  `idBombero` int(11) NOT NULL,
  `dni` int(8) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `grupoSanguineo` varchar(3) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `codBrigada` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`idBombero`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `grupoSanguineo`, `celular`, `codBrigada`, `activo`) VALUES
(3, 36229255, 'Santillan Cardozo', 'Ramiro Joaq', '1991-08-31', 'A-', '3875372356', 15, 1),
(5, 12345699, 'Sanchez', 'Lucas Eze', '1990-10-20', 'A+', '2434645645', 12, 1),
(6, 4651256, 'Martinez', 'Ramon', '1993-10-21', 'B-', '156456156', 17, 1),
(7, 98745611, 'Puerta', 'Jose Luis', '1982-10-15', 'AB-', '45645456', 7, 1),
(8, 12345678, 'Gonzalez', 'Juan', '1990-05-15', 'A+', '123-456-7890', 13, 1),
(9, 23456789, 'Martinez', 'Maria', '1985-09-20', 'B-', '234-567-8901', 6, 1),
(10, 34567890, 'Lopez', 'Pedro', '1992-02-10', 'O+', '345-678-9012', 12, 1),
(11, 45678901, 'Rodriguez', 'Ana', '1988-11-30', 'AB+', '456-789-0123', 6, 1),
(12, 56789012, 'Fernandez', 'Carlos', '1995-07-05', 'A-', '567-890-1234', 6, 1),
(13, 67890123, 'Perez', 'Luis', '1998-03-25', 'O-', '678-901-2345', 6, 1),
(14, 78901234, 'Gomez', 'Laura', '1982-12-12', 'B+', '789-012-3456', 16, 1),
(15, 89012345, 'Sanchez', 'Sofia', '1993-04-08', 'AB-', '890-123-4567', 13, 1),
(16, 90123456, 'Diaz', 'Manuel', '1987-06-18', 'A+', '901-234-5678', 13, 1),
(17, 12345670, 'Lopez', 'Elena', '1991-08-22', 'O+', '123-456-7000', 7, 1),
(19, 12958568, 'Cardozo', 'Beti', '1958-10-22', 'A+', '456456456456', 7, 1),
(24, 312312, 'fggfgf', 'asdasdasd', '2023-10-14', 'a+', '12312312123', NULL, 0),
(25, 55555555, 'Suarez', 'Ramon', '1945-10-20', 'AB+', '165615561', NULL, 0),
(26, 12121212, 'Martinez', 'Mario', '1978-10-22', 'A+', '5115456456', 16, 1),
(27, 11202021, 'Rodriguez', 'Fernando', '1999-10-29', 'O+', '5454654564', 12, 1),
(28, 77777777, 'Ramirez', 'Lucas', '1998-10-23', 'AB+', '456456456456', 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

CREATE TABLE `brigada` (
  `idBrigada` int(11) NOT NULL,
  `nombreBrigada` varchar(20) NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  `libre` tinyint(1) NOT NULL,
  `nroCuartel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`idBrigada`, `nombreBrigada`, `especialidad`, `libre`, `nroCuartel`) VALUES
(6, 'Alfa', '1- Incendios en viviendas, e industrias ', 0, 1),
(7, 'Beta', '2- Salvamento en derrumbes', 1, 2),
(12, 'Gamma', '3- Rescates en ámbito montaña ', 1, 2),
(13, 'Delta', '4- Rescate de personas atrapad', 1, 2),
(14, 'Epsilon', '5- Socorrer inundaciones', 1, 2),
(15, 'Zeta', '6- Operativos de prevención', 1, 2),
(16, 'Eta', '1- Incendios en viviendas, e industrias ', 1, 2),
(17, 'Theta', '2- Salvamento en derrumbes', 1, 2),
(18, 'Prueba', '3- Rescates en ámbito montaña ', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `idCuartel` int(11) NOT NULL,
  `nombreCuartel` varchar(20) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `coordX` int(11) NOT NULL,
  `coordY` int(11) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`idCuartel`, `nombreCuartel`, `direccion`, `coordX`, `coordY`, `telefono`, `correo`) VALUES
(1, 'Santa Lucia', 'Santa Catalina 2606', 24, 651, '3875372356', 'losalvamos@gmail.com'),
(2, 'Locura  Total', 'Donde sea', 255, 190, '35455645', 'ayudatotal@gmail.com'),
(3, 'Atocha', 'Batalla de Salta 22', 1, 17, '561456564', 'locos@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `idSiniestro` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `fechaSiniestro` date NOT NULL,
  `coordX` int(11) NOT NULL,
  `coordY` int(11) NOT NULL,
  `detalles` text NOT NULL,
  `fechaResolucion` date DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `codBrigada` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL,
  `horaSin` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `siniestro`
--

INSERT INTO `siniestro` (`idSiniestro`, `tipo`, `fechaSiniestro`, `coordX`, `coordY`, `detalles`, `fechaResolucion`, `puntuacion`, `codBrigada`, `activo`, `horaSin`) VALUES
(1, '1- Incendios en viviendas, e industrias ', '2023-10-12', 12, 23, 'Casa del pequeño Timmy', NULL, NULL, 6, 1, NULL),
(2, '5- Socorrer inundaciones', '2023-10-20', 14, 12, 'Timmy cayo al rio', '2023-10-24', 8, 14, 0, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`idBombero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `codBrigada` (`codBrigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`idBrigada`),
  ADD KEY `nroCuartel` (`nroCuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`idCuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`idSiniestro`),
  ADD KEY `siniestro_ibfk_1` (`codBrigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `idBombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `idBrigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `idCuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `idSiniestro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`idBrigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`nroCuartel`) REFERENCES `cuartel` (`idCuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`idBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
