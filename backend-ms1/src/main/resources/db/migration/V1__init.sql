-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 18 mai 2023 à 22:51
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.0.28

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `event`
--

-- --------------------------------------------------------

--
-- Structure de la table `bloc_operatoir`
--

CREATE TABLE `bloc_operatoir` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bloc_operatoir`
--

INSERT INTO `bloc_operatoir` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `reference`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(10, '', '2023-05-15 15:11:43', '', NULL, 'blocOp1', 'blocOp1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, '', '2023-05-15 15:11:43', '', NULL, 'blocOp2', 'blocOp2', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '', '2023-05-15 15:11:43', '', NULL, 'blocOp3', 'blocOp3', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `bloc_operatoir_seq`
--

CREATE TABLE `bloc_operatoir_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bloc_operatoir_seq`
--

INSERT INTO `bloc_operatoir_seq` (`next_val`) VALUES
(19),
(19);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `evenement_end` datetime DEFAULT NULL,
  `evenement_start` datetime DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `evenement_state` bigint(20) DEFAULT NULL,
  `salle` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `description`, `evenement_end`, `evenement_start`, `reference`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `evenement_state`, `salle`) VALUES
(1, '', '2023-05-16 11:39:20', '', NULL, 'desc 2', NULL, NULL, 'EV-2_S-1_B-2_05-15-2023', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(2, '', '2023-05-16 11:39:29', '', NULL, 'desc 2', NULL, NULL, 'EVNNN-2_S-1_B-2_05-15-2023', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(3, '', '2023-05-16 11:39:33', '', NULL, 'desc 2', NULL, NULL, 'FST-2_S-1_B-2_05-15-2023', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 14),
(4, '', '2023-05-16 11:39:42', '', NULL, 'desc 2', NULL, NULL, 'EV-2_S-1_B-2_05-15-2023', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15),
(5, '', '2023-05-16 11:39:45', '', NULL, 'desc 2', NULL, NULL, 'NONO-2_S-1_B-2_05-15-2023', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 16);

-- --------------------------------------------------------

--
-- Structure de la table `evenement_seq`
--

CREATE TABLE `evenement_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement_seq`
--

INSERT INTO `evenement_seq` (`next_val`) VALUES
(6),
(6);

-- --------------------------------------------------------

--
-- Structure de la table `evenement_state`
--

CREATE TABLE `evenement_state` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement_state`
--

INSERT INTO `evenement_state` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `reference`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, '', '2023-05-15 15:08:57', '', NULL, 'programmer', 'programmer', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, '', '2023-05-15 15:08:57', '', NULL, 'en cours', 'en cours', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, '', '2023-05-15 15:08:57', '', NULL, 'cloturer', 'cloturer', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `evenement_state_seq`
--

CREATE TABLE `evenement_state_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement_state_seq`
--

INSERT INTO `evenement_state_seq` (`next_val`) VALUES
(7),
(7);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(23),
(23),
(23);

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `permission`
--

INSERT INTO `permission` (`id`, `name`) VALUES
(1, 'EvenementState.edit'),
(2, 'EvenementState.list'),
(3, 'EvenementState.view'),
(4, 'EvenementState.add'),
(5, 'EvenementState.delete'),
(6, 'Evenement.edit'),
(7, 'Evenement.list'),
(8, 'Evenement.view'),
(9, 'Evenement.add'),
(10, 'Evenement.delete'),
(11, 'Salle.edit'),
(12, 'Salle.list'),
(13, 'Salle.view'),
(14, 'Salle.add'),
(15, 'Salle.delete'),
(16, 'BlocOperatoir.edit'),
(17, 'BlocOperatoir.list'),
(18, 'BlocOperatoir.view'),
(19, 'BlocOperatoir.add'),
(20, 'BlocOperatoir.delete');

-- --------------------------------------------------------

--
-- Structure de la table `roles_permissions`
--

CREATE TABLE `roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `roles_permissions`
--

INSERT INTO `roles_permissions` (`role_id`, `permission_id`) VALUES
(21, 1),
(21, 2),
(21, 3),
(21, 4),
(21, 5),
(21, 6),
(21, 7),
(21, 8),
(21, 9),
(21, 10),
(21, 11),
(21, 12),
(21, 13),
(21, 14),
(21, 15),
(21, 16),
(21, 17),
(21, 18),
(21, 19),
(21, 20);

-- --------------------------------------------------------

--
-- Structure de la table `role_app`
--

CREATE TABLE `role_app` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `role_app`
--

INSERT INTO `role_app` (`id`, `authority`, `created_at`, `updated_at`) VALUES
(21, 'ROLE_ADMIN', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `bloc_operatoir` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `reference`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `bloc_operatoir`) VALUES
(12, '', '2023-05-16 11:39:20', 'admin', '2023-05-18 20:12:51', 'salle3-B1', 'salle3-B1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10),
(13, '', '2023-05-16 11:39:29', 'admin', '2023-05-18 20:12:38', 'salle2-B1', 'salle2-B1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10),
(14, '', '2023-05-16 11:39:33', 'admin', '2023-05-18 20:12:21', 'salle2-B2', 'salle2-B2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11),
(15, '', '2023-05-16 11:39:42', 'admin', '2023-05-18 20:12:11', 'salle1-B2', 'salle1-B2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11),
(16, '', '2023-05-16 11:39:45', 'admin', '2023-05-18 20:12:03', 'salle1-B1', 'salle1-B1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10);

-- --------------------------------------------------------

--
-- Structure de la table `salle_seq`
--

CREATE TABLE `salle_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `salle_seq`
--

INSERT INTO `salle_seq` (`next_val`) VALUES
(17),
(17);

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(22, 21);

-- --------------------------------------------------------

--
-- Structure de la table `user_app`
--

CREATE TABLE `user_app` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_changed` bit(1) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user_app`
--

INSERT INTO `user_app` (`id`, `created_by`, `created_on`, `updated_by`, `updated_on`, `account_non_expired`, `account_non_locked`, `created_at`, `credentials_non_expired`, `email`, `enabled`, `nom`, `password`, `password_changed`, `prenom`, `updated_at`, `username`) VALUES
(22, NULL, '2023-05-15 15:11:44', NULL, NULL, b'1', b'1', '2023-05-15 15:11:44', b'1', 'admin', b'1', 'admin', '$2a$10$J14.XzuWna6IRmEcrnq2Re4RcUWDsWhS.THG42lbyoSdR.ciU7j2y', b'0', 'admin', NULL, 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bloc_operatoir`
--
ALTER TABLE `bloc_operatoir`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKahomuu3nxn2bvcg9o7qjndae9` (`evenement_state`),
  ADD KEY `FKkv1hyslx0yuw2dtpl625sp2s9` (`salle`);

--
-- Index pour la table `evenement_state`
--
ALTER TABLE `evenement_state`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `roles_permissions`
--
ALTER TABLE `roles_permissions`
  ADD KEY `FKboeuhl31go7wer3bpy6so7exi` (`permission_id`),
  ADD KEY `FK3q3rt3at2wf4ooe7npa3et6yb` (`role_id`);

--
-- Index pour la table `role_app`
--
ALTER TABLE `role_app`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK65ds3j7oknx0ktrtmw5i6b36a` (`bloc_operatoir`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FK4e8pdqeupv69eukb2bvy2ftbd` (`role_id`),
  ADD KEY `FK50gpsre6oxwwqf394f8wov1yf` (`user_id`);

--
-- Index pour la table `user_app`
--
ALTER TABLE `user_app`
  ADD PRIMARY KEY (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
