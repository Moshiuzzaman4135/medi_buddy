-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2018 at 02:54 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentdb`
--
CREATE DATABASE IF NOT EXISTS `studentdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `studentdb`;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `name` varchar(32) NOT NULL,
  `id` varchar(32) NOT NULL,
  `cgpa` float NOT NULL,
  `major` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`name`, `id`, `cgpa`, `major`) VALUES
('', '', 0, ''),
('Shatil', '17-33713-1', 3.75, 'CSE'),
('Shatil', '1', 3.75, 'CSE'),
('ABC', '123', 3, 'CSE'),
('Farhan', '17-33720-1', 3.99, 'CSE'),
('sfsdfsd', '12121', 3, 'sgdsgsd'),
('Cat', '12', 2.2, 'CSE'),
('Moshiuzzaman', '1', 3.75, 'CSE');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
