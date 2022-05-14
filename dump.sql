-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 14, 2022 at 03:27 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `AntiG`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom`) VALUES
(1, 'boulangerie'),
(2, 'patisserie'),
(3, 'boisson'),
(4, 'viande'),
(5, 'poisson'),
(6, 'produit laitier'),
(7, 'fruit'),
(8, 'légume'),
(9, 'féculent'),
(10, 'asiatique'),
(11, 'brasserie'),
(12, 'cafétaria'),
(13, 'glacier'),
(14, 'pizzeria'),
(15, 'restauration rapide'),
(16, 'traiteur'),
(17, 'restaurant gastronomique'),
(18, 'grande surface'),
(19, 'confiserie'),
(20, 'boulangerie'),
(21, 'patisserie'),
(22, 'charcuterie'),
(23, 'poissonerie'),
(24, 'boucherie'),
(25, 'épicerie');

-- --------------------------------------------------------

--
-- Table structure for table `commercant`
--

CREATE TABLE `commercant` (
  `id_commercant` int(11) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `commercant`
--

INSERT INTO `commercant` (`id_commercant`, `localisation`, `nom`) VALUES
(1, 'Tours', 'E.Leclerc'),
(2, 'Issoudun', 'Panier Sympa'),
(3, 'Orléans', 'Pat à pain'),
(4, 'Bourges', 'Boucherie Dougy'),
(5, 'Châteauroux', 'Terre Et Mer'),
(6, 'Issoudun', 'Le Sultan'),
(7, 'Bordeaux', 'La Cognette'),
(8, 'Marseille', 'Glace & Co'),
(9, 'Nice', 'Le kiosque'),
(10, 'Lyon', 'McDonalds'),
(11, 'Brest', 'Marie Blachère'),
(12, 'Angers', 'Sushi & Co'),
(13, 'Nantes', 'Nabab Kebab'),
(14, 'Nancy', 'Burger King'),
(15, 'Tours', 'Dragon dAsie'),
(16, 'Tours', 'KFC'),
(17, 'Tours', 'Auchan'),
(18, 'Tours', 'Bonbon & Co');

-- --------------------------------------------------------

--
-- Table structure for table `commercant_has_categorie`
--

CREATE TABLE `commercant_has_categorie` (
  `id_categorie` int(11) NOT NULL,
  `id_commercant` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `panier`
--

CREATE TABLE `panier` (
  `id_panier` int(11) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  `id_commercant` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_produit` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `panier`
--

INSERT INTO `panier` (`id_panier`, `localisation`, `id_categorie`, `id_commercant`, `id_user`, `id_produit`) VALUES
(1, 'Tours', 6, 1, NULL, NULL),
(2, 'Loches', 8, 1, NULL, NULL),
(3, 'Issoudun', 15, 2, NULL, NULL),
(4, 'Bourges', 22, 4, NULL, NULL),
(5, 'Orléans', 20, 3, NULL, NULL),
(6, 'Bordeaux', 4, 7, NULL, NULL),
(7, 'Nantes', 15, 13, NULL, NULL),
(8, 'Angers', 10, 12, NULL, NULL),
(9, 'Nancy', 15, 14, NULL, NULL),
(10, 'Brest', 21, 11, NULL, NULL),
(11, 'Marseille', 19, 8, NULL, NULL),
(12, 'Tours', 5, 17, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `nom`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `id_role` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `email`, `nom`, `password`, `prenom`, `id_role`) VALUES
(2, 'carangeotalexis@gmail.com', 'Carangeot', '$2a$10$/CJqk7rgYzgw2RdIr.E6/eSVcye5JCHBCx6OO8MoeUWJNAF.7pANy', 'Alexis', 1),
(3, 'jean.pornet@gmail.com', 'Pornet', '$2a$10$4wojDDR6L/65ifRkhOgwVOMmCRXONYyn5RRmFGrcyG.yqnxtLunNe', 'Jean', 2),
(5, 'alexcrg36@gmail.com', 'Carangeot', '$2a$10$wpEfyLrOOXphXUOoChy2a.vVQtf1Q/WpY1TwBYMw0wyTlfs4ow9U6', 'Alexis', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Indexes for table `commercant`
--
ALTER TABLE `commercant`
  ADD PRIMARY KEY (`id_commercant`);

--
-- Indexes for table `commercant_has_categorie`
--
ALTER TABLE `commercant_has_categorie`
  ADD KEY `FKc18c4yskf8vbwod1dw27h5jq4` (`id_commercant`),
  ADD KEY `FK1am7ka44a3e400hhmanja9f1o` (`id_categorie`);

--
-- Indexes for table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id_panier`),
  ADD KEY `FKmdt9k0wwobxrlytwtyuwlwlu9` (`id_categorie`),
  ADD KEY `FK8c49td4thke9k9bx9mfb9f0y0` (`id_commercant`),
  ADD KEY `FKt4gx5xcjpu9pmbj1cuvbm4yln` (`id_user`),
  ADD KEY `FKqchc88fgo8wu6ot32jxh1e1cy` (`id_produit`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD KEY `FK6njoh3pti5jnlkowken3r8ttn` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `commercant`
--
ALTER TABLE `commercant`
  MODIFY `id_commercant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `panier`
--
ALTER TABLE `panier`
  MODIFY `id_panier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
