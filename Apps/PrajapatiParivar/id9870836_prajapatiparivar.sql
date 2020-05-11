-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 10, 2020 at 07:51 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id9870836_prajapatiparivar`
--

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

CREATE TABLE `business` (
  `business_id` int(10) NOT NULL,
  `firm` varchar(200) NOT NULL,
  `ownerName` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `division` varchar(200) NOT NULL,
  `category` varchar(200) NOT NULL,
  `products` varchar(200) NOT NULL,
  `time` varchar(200) NOT NULL,
  `holiday` varchar(200) NOT NULL,
  `mobileNo` varchar(200) NOT NULL,
  `emailid` varchar(200) NOT NULL,
  `webside` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `masetruser`
--

CREATE TABLE `masetruser` (
  `mid` int(10) NOT NULL,
  `main_member_number` varchar(200) NOT NULL,
  `famile_id` varchar(200) NOT NULL,
  `image` varchar(200) NOT NULL,
  `user_name` varchar(200) CHARACTER SET utf8 NOT NULL,
  `relation` varchar(200) CHARACTER SET utf8 NOT NULL,
  `meridas_status` varchar(200) CHARACTER SET utf8 NOT NULL,
  `bod` date NOT NULL,
  `study` varchar(200) CHARACTER SET utf8 NOT NULL,
  `mossad` varchar(200) CHARACTER SET utf8 NOT NULL,
  `sasri` varchar(200) CHARACTER SET utf8 NOT NULL,
  `blood_group` varchar(200) CHARACTER SET utf8 NOT NULL,
  `mobile_no` varchar(200) CHARACTER SET utf8 NOT NULL,
  `pyramid_address` varchar(200) CHARACTER SET utf8 NOT NULL,
  `residential_address` varchar(200) CHARACTER SET utf8 NOT NULL,
  `mobile_login` varchar(200) CHARACTER SET utf8 NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 NOT NULL,
  `main_member` bit(1) NOT NULL,
  `time_stemp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `masetruser`
--

INSERT INTO `masetruser` (`mid`, `main_member_number`, `famile_id`, `image`, `user_name`, `relation`, `meridas_status`, `bod`, `study`, `mossad`, `sasri`, `blood_group`, `mobile_no`, `pyramid_address`, `residential_address`, `mobile_login`, `password`, `main_member`, `time_stemp`) VALUES
(1, '11', '11', 'files/Dipak.jpg', 'Dipak', 'pote', 'પરણીત', '2019-07-03', 'mca', 'Palodar', '', 'O-', 'a', 'Mehana', 'a', '9925098422', '123123', b'1', '2019-12-11 10:29:27');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `titel` varchar(200) NOT NULL,
  `messag` varchar(200) NOT NULL,
  `pickupload` varchar(200) NOT NULL,
  `date_time` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `titel`, `messag`, `pickupload`, `date_time`) VALUES
(1, 'What Is The Perfect Paragraph?', 'As designers, we are frequently and incorrectly reminded that our job is to â€œmake things pretty.â€ We are indeed designers â€” not artists â€” and there is no place for formalism in good design. We', 'uploads/02.jpg', '2019-01-06'),
(2, 'asd', 'rtyr', 'uploads/04.jpg', '2019-06-08'),
(3, 'werew', 'asdda', 'uploads/02.jpg', '2019-06-08'),
(4, 'werew', 'asdda', 'uploads/02.jpg', '2019-06-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `business`
--
ALTER TABLE `business`
  ADD PRIMARY KEY (`business_id`);

--
-- Indexes for table `masetruser`
--
ALTER TABLE `masetruser`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `business`
--
ALTER TABLE `business`
  MODIFY `business_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `masetruser`
--
ALTER TABLE `masetruser`
  MODIFY `mid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
