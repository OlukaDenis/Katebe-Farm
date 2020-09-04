-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2020 at 02:15 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `katebe`
--

-- --------------------------------------------------------

--
-- Table structure for table `goat`
--

CREATE TABLE `goat` (
  `ID` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `breed` varchar(255) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `source` varchar(255) NOT NULL,
  `birthdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goat`
--

INSERT INTO `goat` (`ID`, `name`, `breed`, `sex`, `source`, `birthdate`) VALUES
('DEN09', 'Denise', 'Exotic', 'Female', 'Ug', '2016-09-16'),
('DJHG6', 'Man', 'Local', 'Male', 'Jinja', '2018-09-08'),
('GT59', 'Dan', 'Local', 'Male', 'Inths', '2016-09-09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `goat`
--
ALTER TABLE `goat`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
