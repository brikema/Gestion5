-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 12 mai 2021 à 09:41
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion5`
--

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `coursesubject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbhours` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`id`, `coursesubject`, `nbhours`) VALUES
(79, 'Français', 2),
(80, 'Enseignement moral et civique', 3),
(81, 'EPS', 2),
(82, 'Anglais', 1),
(83, 'Espagnol', 2),
(85, 'Physique chimie', 2),
(86, 'SVT', 2),
(87, 'Mathématiques', 4),
(88, 'Java', 9),
(89, 'Symfony', 12);

-- --------------------------------------------------------

--
-- Structure de la table `course_person`
--

CREATE TABLE `course_person` (
  `idPerson` int(11) NOT NULL,
  `idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `course_person`
--

INSERT INTO `course_person` (`idPerson`, `idCourse`) VALUES
(118, 80),
(118, 81),
(118, 87),
(121, 83);

-- --------------------------------------------------------

--
-- Structure de la table `mark`
--

CREATE TABLE `mark` (
  `id` int(11) NOT NULL,
  `idStudent` int(11) DEFAULT NULL,
  `idCourse` int(11) DEFAULT NULL,
  `mark` float DEFAULT NULL,
  `assessment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `mark`
--

INSERT INTO `mark` (`id`, `idStudent`, `idCourse`, `mark`, `assessment`) VALUES
(1, 158, 82, 8, 'T\'es mauvais jean'),
(2, 157, 82, 5, 'Catastrophe'),
(3, 159, 82, 11, 'Moyen! Sans plus! OSEF!'),
(4, 118, 82, 15, 'pas mal');

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(11) NOT NULL DEFAULT 4,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `subjecttaught` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `average` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `person`
--

INSERT INTO `person` (`id`, `firstname`, `lastname`, `email`, `address`, `phone`, `role`, `password`, `dateofbirth`, `subjecttaught`, `average`) VALUES
(6, 'Chaumont', 'Eric', 'e.chaumont@ensup.eu', '34 rue du général De Gaule 75001', '0641458596', 1, 'e.chaumont', NULL, NULL, NULL),
(7, 'Demaison', 'Magalie', 'm.demaison@ensup.eu', '124 avenue de Paris 75016', '0685749685', 2, 'm.demaison', NULL, NULL, NULL),
(118, 'Mark', 'Ruben', 'm.ruben@ensup.eu', '10 bis avenue du bois 41000', '0685984552', 4, 'm.ruben', '2020-10-01', NULL, 12.5),
(121, 'Pierre', 'Moulin', 'p.moulin@ensup.eu', '10 rue Jean Moulin 95630', '0601854596', 4, 'p.moulin', '0177-05-02', NULL, 19),
(157, 'Marc', 'Emmanuel', 'flavien@flavien.flavien', '4 rue du trou paumÃ©', '0412654873', 4, '1234', NULL, NULL, 0),
(158, 'Jean', 'Roulin', 'roulin@roulin.roulin', '4 boulevad', '37451', 4, '1234', NULL, NULL, 0),
(159, 'Jean', 'Poussin', 'galinette@ga.ga', '4 rue de la galinette', '0112135486', 4, 'reza', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `school`
--

CREATE TABLE `school` (
  `id` int(11) NOT NULL,
  `surname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `director` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `school`
--

INSERT INTO `school` (`id`, `surname`, `email`, `address`, `phone`, `director`) VALUES
(4, 'Ensup', 'ensup@gmail.com', '1 bis Avenue du 8 mai 1945', '0161380575', 6);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `course_person`
--
ALTER TABLE `course_person`
  ADD PRIMARY KEY (`idPerson`,`idCourse`),
  ADD KEY `fk_person_course` (`idCourse`);

--
-- Index pour la table `mark`
--
ALTER TABLE `mark`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kMarkCourse` (`idCourse`),
  ADD KEY `kMarkStudent` (`idStudent`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_person_school` (`director`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT pour la table `mark`
--
ALTER TABLE `mark`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=161;

--
-- AUTO_INCREMENT pour la table `school`
--
ALTER TABLE `school`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `course_person`
--
ALTER TABLE `course_person`
  ADD CONSTRAINT `fk_course_person` FOREIGN KEY (`idPerson`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_person_course` FOREIGN KEY (`idCourse`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `mark`
--
ALTER TABLE `mark`
  ADD CONSTRAINT `kMarkCourse` FOREIGN KEY (`idCourse`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `kMarkStudent` FOREIGN KEY (`idStudent`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `school`
--
ALTER TABLE `school`
  ADD CONSTRAINT `fk_person_school` FOREIGN KEY (`director`) REFERENCES `person` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
