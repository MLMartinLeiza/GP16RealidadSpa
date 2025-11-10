-- phpMyAdmin SQL Dump
-- version 5.2.3-1.fc43
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 10-11-2025 a las 13:45:22
-- Versión del servidor: 10.11.13-MariaDB
-- Versión de PHP: 8.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spag16`
--
CREATE DATABASE IF NOT EXISTS `spag16` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `spag16`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codCli` int(10) NOT NULL,
  `dni` int(10) NOT NULL,
  `nombreCompleto` varchar(60) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `edad` int(10) NOT NULL,
  `afecciones` varchar(100) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codCli`, `dni`, `nombreCompleto`, `telefono`, `edad`, `afecciones`, `estado`) VALUES
(1, 38749542, 'Martin Leiza', '0000393426', 30, 'Nada', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorio`
--

CREATE TABLE `consultorio` (
  `nroConsultorio` int(10) NOT NULL,
  `usos` varchar(100) NOT NULL,
  `equipamiento` varchar(200) NOT NULL,
  `apto` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dia_de_spa`
--

CREATE TABLE `dia_de_spa` (
  `codPack` int(10) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `preferencias` varchar(100) NOT NULL,
  `codCli` int(10) DEFAULT NULL,
  `monto` double NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dia_de_spa`
--

INSERT INTO `dia_de_spa` (`codPack`, `fecha_hora`, `preferencias`, `codCli`, `monto`, `estado`) VALUES
(1, '2025-11-14 10:00:00', 'Masaje Relajante', 1, 10000, 1),
(2, '2025-11-17 10:00:00', 'Masaje mas relajante', 1, 15000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instalacion`
--

CREATE TABLE `instalacion` (
  `codInstal` int(10) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `detalle_uso` varchar(200) NOT NULL,
  `precio_30min` decimal(10,2) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `masajista`
--

CREATE TABLE `masajista` (
  `matricula` int(10) NOT NULL,
  `nombre_apellido` varchar(200) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `especialidad` varchar(200) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `codSesion` int(10) NOT NULL,
  `fecha_hora_inicio` datetime NOT NULL,
  `fecha_hora_fin` datetime DEFAULT NULL,
  `codTratamiento` int(10) DEFAULT NULL,
  `nroConsultorio` int(10) DEFAULT NULL,
  `matricula` int(10) DEFAULT NULL,
  `codPack` int(10) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `codInstal` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `codTratam` int(10) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `detalle` varchar(200) NOT NULL,
  `duracion` int(50) NOT NULL,
  `costo` double NOT NULL,
  `activo` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`codTratam`, `nombre`, `detalle`, `duracion`, `costo`, `activo`) VALUES
(1, 'Masaje Sueco', 'Terapia de relajación de cuerpo completo con presión ligera a media', 30, 5000, 1),
(2, 'Masaje de tejido profundo', 'Para aliviar tensión muscular crónica y tratar contracturas, con presión más intensa', 30, 5000, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codCli`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  ADD PRIMARY KEY (`nroConsultorio`);

--
-- Indices de la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD PRIMARY KEY (`codPack`),
  ADD KEY `fk_dia_cliente` (`codCli`);

--
-- Indices de la tabla `instalacion`
--
ALTER TABLE `instalacion`
  ADD PRIMARY KEY (`codInstal`);

--
-- Indices de la tabla `masajista`
--
ALTER TABLE `masajista`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`codSesion`),
  ADD KEY `fk_sesion_tratamiento` (`codTratamiento`),
  ADD KEY `fk_sesion_consultorio` (`nroConsultorio`),
  ADD KEY `fk_sesion_masajista` (`matricula`),
  ADD KEY `fk_sesion_dia` (`codPack`),
  ADD KEY `fk_sesion_instalacion` (`codInstal`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`codTratam`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codCli` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  MODIFY `nroConsultorio` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  MODIFY `codPack` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `codSesion` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `codTratam` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD CONSTRAINT `fk_dia_cliente` FOREIGN KEY (`codCli`) REFERENCES `cliente` (`codCli`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_sesion_consultorio` FOREIGN KEY (`nroConsultorio`) REFERENCES `consultorio` (`nroConsultorio`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sesion_dia` FOREIGN KEY (`codPack`) REFERENCES `dia_de_spa` (`codPack`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sesion_instalacion` FOREIGN KEY (`codInstal`) REFERENCES `instalacion` (`codInstal`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sesion_masajista` FOREIGN KEY (`matricula`) REFERENCES `masajista` (`matricula`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sesion_tratamiento` FOREIGN KEY (`codTratamiento`) REFERENCES `tratamiento` (`codTratam`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
