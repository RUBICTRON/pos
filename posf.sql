-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-0ubuntu0.17.10.1 - (Ubuntu)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for php-pos
CREATE DATABASE IF NOT EXISTS `php-pos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `php-pos`;

-- Dumping structure for table php-pos.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(50) NOT NULL,
  `contactNo` varchar(50) NOT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table php-pos.customer: ~3 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
REPLACE INTO `customer` (`customerId`, `customerName`, `contactNo`) VALUES
	(0, 'admin', '07777123456'),
	(1, 'Suranga', '0777123456'),
	(17, 'Upul', '0778978758');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table php-pos.item
CREATE TABLE IF NOT EXISTS `item` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitPrice` double NOT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table php-pos.item: ~2 rows (approximately)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
REPLACE INTO `item` (`itemId`, `itemName`, `quantity`, `unitPrice`) VALUES
	(7, 'asasas', 9, 1),
	(10, 'Rathu Kakulu', 15, 250);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table php-pos.orderDetails
CREATE TABLE IF NOT EXISTS `orderDetails` (
  `orderId` int(11) NOT NULL,
  `itemId` int(11) DEFAULT NULL,
  `quentity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table php-pos.orderDetails: ~2 rows (approximately)
/*!40000 ALTER TABLE `orderDetails` DISABLE KEYS */;
REPLACE INTO `orderDetails` (`orderId`, `itemId`, `quentity`) VALUES
	(1, 4, 1),
	(2, 1, 34);
/*!40000 ALTER TABLE `orderDetails` ENABLE KEYS */;

-- Dumping structure for table php-pos.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `orderId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `orders_customer_customerId_fk` (`customerId`),
  CONSTRAINT `orders_customer_customerId_fk` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table php-pos.orders: ~1 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
REPLACE INTO `orders` (`orderId`, `customerId`, `date`, `total`) VALUES
	(1, 0, '2018-02-05', 198);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table php-pos.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `usertype` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  `customerId` int(11) NOT NULL DEFAULT '13',
  PRIMARY KEY (`username`),
  KEY `FK_users_customer` (`customerId`),
  CONSTRAINT `FK_users_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table php-pos.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`username`, `password`, `usertype`, `image`, `customerId`) VALUES
	('customer', '$2y$10$0XX5v.gOx1OOmg5meNjawuU1yII86QAc0bNwioX5AharUpRpIQIN.', 'customer', 'user.png', 1),
	('rubictron', '$2y$10$0XX5v.gOx1OOmg5meNjawuU1yII86QAc0bNwioX5AharUpRpIQIN.', 'admin', 'logo.jpg', 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping database structure for posf
CREATE DATABASE IF NOT EXISTS `posf` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `posf`;

-- Dumping structure for table posf.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table posf.customer: ~5 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
REPLACE INTO `customer` (`customerId`, `name`, `contact`, `salary`) VALUES
	('C0001', 'wersdfghj', '7412', 500),
	('C0003', 'asdfg', 'asdfgh', NULL),
	('C0004', 'sdfg', 'dfghj', NULL),
	('C0005', 'qwerty', 'dfghjml', NULL),
	('C0077', 'asd', 'asd', 12);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table posf.item
CREATE TABLE IF NOT EXISTS `item` (
  `itemId` varchar(5) NOT NULL,
  `name` varchar(15) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table posf.item: ~5 rows (approximately)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
REPLACE INTO `item` (`itemId`, `name`, `quantity`, `unitPrice`) VALUES
	('I0001', 'Soap', 806, 12),
	('I0002', 'Soap', 126, 12),
	('I0006', 'aaaaaa', 70, 8),
	('I0007', 'sssss', 300, 1),
	('I0009', 'Soap', 50, 127);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table posf.login
CREATE TABLE IF NOT EXISTS `login` (
  `userName` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `accessLevel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table posf.login: ~2 rows (approximately)
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
REPLACE INTO `login` (`userName`, `password`, `accessLevel`) VALUES
	('admin', 'admin', 1),
	('user', 'user', 2);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping structure for table posf.orderDetails
CREATE TABLE IF NOT EXISTS `orderDetails` (
  `orderId` varchar(5) NOT NULL,
  `itemId` varchar(5) NOT NULL,
  `quentity` int(5) NOT NULL,
  PRIMARY KEY (`orderId`,`itemId`),
  KEY `fk_item_d` (`itemId`),
  CONSTRAINT `fk_item_d` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_d` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table posf.orderDetails: ~17 rows (approximately)
/*!40000 ALTER TABLE `orderDetails` DISABLE KEYS */;
REPLACE INTO `orderDetails` (`orderId`, `itemId`, `quentity`) VALUES
	('ODR44', 'I0002', 1),
	('ODR56', 'I0001', 1),
	('ODR56', 'I0002', 3),
	('ODR88', 'I0001', 1),
	('ODR89', 'I0001', 12),
	('ODR89', 'I0002', 32),
	('ODR90', 'I0001', 12),
	('ODR90', 'I0002', 32),
	('ODR91', 'I0001', 12),
	('ODR91', 'I0002', 1),
	('ODR92', 'I0001', 4),
	('ODR93', 'I0001', 1),
	('ODR94', 'I0001', 1),
	('ODR95', 'I0001', 1),
	('ODR96', 'I0001', 1),
	('ODR96', 'I0006', 2),
	('ODR96', 'I0007', 5);
/*!40000 ALTER TABLE `orderDetails` ENABLE KEYS */;

-- Dumping structure for table posf.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `orderId` varchar(5) NOT NULL,
  `date` date NOT NULL,
  `customerId` varchar(5) NOT NULL,
  `totalPrice` double DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_order_cus` (`customerId`),
  CONSTRAINT `fk_order_cus` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table posf.orders: ~9 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
REPLACE INTO `orders` (`orderId`, `date`, `customerId`, `totalPrice`) VALUES
	('ODR44', '2018-01-02', 'C0001', 12),
	('ODR56', '2018-01-31', 'C0001', 48),
	('ODR88', '2018-01-18', 'C0001', 12),
	('ODR89', '2018-01-01', 'C0001', 528),
	('ODR90', '2018-01-01', 'C0001', 528),
	('ODR91', '2018-01-01', 'C0001', 156),
	('ODR92', '2018-01-02', 'C0001', 48),
	('ODR93', '2018-02-05', 'C0001', 12),
	('ODR94', '2018-02-06', 'C0001', 12),
	('ODR95', '2018-02-01', 'C0001', 12),
	('ODR96', '2018-02-07', 'C0001', 33);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
