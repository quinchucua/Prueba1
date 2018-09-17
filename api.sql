-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 17, 2018 at 05:03 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `api`
--

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `idEstado` int(11) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstado`),
  UNIQUE KEY `idEstado_UNIQUE` (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `estado`
--

INSERT INTO `estado` (`idEstado`, `Estado`) VALUES
(1, 'Bueno'),
(2, 'Malo'),
(3, 'Nuevo');

-- --------------------------------------------------------

--
-- Table structure for table `recursos`
--

DROP TABLE IF EXISTS `recursos`;
CREATE TABLE IF NOT EXISTS `recursos` (
  `Serial` bigint(20) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Provedor` varchar(45) NOT NULL,
  `Valor_Comercial` varchar(45) NOT NULL,
  `Fecha_compra` date NOT NULL,
  `Estado` int(11) NOT NULL,
  `Tipo_recurso` int(11) NOT NULL,
  `Codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`Serial`),
  KEY `Estado_idx` (`Estado`),
  KEY `Tipo_recurso_idx` (`Tipo_recurso`),
  KEY `Codigo_idx` (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recursos`
--

INSERT INTO `recursos` (`Serial`, `Marca`, `Provedor`, `Valor_Comercial`, `Fecha_compra`, `Estado`, `Tipo_recurso`, `Codigo`) VALUES
(1234, 's6', 'Sansung', '1500000', '2018-05-20', 1, 1, 122),
(12345, 's9', 'Sansung', '1500000', '2018-05-20', 1, 1, 121);

-- --------------------------------------------------------

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE IF NOT EXISTS `responsable` (
  `Codigo` bigint(20) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  `Tipo_Res` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `Tipo_Res_idx` (`Tipo_Res`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `responsable`
--

INSERT INTO `responsable` (`Codigo`, `Nombre`, `Apellido`, `Telefono`, `Tipo_Res`) VALUES
(120, 'Andres', 'Castiblanco', 3134535412, 2),
(121, 'Andes', 'Rodriguez', 3114535413, 1),
(122, 'Camilo', 'Peña', 3111596325, 1),
(223, 'Alfonso', 'Garcia', 3114535413, 2),
(224, 'Carlos', 'Perez', 3112563147, 2),
(225, 'Miguel', 'Sanchez', 3112365412, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_recurso`
--

DROP TABLE IF EXISTS `tipo_recurso`;
CREATE TABLE IF NOT EXISTS `tipo_recurso` (
  `Tipo_Recurso` int(11) NOT NULL,
  `Recurso` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo_Recurso`),
  UNIQUE KEY `Tipo_Recurso_UNIQUE` (`Tipo_Recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_recurso`
--

INSERT INTO `tipo_recurso` (`Tipo_Recurso`, `Recurso`) VALUES
(1, 'Tecnologico'),
(2, 'Oficina'),
(3, 'Cafeteria'),
(4, 'Aseo');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_responsable`
--

DROP TABLE IF EXISTS `tipo_responsable`;
CREATE TABLE IF NOT EXISTS `tipo_responsable` (
  `Tipo_Res` int(11) NOT NULL,
  `Area` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo_Res`),
  UNIQUE KEY `idTipo_Responsable_UNIQUE` (`Tipo_Res`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_responsable`
--

INSERT INTO `tipo_responsable` (`Tipo_Res`, `Area`) VALUES
(1, 'Recursos Humanos'),
(2, 'Diseño'),
(3, 'Desarrollo'),
(4, 'Tecnica'),
(5, 'Contabilidad'),
(6, 'Finanzas'),
(7, 'Recepcion');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `recursos`
--
ALTER TABLE `recursos`
  ADD CONSTRAINT `Codigo` FOREIGN KEY (`Codigo`) REFERENCES `responsable` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Estado` FOREIGN KEY (`Estado`) REFERENCES `estado` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Tipo_recurso` FOREIGN KEY (`Tipo_recurso`) REFERENCES `tipo_recurso` (`Tipo_Recurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `responsable`
--
ALTER TABLE `responsable`
  ADD CONSTRAINT `Tipo_Res` FOREIGN KEY (`Tipo_Res`) REFERENCES `tipo_responsable` (`Tipo_Res`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
