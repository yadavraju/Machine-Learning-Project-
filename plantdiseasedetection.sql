-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 15, 2017 at 04:01 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `plantdiseasedetection`
--

-- --------------------------------------------------------

--
-- Table structure for table `adjusted_weight_at_hidden_layer`
--

CREATE TABLE IF NOT EXISTS `adjusted_weight_at_hidden_layer` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `w1` varchar(30) NOT NULL,
  `w2` varchar(30) NOT NULL,
  `w3` varchar(30) NOT NULL,
  `w4` varchar(30) NOT NULL,
  `w5` varchar(30) NOT NULL,
  `w6` varchar(30) NOT NULL,
  `w7` varchar(30) NOT NULL,
  `w8` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=505 ;

--
-- Dumping data for table `adjusted_weight_at_hidden_layer`
--

INSERT INTO `adjusted_weight_at_hidden_layer` (`id`, `w1`, `w2`, `w3`, `w4`, `w5`, `w6`, `w7`, `w8`) VALUES
(497, '6.395520966873193', '7.596762581480637', '2.7171656306557135', '-2.6076215473552984', '8.326489630981067', '2.4524299421583335', '1.735840819018717', '0.176850238275152'),
(498, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.2'),
(499, '-6.6950036744438854', '-7.563353291755605', '1.4508203088282585', '-3.656785212111272', '-7.394196569228165', '-0.02248694040393469', '-2.123775124439981', '-2.0324769737588415'),
(500, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.2'),
(501, '3.295105337001884', '3.6209218758950037', '5.38829339135042', '2.7642004340197825', '3.7199545104906035', '3.944583890043456', '3.5535191568571003', '2.835973372045702'),
(502, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.2'),
(503, '-6.990808340886182', '-7.716552407068759', '-0.8380583717555583', '8.581815221135573', '-8.29398978982112', '5.186222442338992', '6.394086394257082', '6.382093007957899'),
(504, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.2');

-- --------------------------------------------------------

--
-- Table structure for table `adjusted_weight_at_output_layer`
--

CREATE TABLE IF NOT EXISTS `adjusted_weight_at_output_layer` (
  `w1` varchar(30) NOT NULL,
  `w2` varchar(30) NOT NULL,
  `w3` varchar(30) NOT NULL,
  `w4` varchar(30) NOT NULL,
  `w5` varchar(30) NOT NULL,
  `w6` varchar(30) NOT NULL,
  `w7` varchar(30) NOT NULL,
  `w8` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adjusted_weight_at_output_layer`
--

INSERT INTO `adjusted_weight_at_output_layer` (`w1`, `w2`, `w3`, `w4`, `w5`, `w6`, `w7`, `w8`) VALUES
('-0.31477180671787847', '0.897783074526078', '-0.014615940148438799', '0.9080293892834616', '1.0093370976602687', '0.21344632689689375', '0.04267067099384769', '0.5834154265352514');

-- --------------------------------------------------------

--
-- Table structure for table `diseasetable`
--

CREATE TABLE IF NOT EXISTS `diseasetable` (
  `disease_id` int(3) NOT NULL AUTO_INCREMENT,
  `disease_name` varchar(50) NOT NULL,
  `target_output` varchar(20) NOT NULL,
  PRIMARY KEY (`disease_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `diseasetable`
--

INSERT INTO `diseasetable` (`disease_id`, `disease_name`, `target_output`) VALUES
(1, 'golden Mosaic', '0.95'),
(2, 'Halo blight', '0.90'),
(3, 'Blast', '0.85'),
(4, 'Brown Spot', '0.80');

-- --------------------------------------------------------

--
-- Table structure for table `disease_count_table`
--

CREATE TABLE IF NOT EXISTS `disease_count_table` (
  `disease_count` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disease_count_table`
--

INSERT INTO `disease_count_table` (`disease_count`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `disease_image_count_table`
--

CREATE TABLE IF NOT EXISTS `disease_image_count_table` (
  `disease_image_count_id` int(11) NOT NULL AUTO_INCREMENT,
  `disease_image_count` int(3) NOT NULL,
  `disease_name` varchar(50) NOT NULL,
  PRIMARY KEY (`disease_image_count_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `disease_image_count_table`
--

INSERT INTO `disease_image_count_table` (`disease_image_count_id`, `disease_image_count`, `disease_name`) VALUES
(29, 8, 'golden Mosaic'),
(30, 8, 'Halo blight'),
(31, 8, 'Blast');

-- --------------------------------------------------------

--
-- Table structure for table `featuretable`
--

CREATE TABLE IF NOT EXISTS `featuretable` (
  `Feature_id` int(5) NOT NULL AUTO_INCREMENT,
  `Disease_name` varchar(50) NOT NULL,
  `bin1` varchar(15) NOT NULL,
  `bin2` varchar(15) NOT NULL,
  `bin3` varchar(15) NOT NULL,
  `bin4` varchar(15) NOT NULL,
  `bin5` varchar(15) NOT NULL,
  `bin6` varchar(15) NOT NULL,
  `bin7` varchar(15) NOT NULL,
  `bin8` varchar(15) NOT NULL,
  PRIMARY KEY (`Feature_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=314 ;

--
-- Dumping data for table `featuretable`
--

INSERT INTO `featuretable` (`Feature_id`, `Disease_name`, `bin1`, `bin2`, `bin3`, `bin4`, `bin5`, `bin6`, `bin7`, `bin8`) VALUES
(290, 'golden Mosaic', '0.596649', '0', '0.01663', '0', '0.134925', '0', '0.251796', '0'),
(291, 'golden Mosaic', '0.280335', '0', '0.000022', '0', '0.45178', '0', '0.267863', '0'),
(292, 'golden Mosaic', '0.237625', '0', '0.000769', '0', '0.455879', '0', '0.305727', '0'),
(293, 'golden Mosaic', '0.463672', '0', '0.000857', '0', '0.41979', '0', '0.115681', '0'),
(294, 'golden Mosaic', '0.463672', '0', '0.000857', '0', '0.41979', '0', '0.115681', '0'),
(295, 'golden Mosaic', '0.4896', '0', '0.000103', '0', '0.421672', '0', '0.088624', '0'),
(296, 'golden Mosaic', '0.4896', '0', '0.000103', '0', '0.421672', '0', '0.088624', '0'),
(297, 'golden Mosaic', '0.508298', '0', '0.04103', '0', '0.119316', '0', '0.331356', '0'),
(298, 'Halo blight', '0.884439', '0', '0.089252', '0', '0.003098', '0', '0.02321', '0'),
(299, 'Halo blight', '0.733355', '0', '0.170702', '0', '0.009218', '0', '0.086726', '0'),
(300, 'Halo blight', '0.88236', '0', '0.093048', '0', '0.002924', '0', '0.021668', '0'),
(301, 'Halo blight', '0.884439', '0', '0.089252', '0', '0.003098', '0', '0.02321', '0'),
(302, 'Halo blight', '0.852707', '0', '0.116964', '0', '0.003072', '0', '0.027257', '0'),
(303, 'Halo blight', '0.831793', '0', '0.13628', '0', '0.008452', '0', '0.023475', '0'),
(304, 'Halo blight', '0.91', '0', '0.049906', '0', '0.014649', '0', '0.025445', '0'),
(305, 'Halo blight', '0.88236', '0', '0.093048', '0', '0.002924', '0', '0.021668', '0'),
(306, 'Blast', '0.1744', '0', '0.144083', '0', '0.066661', '0', '0.614856', '0'),
(307, 'Blast', '0.041257', '0', '0.073552', '0', '0.015925', '0', '0.869267', '0'),
(308, 'Blast', '0.230877', '0', '0.150107', '0', '0.15901', '0', '0.460006', '0'),
(309, 'Blast', '0.075035', '0', '0.277751', '0', '0.148849', '0', '0.498366', '0'),
(310, 'Blast', '0.041947', '0', '0.083835', '0', '0.016758', '0', '0.85746', '0'),
(311, 'Blast', '0.041257', '0', '0.073552', '0', '0.015925', '0', '0.869267', '0'),
(312, 'Blast', '0.1744', '0', '0.144083', '0', '0.066661', '0', '0.614856', '0'),
(313, 'Blast', '0.041947', '0', '0.083835', '0', '0.016758', '0', '0.85746', '0');

-- --------------------------------------------------------

--
-- Table structure for table `weight_at_hidden_layer_table`
--

CREATE TABLE IF NOT EXISTS `weight_at_hidden_layer_table` (
  `input_neuron_index` int(2) NOT NULL,
  `w1` varchar(20) NOT NULL,
  `w2` varchar(20) NOT NULL,
  `w3` varchar(20) NOT NULL,
  `w4` varchar(20) NOT NULL,
  `w5` varchar(20) NOT NULL,
  `w6` varchar(20) NOT NULL,
  `w7` varchar(20) NOT NULL,
  `w8` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weight_at_hidden_layer_table`
--

INSERT INTO `weight_at_hidden_layer_table` (`input_neuron_index`, `w1`, `w2`, `w3`, `w4`, `w5`, `w6`, `w7`, `w8`) VALUES
(1, '0.62', '0.42', '0.35', '-0.12', '0.53', '0.75', '0.21', '0.82'),
(2, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.20'),
(3, '0.62', '0.42', '0.35', '-0.12', '0.53', '0.75', '0.21', '0.82'),
(4, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.20'),
(5, '0.62', '0.42', '0.35', '-0.12', '0.53', '0.75', '0.21', '0.82'),
(6, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.20'),
(7, '0.62', '0.42', '0.35', '-0.12', '0.53', '0.75', '0.21', '0.82'),
(8, '0.55', '-0.17', '0.53', '0.49', '0.76', '0.59', '0.19', '0.20');

-- --------------------------------------------------------

--
-- Table structure for table `weight_at_output_layer_table`
--

CREATE TABLE IF NOT EXISTS `weight_at_output_layer_table` (
  `w1` varchar(20) NOT NULL,
  `w2` varchar(20) NOT NULL,
  `w3` varchar(20) NOT NULL,
  `w4` varchar(20) NOT NULL,
  `w5` varchar(20) NOT NULL,
  `w6` varchar(20) NOT NULL,
  `w7` varchar(20) NOT NULL,
  `w8` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weight_at_output_layer_table`
--

INSERT INTO `weight_at_output_layer_table` (`w1`, `w2`, `w3`, `w4`, `w5`, `w6`, `w7`, `w8`) VALUES
('0.35', '0.81', '0.52', '0.71', '0.52', '0.42', '0.36', '0.65');
