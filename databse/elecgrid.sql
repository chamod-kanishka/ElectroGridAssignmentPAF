-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
<<<<<<< HEAD
-- Generation Time: Apr 23, 2022 at 04:47 PM
=======
-- Generation Time: Apr 21, 2022 at 01:43 PM
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `elecgrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `bill_id` int(11) NOT NULL,
  `bill_no` varchar(255) NOT NULL,
  `bill_desc` varchar(255) NOT NULL,
  `bill_type` varchar(255) NOT NULL,
<<<<<<< HEAD
  `unit` int(11) NOT NULL,
  `cus_id` int(11) NOT NULL,
  `curr_date` date NOT NULL DEFAULT current_timestamp(),
  `update_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bills`
--

INSERT INTO `bills` (`bill_id`, `bill_no`, `bill_desc`, `bill_type`, `unit`, `cus_id`, `curr_date`, `update_date`) VALUES
(1, '1000', 'Red Notice', 'wee', 24, 1, '2022-04-23', '2022-04-23'),
(3, '123424', 'rgrgr', 'gdgb', 234, 12, '2022-04-23', '2022-04-23');

=======
  `unit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` int(11) NOT NULL,
  `cus_name` varchar(255) NOT NULL,
<<<<<<< HEAD
=======
  `unit` int(11) NOT NULL,
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
  `cus_mobile` varchar(255) NOT NULL,
  `cus_email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

<<<<<<< HEAD
INSERT INTO `customer` (`cus_id`, `cus_name`, `cus_mobile`, `cus_email`) VALUES
(1, 'john', '0112327747', 'john@gmail.com'),
(12, 'Jane', '0710432425', 'frompostmanupdate@gmail.com');
=======
INSERT INTO `customer` (`cus_id`, `cus_name`, `unit`, `cus_mobile`, `cus_email`) VALUES
(1, 'john', 20, '0112327747', 'john@gmail.com');
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `e_id` int(11) NOT NULL,
  `e_name` varchar(255) NOT NULL,
  `e_mobile` varchar(10) NOT NULL,
  `designation` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

<<<<<<< HEAD
--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`e_id`, `e_name`, `e_mobile`, `designation`) VALUES
(1, 'S. Fonseka', '0700432425', 'Meter Reader');

=======
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pay_id` int(11) NOT NULL,
  `pay_type` varchar(255) NOT NULL,
<<<<<<< HEAD
  `amount` double NOT NULL,
  `cus_id` int(11) NOT NULL,
  `bill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pay_id`, `pay_type`, `amount`, `cus_id`, `bill_id`) VALUES
(2, 'cash', 10000, 1, 1),
(3, 'cash', 14000, 1, 1),
(4, 'cash', 1400, 1, 1),
(5, 'cash', 1445, 1, 1),
(6, 'cash', 14450, 1, 1),
(7, 'cash', 14450, 12, 1);

--
=======
  `card_no` varchar(255) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
-- Indexes for dumped tables
--

--
-- Indexes for table `bills`
--
ALTER TABLE `bills`
<<<<<<< HEAD
  ADD PRIMARY KEY (`bill_id`),
  ADD KEY `cus_id_fk` (`cus_id`);
=======
  ADD PRIMARY KEY (`bill_id`);
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`e_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
<<<<<<< HEAD
  ADD PRIMARY KEY (`pay_id`),
  ADD KEY `cus_id_fk` (`cus_id`),
  ADD KEY `bill_id_fk` (`bill_id`);
=======
  ADD PRIMARY KEY (`pay_id`);
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bills`
--
ALTER TABLE `bills`
<<<<<<< HEAD
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
=======
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT;
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
<<<<<<< HEAD
  MODIFY `cus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
=======
  MODIFY `cus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
<<<<<<< HEAD
  MODIFY `e_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
=======
  MODIFY `e_id` int(11) NOT NULL AUTO_INCREMENT;
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
<<<<<<< HEAD
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bills`
--
ALTER TABLE `bills`
  ADD CONSTRAINT `cus_id_fk_2` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `bill_id_fk` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cus_ibfk` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE CASCADE ON UPDATE CASCADE;
=======
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT;
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
