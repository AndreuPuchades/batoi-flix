-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 06-06-2023 a las 16:57:33
-- Versión del servidor: 10.6.4-MariaDB-1:10.6.4+maria~focal
-- Versión de PHP: 7.4.3-4ubuntu2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `batoiCine`
--
CREATE DATABASE IF NOT EXISTS `batoiCine` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `batoiCine`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actores`
--

CREATE TABLE `actores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `actores`
--

INSERT INTO `actores` (`id`, `nombre`) VALUES
(1, 'Ben Affleck'),
(2, ' Bryan Cranston'),
(3, ' Alan Arkin'),
(4, ' John Goodman'),
(5, 'Adam Sandler'),
(6, ' Drew Barrymore'),
(7, ' Kevin Nealon'),
(8, ' Terry Crews'),
(9, 'Kevin James'),
(10, ' Salma Hayek'),
(11, ' Henry Winkler'),
(12, ' Greg de_DEn'),
(13, 'Tim Allen'),
(14, ' Rene Russo'),
(15, ' Stanley Tucci'),
(16, ' Tom Sizemore'),
(17, 'Anne Hathaway'),
(18, ' Julie Andrews'),
(19, ' Hector Elizondo'),
(20, ' John Rhys-Davies'),
(21, 'Jason Segel'),
(22, ' Amy Adams'),
(23, ' Chris Cooper'),
(24, ' Rashida Jones'),
(25, 'Bill Bailey'),
(26, ' Anna Chancellor'),
(27, ' Warwick Davis'),
(28, ' Yasiin Bey'),
(29, 'Meryl Streep'),
(30, ' Chris Messina'),
(31, 'Derek Luke'),
(32, ' Michael Ealy'),
(33, ' Laz Alonso'),
(34, ' Omar Benson Miller'),
(35, 'Mark Rylance'),
(36, ' Ruby Barnhill'),
(37, ' Penelope Wilton'),
(38, ' Jemaine Clement'),
(39, 'Bruce Willis'),
(40, ' Haley Joel Osment'),
(41, ' Toni Collette'),
(42, ' Olivia Williams'),
(43, 'Katherine Heigl'),
(44, ' Jason OMara'),
(45, ' Daniel Sunjata'),
(46, ' John Leguizamo'),
(47, 'Cameron Diaz'),
(48, ' Leslie Mann'),
(49, ' Nikolaj Coster-Waldau'),
(50, ' Don Johnson'),
(51, 'Amanda Seyfried'),
(52, ' Gary Oldman'),
(53, ' Billy Burke'),
(54, ' Shiloh Fernandez'),
(55, 'Josh Lucas'),
(56, ' Jessica Biel'),
(57, ' Jamie Foxx'),
(58, ' Sam Shepard'),
(59, 'Tobey Maguire'),
(60, ' Willem Dafoe'),
(61, ' Kirsten Dunst'),
(62, ' James Franco'),
(63, 'Piper Perabo'),
(64, ' Adam Garcia'),
(65, ' Maria Bello'),
(66, 'Julia Roberts'),
(67, ' Nicolas Cage'),
(68, ' Meryl Streep'),
(69, ' Paul Giamatti'),
(70, 'Jack Nicholson'),
(71, ' Morgan Freeman'),
(72, ' Sean Hayes'),
(73, ' Beverly Todd'),
(74, 'Ewan McGregor'),
(75, ' Jon Bernthal'),
(76, ' Tim Preece'),
(77, ' Jim Belushi'),
(78, 'James Franco'),
(79, ' Seth Rogen'),
(80, ' Lizzy Caplan'),
(81, ' Randall Park'),
(82, 'Gerard Butler'),
(83, ' Jennifer Aniston'),
(84, ' Gio Perez'),
(85, ' Joel Marsh Garland'),
(86, 'Denzel Washington'),
(87, ' Ethan Hawke'),
(88, ' Scott Glenn'),
(89, ' Tom Berenger'),
(90, 'Jet Li'),
(91, ' Bob Hoskins'),
(92, ' Kerry Condon'),
(93, 'Will Smith'),
(94, ' Kevin Kline'),
(95, ' Kenneth Branagh'),
(96, 'Robert De Niro'),
(97, ' Edward Burns'),
(98, ' Kelsey Grammer'),
(99, ' Avery Brooks'),
(100, 'Jonah Hill'),
(101, ' Channing Tatum'),
(102, ' Brie Larson'),
(103, ' Dave Franco'),
(104, 'Eminem'),
(105, ' Kim Basinger'),
(106, ' Mekhi Phifer'),
(107, ' Brittany Murphy'),
(108, 'Paul Walker'),
(109, ' Bruce Greenwood'),
(110, ' Moon Bloodgood'),
(111, ' Wendy Crewson'),
(112, 'Heath Ledger'),
(113, ' Rufus Sewell'),
(114, ' Shannyn Sossamon'),
(115, ' Paul Bettany'),
(116, 'Carter Jenkins'),
(117, ' Austin Butler'),
(118, ' Ashley Tisdale'),
(119, ' Ashley Boettcher'),
(120, 'Ben Stiller'),
(121, ' Philip Seymour Hoffman'),
(122, ' Debra Messing'),
(123, ' Sigourney Weaver'),
(124, ' Alan Rickman'),
(125, ' Tony Shalhoub'),
(126, 'Christian Bale'),
(127, ' Bradley Cooper'),
(128, ' Jeremy Renner'),
(129, 'Vin Diesel'),
(130, ' Michelle Yeoh'),
(131, ' Mélanie Thierry'),
(132, ' Lambert Wilson'),
(133, 'Nicolas Cage'),
(134, ' Shahkrit Yamnarm'),
(135, ' Charlie Yeung'),
(136, ' Panward Hemmanee'),
(137, 'Kristen Stewart'),
(138, ' Robert Pattinson'),
(139, ' Taylor Lautner'),
(140, ' Peter Facinelli'),
(141, 'Caroline Aaron'),
(142, ' Brenda Ballard'),
(143, ' Will Beinbrink'),
(144, ' Samuel L. Jackson'),
(145, ' Kim Staunton'),
(146, 'Zac Efron'),
(147, ' Charlie Tahan'),
(148, ' Amanda Crew'),
(149, ' Augustus Prew'),
(150, 'Steve Martin'),
(151, ' Bonnie Hunt'),
(152, ' Piper Perabo'),
(153, ' Tom Welling'),
(154, 'Samuel L. Jackson'),
(155, ' Rob Brown'),
(156, ' Robert Richard'),
(157, ' Rick Gonzalez'),
(158, 'Kris Kristofferson'),
(159, ' Christopher Walken'),
(160, ' John Hurt'),
(161, ' Sam Waterston'),
(162, 'Antony Acker'),
(163, ' Mark Barrett'),
(164, ' Richard Bellos'),
(165, ' Suzanne Bianqui'),
(166, 'Tommy Lee Jones'),
(167, ' Ashley Judd'),
(168, ' Benjamin Weir'),
(169, ' Jay Brazeau'),
(170, 'Jim Carrey'),
(171, ' Jeff Daniels'),
(172, ' Rob Riggle'),
(173, ' Laurie Holden'),
(174, ' Joel Edgerton'),
(175, ' John Turturro'),
(176, ' Aaron Paul'),
(177, 'Kenan Thompson'),
(178, ' Kyla Pratt'),
(179, ' Dania Ramirez'),
(180, ' Shedrack Anderson III'),
(181, 'Dakota Johnson'),
(182, ' Jamie Dornan'),
(183, ' Jennifer Ehle'),
(184, ' Eloise Mumford'),
(185, 'Ming-Na Wen'),
(186, ' Alec Baldwin'),
(187, ' Ving Rhames'),
(188, ' Steve Buscemi'),
(189, 'Charlie Sheen'),
(190, ' Hilary Duff'),
(191, ' Eva Longoria'),
(192, ' Wayne Brady'),
(193, 'Leonardo DiCaprio'),
(194, ' Tom Hardy'),
(195, ' Domhnall Gleeson'),
(196, ' Will Poulter'),
(197, 'Johnny Depp'),
(198, ' Heather Graham'),
(199, ' Ian Holm'),
(200, ' Robbie Coltrane'),
(201, 'Will Ferrell'),
(202, ' Kevin Hart'),
(203, ' Craig T. Nelson'),
(204, ' Alison Brie'),
(205, 'Jackie Chan'),
(206, ' Lee Evans'),
(207, ' Claire Forlani'),
(208, ' Julian Sands'),
(209, 'Adewale Akinnuoye-Agbaje'),
(210, ' Christopher Eccleston'),
(211, ' Grégory Fitoussi'),
(212, ' Joseph Gordon-Levitt'),
(213, 'Brenton Thwaites'),
(214, ' John Samaha'),
(215, ' Courtney Eaton'),
(216, 'Morgan Lily'),
(217, ' Trenton Rogers'),
(218, ' Michelle Carmichael'),
(219, ' Jasmine Woods'),
(220, 'Ben Kingsley'),
(221, ' Sacha Baron Cohen'),
(222, ' Asa Butterfield'),
(223, ' Chloë Grace Moretz'),
(224, 'Dong-gun Jang'),
(225, ' Kate Bosworth'),
(226, ' Geoffrey Rush'),
(227, ' Danny Huston'),
(228, 'Edward Norton'),
(229, ' Liv Tyler'),
(230, ' Tim Roth'),
(231, ' William Hurt'),
(232, 'Pierce Brosnan'),
(233, ' Sophie Marceau'),
(234, ' Robert Carlyle'),
(235, ' Denise Richards'),
(236, 'Rowan Atkinson'),
(237, ' Tasha de Vasconcelos'),
(238, ' Ben Miller'),
(239, ' Greg Wise'),
(240, 'Roger Barclay'),
(241, ' Eric Carte'),
(242, ' Rowan Atkinson'),
(243, ' Togo Igawa'),
(244, 'Brendan Fraser'),
(245, ' Josh Hutcherson'),
(246, ' Anita Briem'),
(247, ' Seth Meyers'),
(248, ' Robert Duvall'),
(249, ' Mike Ditka'),
(250, ' Kate Walsh'),
(251, 'Queen Latifah'),
(252, ' LL Cool J'),
(253, ' Timothy Hutton'),
(254, ' Giancarlo Esposito'),
(255, 'Mark Wahlberg'),
(256, ' Taylor Kitsch'),
(257, ' Emile Hirsch'),
(258, ' Ben Foster'),
(259, ' Bridget Moynahan'),
(260, ' Jared Leto'),
(261, ' Shake Tukhmanyan'),
(262, 'Bill Nighy'),
(263, ' Gregor Fisher'),
(264, ' Rory MacGregor'),
(265, ' Colin Firth'),
(266, 'Scarlett Johansson'),
(267, ' Min-sik Choi'),
(268, ' Amr Waked'),
(269, 'Sam Worthington'),
(270, ' Mandy Gonzalez'),
(271, ' William Sadler'),
(272, ' Barbara Marineau'),
(273, 'Sacha Baron Cohen'),
(274, ' Gustaf Hammarsten'),
(275, ' Clifford Bañagale'),
(276, ' Chibundu Orukwowu'),
(277, 'Dany Boon'),
(278, ' André Dussollier'),
(279, ' Yolande Moreau'),
(280, ' Dominique Pinon'),
(281, 'Matt Damon'),
(282, ' Henry Thomas'),
(283, ' Penélope Cruz'),
(284, ' Angelina Torres'),
(285, 'Sandra Bullock'),
(286, ' Michael Caine'),
(287, ' Benjamin Bratt'),
(288, ' Candice Bergen'),
(289, 'Jennifer Lopez'),
(290, ' Jane Fonda'),
(291, ' Michael Vartan'),
(292, ' Wanda Sykes'),
(293, 'Benjamin Bratt'),
(294, ' Gina Bernard Forbes'),
(295, ' Giovanna Mezzogiorno'),
(296, ' Javier Bardem'),
(297, ' Ryan Reynolds'),
(298, ' Mary Steenburgen'),
(299, ' Hugh Grant'),
(300, ' Richard McCabe'),
(301, ' Rhys Ifans'),
(302, ' Isla Fisher'),
(303, ' Abigail Breslin'),
(304, ' Ned Beatty'),
(305, 'Phil Daniels'),
(306, ' Lynn Ferguson'),
(307, ' Mel Gibson'),
(308, ' Tony Haygarth'),
(309, 'Kate Winslet'),
(310, ' Leonardo DiCaprio'),
(311, ' Christopher Fitzgerald'),
(312, ' Jonathan Roumie'),
(313, 'Ice Cube'),
(314, ' Tika Sumpter'),
(315, 'Blake Lively'),
(316, ' Aaron Taylor-Johnson'),
(317, ' Jana Banker'),
(318, 'Anna Faris'),
(319, ' Regina Hall'),
(320, ' Craig Bierko'),
(321, ' Bill Pullman'),
(322, 'Pamela Anderson'),
(323, ' Jenny McCarthy'),
(324, ' Marny Eng'),
(325, ' Charlie Sheen'),
(326, 'Liev Schreiber'),
(327, ' Beth Toussaint'),
(328, ' Roger Jackson'),
(329, ' Kelly Rutherford'),
(330, ' Viggo Mortensen'),
(331, ' Dominic West'),
(332, ' Elizabeth Perkins'),
(333, 'Sean Connery'),
(334, ' F. Murray Abraham'),
(335, ' Anna Paquin'),
(336, 'Yun-Fat Chow'),
(337, ' Li Gong'),
(338, ' Jay Chou'),
(339, ' Ye Liu'),
(340, 'Evan Rachel Wood'),
(341, ' Jim Sturgess'),
(342, ' Joe Anderson'),
(343, ' Dana Fuchs'),
(344, 'Milla Jovovich'),
(345, ' Oded Fehr'),
(346, ' Ali Larter'),
(347, ' Iain Glen'),
(348, 'Lillian Adams'),
(349, ' Herbert W. Ankrom'),
(350, ' Bryan Anthony'),
(351, ' Christina Applegate'),
(352, 'Kate Beckinsale'),
(353, ' Scott Speedman'),
(354, ' Tony Curran'),
(355, ' Derek Jacobi'),
(356, 'Richard Gere'),
(357, ' David Eigenberg'),
(358, ' Bob Tracey'),
(359, ' Ron Emanuel'),
(360, 'Antonio Banderas'),
(361, ' Carla Gugino'),
(362, ' Alexa PenaVega'),
(363, ' Daryl Sabara'),
(364, 'John Cleese'),
(365, ' Jack Black'),
(366, ' Zahf Paroo'),
(367, ' Stacey Scowley'),
(368, 'Patrick Wilson'),
(369, ' Vera Farmiga'),
(370, ' Madison Wolfe'),
(371, ' Frances OConnor'),
(372, ' Emma Stone'),
(373, ' Catherine Keener'),
(374, ' Melissa McCarthy'),
(375, ' Demián Bichir'),
(376, ' Marlon Wayans'),
(377, 'Eric Bana'),
(378, ' Jennifer Connelly'),
(379, ' Sam Elliott'),
(380, ' Josh Lucas'),
(381, 'Jason Statham'),
(382, ' Tony Goldwyn'),
(383, ' Donald Sutherland'),
(384, 'Nathan Lane'),
(385, ' Matthew Broderick'),
(386, ' Uma Thurman'),
(387, ' Will Ferrell'),
(388, 'Jesse Eisenberg'),
(389, ' Rooney Mara'),
(390, ' Bryan Barter'),
(391, ' Dustin Fitzsimons'),
(392, 'Patricia Clarkson'),
(393, ' Beau Daniels'),
(394, ' Benicio Del Toro'),
(395, ' Dale Dickey'),
(396, 'Malin Akerman'),
(397, ' Billy Crudup'),
(398, ' Matthew Goode'),
(399, ' Jackie Earle Haley'),
(400, ' Denzel Washington'),
(401, ' John Heard'),
(402, 'Susan Sarandon'),
(403, ' Tommy Lee Jones'),
(404, ' Mary-Louise Parker'),
(405, ' Anthony LaPaglia'),
(406, 'Harrison Ford'),
(407, ' Anne Archer'),
(408, ' Patrick Bergin'),
(409, ' Sean Bean'),
(410, 'Wesley Snipes'),
(411, ' Stephen Dorff'),
(412, ' Kris Kristofferson'),
(413, ' NBushe Wright'),
(414, ' Ice Cube'),
(415, ' Jon Voight'),
(416, ' Eric Stoltz'),
(417, 'Sylvester Stallone'),
(418, ' Sharon Stone'),
(419, ' James Woods'),
(420, ' Rod Steiger'),
(421, 'Kevin Costner'),
(422, ' Cheech Marin'),
(423, 'Lucille Ball'),
(424, ' Henry Fonda'),
(425, ' Van Johnson'),
(426, ' Louise Troy'),
(427, ' Joseph Mazzello'),
(428, ' Stephanie Sawyer'),
(429, ' David Strathairn'),
(430, 'Hal Scardino'),
(431, ' Litefoot'),
(432, ' Lindsay Crouse'),
(433, ' Richard Jenkins'),
(434, 'Francesca Annis'),
(435, ' Leonardo Cimino'),
(436, ' Brad Dourif'),
(437, ' José Ferrer'),
(438, 'Daniel Radcliffe'),
(439, ' Jessica Brown Findlay'),
(440, ' Bronson Webb'),
(441, ' James McAvoy'),
(442, 'Steven Seagal'),
(443, ' Keenen Ivory Wayans'),
(444, ' Bob Gunton'),
(445, ' Brian Cox'),
(446, 'Michael Keaton'),
(447, ' Andie MacDowell'),
(448, ' Zack Duhame'),
(449, ' Katie Schlossberg'),
(450, 'Billy Zane'),
(451, ' Kristy Swanson'),
(452, ' Treat Williams'),
(453, ' Catherine Zeta-Jones'),
(454, 'Anthony Hopkins'),
(455, ' Joan Allen'),
(456, ' Powers Boothe'),
(457, ' Ed Harris'),
(458, 'Treat Williams'),
(459, ' Famke Janssen'),
(460, ' Anthony Heald'),
(461, ' Kevin J. OConnor'),
(462, 'Mel Blanc'),
(463, ' Don Brodie'),
(464, ' Walter Catlett'),
(465, ' Marion Darlington'),
(466, ' Linda Hamilton'),
(467, ' Stephen Lang'),
(468, ' Sela Ward'),
(469, ' Julianne Moore'),
(470, ' Richard Crenna'),
(471, ' Charles Napier'),
(472, ' Steven Berkoff'),
(473, 'Kevin Bacon'),
(474, ' Robert De Niro'),
(475, ' Ron Eldard'),
(476, 'Demi Moore'),
(477, ' Anne Heche'),
(478, 'Tom Cruise'),
(479, ' Jeanne Tripplehorn'),
(480, ' Gene Hackman'),
(481, ' Hal Holbrook'),
(482, 'Eddie Murphy'),
(483, ' Robin Givens'),
(484, ' Halle Berry'),
(485, ' David Alan Grier'),
(486, 'Elizabeth Taylor'),
(487, ' Richard Burton'),
(488, ' Rex Harrison'),
(489, ' Pamela Brown'),
(490, 'Barbra Streisand'),
(491, ' Jeff Bridges'),
(492, ' Lauren Bacall'),
(493, ' George Segal'),
(494, 'Timothy Dalton'),
(495, ' Carey Lowell'),
(496, ' Robert Davi'),
(497, ' Talisa Soto'),
(498, 'Bob Hoskins'),
(499, ' Dennis Hopper'),
(500, ' Samantha Mathis'),
(501, 'Ralph Macchio'),
(502, ' Pat Morita'),
(503, ' Elisabeth Shue'),
(504, ' Martin Kove'),
(505, 'Michael J. Fox'),
(506, ' Christopher Lloyd'),
(507, ' Lea Thompson'),
(508, ' Thomas F. Wilson'),
(509, 'Matthew McConaughey'),
(510, ' Sandra Bullock'),
(511, ' Kevin Spacey'),
(512, 'Tom Hanks'),
(513, ' Geena Davis'),
(514, ' Lori Petty'),
(515, ' Madonna'),
(516, 'Gary Oldman'),
(517, ' Winona Ryder'),
(518, ' Anthony Hopkins'),
(519, ' Keanu Reeves'),
(520, 'Jessie Buckley'),
(521, ' Amanda Drew'),
(522, ' Ben Miles'),
(523, 'Aziz Ansari'),
(524, ' Noel Wells'),
(525, ' Eric Wareheim'),
(526, ' Lena Waithe'),
(527, ' Kelvin Yu'),
(528, 'Sara Bareilles'),
(529, ' Renée Elise Goldsberry'),
(530, ' Busy Philipps'),
(531, 'Freddie Highmore'),
(532, ' Antonia Thomas'),
(533, ' Nicholas Gonzalez'),
(534, 'Rob McElhenney'),
(535, ' Imani Hakim'),
(536, 'Steven Yeun'),
(537, ' Andrew Rannells'),
(538, ' Chad L. Coleman'),
(539, 'Barry Jenkins (III) '),
(540, ' Adele Romanski'),
(541, ' Mark Ceryak'),
(542, ' Brad Pitt'),
(543, ' Dede Gardner'),
(544, ' Jeremy Kleiner'),
(545, ' Colson Whitehead'),
(546, ' Richard Heus'),
(547, ' Jackie Hoyt'),
(548, 'Joel Kinnaman'),
(549, ' Michael Dorman'),
(550, ' Sarah Jones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actores_producciones`
--

CREATE TABLE `actores_producciones` (
  `id_produccion` int(11) NOT NULL,
  `id_actor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `actores_producciones`
--

INSERT INTO `actores_producciones` (`id_produccion`, `id_actor`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(4, 13),
(4, 14),
(4, 15),
(4, 16),
(5, 17),
(5, 18),
(5, 19),
(5, 20),
(6, 21),
(6, 22),
(6, 23),
(6, 24),
(7, 25),
(7, 26),
(7, 27),
(7, 28),
(8, 15),
(8, 22),
(8, 29),
(8, 30),
(9, 31),
(9, 32),
(9, 33),
(9, 34),
(10, 35),
(10, 36),
(10, 37),
(10, 38),
(11, 39),
(11, 40),
(11, 41),
(11, 42),
(12, 39),
(12, 40),
(12, 41),
(12, 42),
(13, 43),
(13, 44),
(13, 45),
(13, 46),
(14, 47),
(14, 48),
(14, 49),
(14, 50),
(15, 51),
(15, 52),
(15, 53),
(15, 54),
(16, 55),
(16, 56),
(16, 57),
(16, 58),
(17, 59),
(17, 60),
(17, 61),
(17, 62),
(18, 4),
(18, 63),
(18, 64),
(18, 65),
(19, 66),
(19, 67),
(19, 68),
(19, 69),
(20, 70),
(20, 71),
(20, 72),
(20, 73),
(21, 74),
(21, 75),
(21, 76),
(21, 77),
(22, 78),
(22, 79),
(22, 80),
(22, 81),
(23, 82),
(23, 83),
(23, 84),
(23, 85),
(24, 86),
(24, 87),
(24, 88),
(24, 89),
(25, 71),
(25, 90),
(25, 91),
(25, 92),
(26, 10),
(26, 93),
(26, 94),
(26, 95),
(27, 96),
(27, 97),
(27, 98),
(27, 99),
(28, 100),
(28, 101),
(28, 102),
(28, 103),
(29, 104),
(29, 105),
(29, 106),
(29, 107),
(30, 108),
(30, 109),
(30, 110),
(30, 111),
(31, 112),
(31, 113),
(31, 114),
(31, 115),
(32, 116),
(32, 117),
(32, 118),
(32, 119),
(33, 83),
(33, 120),
(33, 121),
(33, 122),
(34, 13),
(34, 123),
(34, 124),
(34, 125),
(35, 22),
(35, 126),
(35, 127),
(35, 128),
(36, 129),
(36, 130),
(36, 131),
(36, 132),
(37, 133),
(37, 134),
(37, 135),
(37, 136),
(38, 137),
(38, 138),
(38, 139),
(38, 140),
(39, 105),
(39, 141),
(39, 142),
(39, 143),
(40, 1),
(40, 41),
(40, 144),
(40, 145),
(41, 146),
(41, 147),
(41, 148),
(41, 149),
(42, 150),
(42, 151),
(42, 152),
(42, 153),
(43, 154),
(43, 155),
(43, 156),
(43, 157),
(44, 158),
(44, 159),
(44, 160),
(44, 161),
(45, 162),
(45, 163),
(45, 164),
(45, 165),
(46, 166),
(46, 167),
(46, 168),
(46, 169),
(47, 170),
(47, 171),
(47, 172),
(47, 173),
(48, 126),
(48, 174),
(48, 175),
(48, 176),
(49, 177),
(49, 178),
(49, 179),
(49, 180),
(50, 181),
(50, 182),
(50, 183),
(50, 184),
(51, 185),
(51, 186),
(51, 187),
(51, 188),
(52, 189),
(52, 190),
(52, 191),
(52, 192),
(53, 193),
(53, 194),
(53, 195),
(53, 196),
(54, 197),
(54, 198),
(54, 199),
(54, 200),
(55, 201),
(55, 202),
(55, 203),
(55, 204),
(56, 205),
(56, 206),
(56, 207),
(56, 208),
(57, 209),
(57, 210),
(57, 211),
(57, 212),
(58, 49),
(58, 213),
(58, 214),
(58, 215),
(59, 216),
(59, 217),
(59, 218),
(59, 219),
(60, 220),
(60, 221),
(60, 222),
(60, 223),
(61, 224),
(61, 225),
(61, 226),
(61, 227),
(62, 228),
(62, 229),
(62, 230),
(62, 231),
(63, 232),
(63, 233),
(63, 234),
(63, 235),
(64, 236),
(64, 237),
(64, 238),
(64, 239),
(65, 240),
(65, 241),
(65, 242),
(65, 243),
(66, 244),
(66, 245),
(66, 246),
(66, 247),
(67, 201),
(67, 248),
(67, 249),
(67, 250),
(68, 251),
(68, 252),
(68, 253),
(68, 254),
(69, 255),
(69, 256),
(69, 257),
(69, 258),
(70, 133),
(70, 259),
(70, 260),
(70, 261),
(71, 262),
(71, 263),
(71, 264),
(71, 265),
(72, 71),
(72, 266),
(72, 267),
(72, 268),
(73, 269),
(73, 270),
(73, 271),
(73, 272),
(74, 273),
(74, 274),
(74, 275),
(74, 276),
(75, 277),
(75, 278),
(75, 279),
(75, 280),
(76, 281),
(76, 282),
(76, 283),
(76, 284),
(77, 285),
(77, 286),
(77, 287),
(77, 288),
(78, 289),
(78, 290),
(78, 291),
(78, 292),
(79, 293),
(79, 294),
(79, 295),
(79, 296),
(80, 203),
(80, 285),
(80, 297),
(80, 298),
(81, 66),
(81, 299),
(81, 300),
(81, 301),
(82, 197),
(82, 302),
(82, 303),
(82, 304),
(83, 305),
(83, 306),
(83, 307),
(83, 308),
(84, 309),
(84, 310),
(84, 311),
(84, 312),
(85, 202),
(85, 287),
(85, 313),
(85, 314),
(86, 256),
(86, 315),
(86, 316),
(86, 317),
(87, 318),
(87, 319),
(87, 320),
(87, 321),
(88, 322),
(88, 323),
(88, 324),
(88, 325),
(89, 326),
(89, 327),
(89, 328),
(89, 329),
(90, 285),
(90, 330),
(90, 331),
(90, 332),
(91, 155),
(91, 333),
(91, 334),
(91, 335),
(92, 336),
(92, 337),
(92, 338),
(92, 339),
(93, 340),
(93, 341),
(93, 342),
(93, 343),
(94, 344),
(94, 345),
(94, 346),
(94, 347),
(95, 348),
(95, 349),
(95, 350),
(95, 351),
(96, 352),
(96, 353),
(96, 354),
(96, 355),
(97, 356),
(97, 357),
(97, 358),
(97, 359),
(98, 360),
(98, 361),
(98, 362),
(98, 363),
(99, 364),
(99, 365),
(99, 366),
(99, 367),
(100, 368),
(100, 369),
(100, 370),
(100, 371),
(101, 133),
(101, 297),
(101, 372),
(101, 373),
(102, 285),
(102, 374),
(102, 375),
(102, 376),
(103, 377),
(103, 378),
(103, 379),
(103, 380),
(104, 258),
(104, 381),
(104, 382),
(104, 383),
(105, 384),
(105, 385),
(105, 386),
(105, 387),
(106, 388),
(106, 389),
(106, 390),
(106, 391),
(107, 392),
(107, 393),
(107, 394),
(107, 395),
(108, 396),
(108, 397),
(108, 398),
(108, 399),
(109, 58),
(109, 66),
(109, 400),
(109, 401),
(110, 402),
(110, 403),
(110, 404),
(110, 405),
(111, 406),
(111, 407),
(111, 408),
(111, 409),
(112, 410),
(112, 411),
(112, 412),
(112, 413),
(113, 289),
(113, 414),
(113, 415),
(113, 416),
(114, 417),
(114, 418),
(114, 419),
(114, 420),
(115, 14),
(115, 50),
(115, 421),
(115, 422),
(116, 423),
(116, 424),
(116, 425),
(116, 426),
(117, 29),
(117, 427),
(117, 428),
(117, 429),
(118, 430),
(118, 431),
(118, 432),
(118, 433),
(119, 434),
(119, 435),
(119, 436),
(119, 437),
(120, 438),
(120, 439),
(120, 440),
(120, 441),
(121, 442),
(121, 443),
(121, 444),
(121, 445),
(122, 446),
(122, 447),
(122, 448),
(122, 449),
(123, 450),
(123, 451),
(123, 452),
(123, 453),
(124, 454),
(124, 455),
(124, 456),
(124, 457),
(125, 458),
(125, 459),
(125, 460),
(125, 461),
(126, 462),
(126, 463),
(126, 464),
(126, 465),
(127, 189),
(127, 383),
(127, 466),
(127, 467),
(128, 403),
(128, 406),
(128, 468),
(128, 469),
(129, 417),
(129, 470),
(129, 471),
(129, 472),
(130, 397),
(130, 473),
(130, 474),
(130, 475),
(131, 186),
(131, 212),
(131, 476),
(131, 477),
(132, 478),
(132, 479),
(132, 480),
(132, 481),
(133, 482),
(133, 483),
(133, 484),
(133, 485),
(134, 486),
(134, 487),
(134, 488),
(134, 489),
(135, 490),
(135, 491),
(135, 492),
(135, 493),
(136, 494),
(136, 495),
(136, 496),
(136, 497),
(137, 46),
(137, 498),
(137, 499),
(137, 500),
(138, 501),
(138, 502),
(138, 503),
(138, 504),
(139, 505),
(139, 506),
(139, 507),
(139, 508),
(140, 144),
(140, 509),
(140, 510),
(140, 511),
(141, 512),
(141, 513),
(141, 514),
(141, 515),
(142, 298),
(142, 505),
(142, 506),
(142, 508),
(143, 516),
(143, 517),
(143, 518),
(143, 519),
(145, 520),
(145, 521),
(145, 522),
(146, 523),
(146, 524),
(146, 525),
(146, 526),
(146, 527),
(147, 528),
(147, 529),
(147, 530),
(148, 531),
(148, 532),
(148, 533),
(149, 334),
(149, 534),
(149, 535),
(150, 536),
(150, 537),
(150, 538),
(151, 539),
(151, 540),
(151, 541),
(151, 542),
(151, 543),
(151, 544),
(151, 545),
(151, 546),
(151, 547),
(152, 548),
(152, 549),
(152, 550);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `directores`
--

CREATE TABLE `directores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `directores`
--

INSERT INTO `directores` (`id`, `nombre`) VALUES
(1, 'Ben Affleck'),
(2, 'Frank Coraci'),
(3, 'Barry Sonnenfeld'),
(4, 'Garry Marshall'),
(5, 'James Bobin'),
(6, 'Garth Jennings'),
(7, 'Nora Ephron'),
(8, 'Spike Lee'),
(9, 'Steven Spielberg'),
(10, 'M. Night Shyamalan'),
(11, 'Julie Anne Robinson'),
(12, 'Nick Cassavetes'),
(13, 'Catherine Hardwicke'),
(14, 'Rob Cohen'),
(15, 'Sam Raimi'),
(16, 'David McNally'),
(17, 'John A. Davis'),
(18, 'Rob Reiner'),
(19, 'Roman Polanski'),
(20, 'Evan Goldberg, Seth Rogen'),
(21, 'Andy Tennant'),
(22, 'Antoine Fuqua'),
(23, 'Louis Leterrier'),
(24, 'John Herzfeld'),
(25, 'Phil Lord, Christopher Miller'),
(26, 'Curtis Hanson'),
(27, 'Frank Marshall'),
(28, 'Brian Helgeland'),
(29, 'John Schultz'),
(30, 'John Hamburg'),
(31, 'Dean Parisot'),
(32, 'David O. Russell'),
(33, 'Mathieu Kassovitz'),
(34, 'Danny Pang, Oxide Chun Pang'),
(35, 'Bill Condon'),
(36, 'David R. Ellis'),
(37, 'Roger Michell'),
(38, 'Burr Steers'),
(39, 'Shawn Levy'),
(40, 'Thomas Carter'),
(41, 'Michael Cimino'),
(42, 'Keenen Ivory Wayans'),
(43, 'Bruce Beresford'),
(44, 'Bobby Farrelly, Peter Farrelly'),
(45, 'Ridley Scott'),
(46, 'Joel Zwick'),
(47, 'Sam Taylor-Johnson'),
(48, 'Hironobu Sakaguchi, Motonori Sakakibara'),
(49, 'Lawrence Kasanoff'),
(50, 'Alejandro González Iñárritu'),
(51, 'Albert Hughes, Allen Hughes'),
(52, 'Etan Cohen'),
(53, 'Gordon Chan'),
(54, 'Stephen Sommers'),
(55, 'Alex Proyas'),
(56, 'Ken Kwapis'),
(57, 'Martin Scorsese'),
(58, 'Sngmoo Lee'),
(59, 'Michael Apted'),
(60, 'Peter Howitt'),
(61, 'Oliver Parker'),
(62, 'Eric Brevig'),
(63, 'Jesse Dylan'),
(64, 'Wayne Wang'),
(65, 'Peter Berg'),
(66, 'Andrew Niccol'),
(67, 'Richard Curtis'),
(68, 'Luc Besson'),
(69, 'Asger Leth'),
(70, 'Larry Charles'),
(71, 'Jean-Pierre Jeunet'),
(72, 'Billy Bob Thornton'),
(73, 'Donald Petrie'),
(74, 'Robert Luketic'),
(75, 'Mike Newell'),
(76, 'Anne Fletcher'),
(77, 'Gore Verbinski'),
(78, 'Peter Lord, Nick Park'),
(79, 'Sam Mendes'),
(80, 'Tim Story'),
(81, 'Oliver Stone'),
(82, 'David Zucker'),
(83, 'Wes Craven'),
(84, 'Betty Thomas'),
(85, 'Gus Van Sant'),
(86, 'Yimou Zhang'),
(87, 'Julie Taymor'),
(88, 'Russell Mulcahy'),
(89, 'Roger Kumble'),
(90, 'Len Wiseman'),
(91, 'Mark Pellington'),
(92, 'Robert Rodriguez'),
(93, 'David Frankel'),
(94, 'James Wan'),
(95, 'Kirk De Micco, Chris Sanders'),
(96, 'Paul Feig'),
(97, 'Ang Lee'),
(98, 'Simon West'),
(99, 'Susan Stroman'),
(100, 'David Fincher'),
(101, 'Sean Penn'),
(102, 'Zack Snyder'),
(103, 'Alan J. Pakula'),
(104, 'Joel Schumacher'),
(105, 'Phillip Noyce'),
(106, 'Stephen Norrington'),
(107, 'Luis Llosa'),
(108, 'Ron Shelton'),
(109, 'Melville Shavelson'),
(110, 'Frank Oz'),
(111, 'David Lynch'),
(112, 'Paul McGuigan'),
(113, 'John Gray'),
(114, 'Harold Ramis'),
(115, 'Simon Wincer'),
(116, 'Norman Ferguson, T. Hee, Wilfred Jackson, Jack Kinney, Hamilton Luske, Bill Roberts, Ben Sharpsteen'),
(117, 'George P. Cosmatos'),
(118, 'Andrew Davis'),
(119, 'Barry Levinson'),
(120, 'Brian Gibson'),
(121, 'Sydney Pollack'),
(122, 'Reginald Hudlin'),
(123, 'Joseph L. Mankiewicz, Rouben Mamoulian, Darryl F. Zanuck'),
(124, 'Barbra Streisand'),
(125, 'John Glen'),
(126, 'Annabel Jankel, Rocky Morton'),
(127, 'John G. Avildsen'),
(128, 'Robert Zemeckis'),
(129, 'Penny Marshall'),
(130, 'Francis Ford Coppola'),
(131, 'Peter Moffatt'),
(132, 'Aziz Ansari'),
(133, 'Meredith Scardino'),
(134, 'David Shore'),
(135, 'Rob McElhenney'),
(136, 'Maude Lewis'),
(137, 'Barry Jenkins'),
(138, 'Ronald D. Moore');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disponibilidad_plataforma`
--

CREATE TABLE `disponibilidad_plataforma` (
  `id_produccion` int(11) NOT NULL,
  `id_plataforma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `disponibilidad_plataforma`
--

INSERT INTO `disponibilidad_plataforma` (`id_produccion`, `id_plataforma`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(2, 3),
(3, 3),
(4, 4),
(5, 5),
(6, 5),
(7, 3),
(8, 4),
(9, 2),
(10, 3),
(11, 1),
(11, 2),
(11, 3),
(12, 2),
(13, 5),
(14, 4),
(15, 2),
(16, 3),
(17, 4),
(18, 3),
(19, 3),
(20, 4),
(21, 2),
(22, 5),
(23, 3),
(24, 2),
(25, 4),
(26, 4),
(27, 2),
(28, 5),
(29, 4),
(30, 2),
(31, 4),
(32, 1),
(32, 2),
(32, 3),
(33, 4),
(34, 4),
(35, 1),
(35, 2),
(35, 3),
(36, 4),
(37, 2),
(38, 1),
(38, 2),
(38, 3),
(39, 3),
(40, 4),
(41, 2),
(42, 6),
(43, 1),
(43, 2),
(43, 3),
(44, 4),
(45, 5),
(46, 1),
(46, 2),
(46, 3),
(47, 2),
(48, 6),
(49, 3),
(50, 1),
(51, 2),
(52, 5),
(53, 6),
(54, 1),
(54, 2),
(54, 3),
(55, 5),
(56, 1),
(57, 4),
(58, 1),
(59, 2),
(60, 5),
(61, 4),
(62, 6),
(63, 1),
(64, 5),
(65, 5),
(66, 1),
(66, 2),
(66, 3),
(67, 2),
(68, 6),
(69, 5),
(70, 3),
(71, 1),
(72, 2),
(73, 2),
(73, 3),
(74, 2),
(75, 2),
(76, 1),
(76, 2),
(76, 3),
(77, 4),
(78, 5),
(79, 6),
(80, 5),
(81, 2),
(82, 6),
(83, 1),
(84, 6),
(85, 3),
(86, 6),
(87, 3),
(88, 6),
(89, 3),
(90, 6),
(91, 1),
(91, 3),
(92, 3),
(93, 1),
(94, 1),
(94, 3),
(95, 1),
(96, 4),
(97, 6),
(98, 1),
(99, 3),
(99, 4),
(100, 3),
(101, 1),
(101, 3),
(101, 4),
(102, 4),
(103, 1),
(104, 4),
(105, 1),
(106, 6),
(107, 6),
(108, 4),
(109, 3),
(110, 1),
(111, 1),
(112, 1),
(112, 3),
(113, 3),
(114, 6),
(115, 4),
(116, 3),
(117, 1),
(118, 4),
(119, 1),
(120, 6),
(121, 6),
(122, 3),
(123, 3),
(124, 4),
(125, 4),
(126, 3),
(127, 3),
(128, 1),
(128, 2),
(128, 3),
(129, 6),
(130, 4),
(131, 1),
(132, 3),
(133, 1),
(134, 6),
(135, 3),
(136, 2),
(137, 3),
(138, 2),
(139, 2),
(140, 1),
(140, 2),
(140, 3),
(141, 1),
(142, 3),
(143, 3),
(145, 4),
(146, 3),
(147, 3),
(148, 1),
(148, 4),
(149, 7),
(150, 4),
(151, 4),
(152, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favoritos`
--

CREATE TABLE `favoritos` (
  `id_produccion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataforma`
--

CREATE TABLE `plataforma` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `icono` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plataforma`
--

INSERT INTO `plataforma` (`id`, `nombre`, `url`, `icono`) VALUES
(1, 'HBO', 'https://www.hbomax.com/', 'https://t1.gstatic.com/images?q=tbn:ANd9GcQVMPj1eYI6uhLfHTdLp5a_3CVuh91RU_9oGEPAUXmC96fPKDa7'),
(2, 'Rakuten TV', 'https://rakuten.tv/', 'https://play-lh.googleusercontent.com/83p_CXCRvPSQRcZQvFrPJYvDralOoYJiK-hP4zuK8ChjD0-F1e5Sc3kyVe-DjOMiHGs'),
(3, 'Netflix', 'https://www.netflix.com/es/', 'https://yt3.googleusercontent.com/haakxzxYsFMSdeXaCrA_Yag87fANjsALOmZwEqjxzeAeeLGVfZdVSbwhr1cGadkn5Qdy9fwA=s900-c-k-c0x00ffffff-no-rj'),
(4, 'Amazon Prime Video', 'https://www.primevideo.com/', 'https://play-lh.googleusercontent.com/Y7drWZZo_F2GBE1RhjR1irOkE3yrtPorHS1U9YkLKAu1DnTjQ8gNbcRmrBtkd3tnHQ'),
(5, 'DISNEY +', 'https://www.disneyplus.com/', 'https://i.pinimg.com/736x/5c/2c/f5/5c2cf5c486deffa55f5bdfc35054fb0d.jpg'),
(6, 'Popcornflix', 'https://popcornflix.com/', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPiDgyFqThjTcsTxyWsP2r3hI2zSoRz-2j5MyRCOO48eMava6yKlALG80nhQYyvfth-q8&usqp=CAU'),
(7, 'Apple TV+', 'https://www.apple.com/es/apple-tv-plus/', 'https://www.apple.com/v/apple-tv-plus/ae/images/meta/apple-tv__e7aqjl2rqzau_og.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producciones`
--

CREATE TABLE `producciones` (
  `id` int(11) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `calificacion` enum('G','PG','PG_13','R','X') NOT NULL,
  `fecha_lanzamiento` date NOT NULL,
  `duracion` int(11) NOT NULL,
  `genero` varchar(200) NOT NULL,
  `director` int(11) NOT NULL,
  `guion` varchar(1000) NOT NULL,
  `portada` varchar(200) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `id_productora` int(11) NOT NULL,
  `web` varchar(200) NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `valoracion_total` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producciones`
--

INSERT INTO `producciones` (`id`, `titulo`, `calificacion`, `fecha_lanzamiento`, `duracion`, `genero`, `director`, `guion`, `portada`, `tipo`, `id_productora`, `web`, `disponible`, `valoracion_total`) VALUES
(1, 'Argo', 'R', '2012-10-12', 120, 'Biography,Drama,History,', 1, 'Acting under the cover of a Hollywood producer scouting a location for a science fiction film, a CIA agent launches a dangerous operation to rescue six Americans in Tehran during the U.S. hostage crisis in Iran in 1980.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3MjI0MjM0NF5BMl5BanBnXkFtZTcwMTYxMTQ1OA@@._V1_SX300.jpg', 'Pelicula', 1, 'http://argothemovie.warnerbros.com', 1, NULL),
(2, 'Blended', 'PG_13', '2014-05-23', 117, 'Comedy,Romance,', 2, 'After a bad blind date, a man and woman find themselves stuck together at a resort for families, where their attraction grows as their respective kids benefit from the burgeoning relationship.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNzc2ODI5NjAyMl5BMl5BanBnXkFtZTgwMzIyOTE4MDE@._V1_SX300.jpg', 'Pelicula', 1, 'http://blendedmovie.com/', 1, NULL),
(3, 'Here Comes the Boom', 'PG', '2012-10-12', 105, 'Action,Comedy,Sport,', 2, 'A high school biology teacher looks to become a successful mixed-martial arts fighter in an effort to raise money to prevent extra-curricular activities from being axed at his cash-strapped school.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzEzNDQ0Nl5BMl5BanBnXkFtZTcwMDI2NTY1OA@@._V1_SX300.jpg', 'Pelicula', 2, 'http://boom-movie.com/', 1, NULL),
(4, 'Big Trouble', 'PG_13', '2002-04-05', 85, 'Comedy,Crime,Thriller,', 3, 'The lives of several Miami denizens, from ad agents to gunrunners to street thugs to law enforcement to school-children, intersect with humorous and dangerous results.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMGExOThjYjMtYzA2MC00OTZhLWEzMDYtMTAwZmViMGU4OTE4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'Pelicula', 3, 'http://bventertainment.go.com/movies/bigtrouble', 1, NULL),
(5, 'The Princess Diaries 2: Royal Engagement', 'G', '2004-08-11', 113, 'Comedy,Family,Romance,', 4, 'Now settled in Genovia, Princess Mia faces a new revelation: she is being primed for an arranged marriage to an en_US suitor.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODljNTU2ZGMtMWI5Yy00MGNkLTg2MTktN2NhZjY0NDcwMDhiL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 4, 'http://disney.go.com/disneypictures/diaries2/index.html', 1, NULL),
(6, 'The Muppets', 'PG', '2011-11-23', 103, 'Adventure,Comedy,Family,', 5, 'A Muppet fanatic with some help from his two human compatriots must regroup the Muppet gang to stop an avaricious oil mogul from taking down one of their precious life-longing treasures.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjE0MTM4NTc3NF5BMl5BanBnXkFtZTcwMjYzOTIxNg@@._V1_SX300.jpg', 'Pelicula', 4, 'http://disney.go.com/muppets/', 1, NULL),
(7, 'The Hitchhikers Guide to the Galaxy', 'PG', '2005-04-29', 109, 'Adventure,Comedy,Sci-Fi,', 6, '\"Mere seconds before the Earth is to be demolished by an alien construction crew, journeyman Arthur Dent is swept off the planet by his friend Ford Prefect, a researcher penning a new edition of \"\"The Hitchhiker\'s Guide to the Galaxy.\"\"\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZmU5MGU4MjctNjA2OC00N2FhLWFhNWQtMzQyMGI2ZmQ0Y2YyL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg', 'Pelicula', 5, 'http://hitchhikers.movies.go.com/', 1, NULL),
(8, 'Julie & Julia', 'PG_13', '2009-08-07', 118, 'Biography,Drama,Romance,', 7, 'Julia Child\'s story of her start in the cooking profession is intertwined with blogger Julie Powell\'s 2002 challenge to cook all the recipes in Child\'s first book.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzA4NjA2NjI2NV5BMl5BanBnXkFtZTcwOTEzNzI2Mg@@._V1_SX300.jpg', 'Pelicula', 2, 'http://julieandjulia.com/', 1, NULL),
(9, 'Miracle at St. Anna', 'R', '2008-09-26', 160, 'Action,Crime,Drama,', 8, 'Set in 1944 Italy, the story of four black American soldiers who get trapped in a Tuscan village during WWII.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTIyNjIwOTI1MF5BMl5BanBnXkFtZTcwMTQ1NTU3MQ@@._V1_SX300.jpg', 'Pelicula', 3, 'http://MiracleMovie.com', 1, NULL),
(10, 'The BFG', 'PG', '2016-07-01', 117, 'Adventure,Family,Fantasy,', 9, 'An orphan little girl befriends a benevolent giant who takes her to Giant Country, where they attempt to stop the man-eating giants that are invading the human world.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjI5MjI4NTEzOF5BMl5BanBnXkFtZTgwNjM2Nzg3NzE@._V1_SX300.jpg', 'Pelicula', 4, 'http://movies.disney.com/the-bfg', 1, NULL),
(11, 'The Sixth Sense', 'PG_13', '1999-08-06', 107, 'Drama,Thriller,', 10, 'A boy who communicates with spirits that don\'t know they\'re dead seeks the help of a disheartened child psychologist.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMWM4NTFhYjctNzUyNi00NGMwLTk3NTYtMDIyNTZmMzRlYmQyXkEyXkFqcGdeQXVyMTAwMzUyOTc@._V1_SX300.jpg', 'Pelicula', 6, 'http://movies.go.com/moviesdynamic/movies/movie?id=505420', 1, NULL),
(12, 'The Sixth Sense', 'PG_13', '1999-08-06', 107, 'Drama,Thriller,', 10, 'A boy who communicates with spirits that don\'t know they\'re dead seeks the help of a disheartened child psychologist.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMWM4NTFhYjctNzUyNi00NGMwLTk3NTYtMDIyNTZmMzRlYmQyXkEyXkFqcGdeQXVyMTAwMzUyOTc@._V1_SX300.jpg', 'Pelicula', 6, 'http://movies.go.com/moviesdynamic/movies/movie?id=505420', 1, NULL),
(13, 'One for the Money', 'PG_13', '2012-01-27', 91, 'Action,Comedy,Crime,', 11, 'Unemployed and newly-divorced Stephanie Plum lands a job at her cousin\'s bail-bond business, where her first assignment puts her on the trail of a wanted local cop from her romantic past.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU2NzMxMDU1NF5BMl5BanBnXkFtZTcwNzYxNTA2Ng@@._V1_SX300.jpg', 'Pelicula', 7, 'http://oneforthemoneyfilm.com/', 1, NULL),
(14, 'The Other Woman', 'PG_13', '2014-04-25', 109, 'Comedy,Romance,', 12, 'After discovering her boyfriend is married, Carly soon meets the wife he\'s been betraying. And when yet another love affair is discovered, all three women team up to plot revenge on the three-timing S.O.B.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0ODE4ODY1OF5BMl5BanBnXkFtZTgwMDA5NjkzMTE@._V1_SX300.jpg', 'Pelicula', 8, 'http://otherwomanmovie.com', 1, NULL),
(15, 'Red Riding Hood', 'PG_13', '2011-03-11', 100, 'Fantasy,Horror,', 13, 'Set in a medieval village that is haunted by a werewolf, a young girl falls for an orphaned woodcutter, much to her family\'s displeasure.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc4NjYyMzQ5MV5BMl5BanBnXkFtZTcwNjE5Mjc3NA@@._V1_SX300.jpg', 'Pelicula', 1, 'http://redridinghood.warnerbros.com/', 1, NULL),
(16, 'Stealth', 'PG_13', '2005-07-29', 121, 'Action,Adventure,Sci-Fi,', 14, 'Deeply ensconced in a top-secret military program, three pilots struggle to bring an artificial intelligence program under control before it initiates the next world war.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNzMzNTY0NTYwOV5BMl5BanBnXkFtZTcwMTExNjgyMQ@@._V1_SX300.jpg', 'Pelicula', 9, 'http://sonypictures.com/movies/stealth', 1, NULL),
(17, 'Spider-Man', 'PG_13', '2002-05-03', 121, 'Action,Adventure,', 15, 'When bitten by a genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities that he eventually must use to fight evil as a superhero after tragedy befalls his family.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZDEyN2NhMjgtMjdhNi00MmNlLWE5YTgtZGE4MzNjMTRlMGEwXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_SX300.jpg', 'Pelicula', 9, 'http://spiderman.sonypictures.com/', 1, NULL),
(18, 'Coyote Ugly', 'PG_13', '2000-08-04', 100, 'Comedy,Drama,Musical,', 16, 'Aspiring songwriter Violet Sanford, after getting a job at a women-run NYC bar that teases its male patrons, comes out of her shell.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk1NzM1ODg4OF5BMl5BanBnXkFtZTcwMTQ3OTgyMQ@@._V1_SX300.jpg', 'Pelicula', 5, 'http://studio.go.com/movies/coyoteugly/index.html', 1, NULL),
(19, 'The Ant Bully', 'PG', '2006-07-28', 88, 'Animation,Adventure,Comedy,', 17, 'After Lucas Nickle floods an ant colony with his watergun, he\'s magically shrunken down to insect size and sentenced to hard labor in the ruins.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjE2OTYwMzQzNl5BMl5BanBnXkFtZTcwNDM1MjMzMQ@@._V1_SX300.jpg', 'Pelicula', 1, 'http://theantbully.warnerbros.com/', 1, NULL),
(20, 'The Bucket List', 'PG_13', '2008-01-11', 97, 'Adventure,Comedy,Drama,', 18, 'Two terminally ill men escape from a cancer ward and head off on a road trip with a wish list of to-dos before they die.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2NTUyMjIyNF5BMl5BanBnXkFtZTYwNzYwMDM4._V1_SX300.jpg', 'Pelicula', 1, 'http://thebucketlist.warnerbros.com/', 1, NULL),
(21, 'The Ghost Writer', 'PG_13', '2010-03-19', 128, 'Thriller,', 19, 'A ghostwriter hired to complete the memoirs of a former British prime minister uncovers secrets that put his own life in jeopardy.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTI3NzMwMzkyNV5BMl5BanBnXkFtZTcwODk4NjQxMw@@._V1_SX300.jpg', 'Pelicula', 10, 'http://theghostwriter-movie.com/', 1, NULL),
(22, 'The Interview', 'R', '2014-12-24', 112, 'Comedy,', 20, '\"Dave Skylark and his producer Aaron Rapoport run the celebrity tabloid show \"\"Skylark Tonight\"\". When they land an interview with a surprise fan, North ko_KR dictator Kim Jong-un, they are recruited by the CIA to turn their trip to Pyongyang into an assassination mission.\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQzMTcwMzgyMV5BMl5BanBnXkFtZTgwMzAyMzQ2MzE@._V1_SX300.jpg', 'Pelicula', 11, 'http://theinterviewmovie.tumblr.com/', 1, NULL),
(23, 'The Bounty Hunter', 'PG_13', '2010-03-19', 110, 'Action,Comedy,Romance,', 21, 'A bounty hunter learns that his next target is his ex-wife, a reporter working on a murder cover-up. Soon after their reunion, the always-at-odds duo find themselves on a run-for-their-lives adventure.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwNjY4MjY0MV5BMl5BanBnXkFtZTcwNTA2OTYwMw@@._V1_SX300.jpg', 'Pelicula', 11, 'http://thepursuitbegins.com/', 1, NULL),
(24, 'Training Day', 'R', '2001-10-05', 122, 'Crime,Drama,Thriller,', 22, 'On his first day on the job as a Los Angeles narcotics officer, a rookie cop goes beyond a full work day in training within the narcotics division of the LAPD with a rogue detective who isn\'t what he appears to be.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDZkMTUxYWEtMDY5NS00ZTA5LTg3MTItNTlkZWE1YWRjYjMwL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 1, 'http://trainingday.warnerbros.com', 1, NULL),
(25, 'Unleashed', 'R', '2005-05-13', 103, 'Action,Crime,Drama,', 23, 'A man enslaved by the mob since childhood and raised into behaving like a human attack dog escapes his captors and attempts to start a new life.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgwNjIyNTczMF5BMl5BanBnXkFtZTcwODI5MDkyMQ@@._V1_SX300.jpg', 'Pelicula', 12, 'http://unleashedmovie.com/', 1, NULL),
(26, 'Wild Wild West', 'PG_13', '1999-06-30', 106, 'Action,Comedy,Sci-Fi,', 3, 'The two best hired guns in the West must save President Grant from the clutches of a nineteenth-century inventor-villain.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYmYyMTc4YjItMGNhNC00OWQwLWJhMWUtNTdjZDgxMDI5MjE2L2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 1, 'http://wildwildwest.warnerbros.com', 1, NULL),
(27, '15 Minutes', 'R', '2001-03-09', 120, 'Action,Crime,Drama,', 24, 'A homicide detective and a fire marshal must stop a pair of murderers who commit videotaped crimes to become media darlings.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTI3MzQ1MzIwNl5BMl5BanBnXkFtZTYwMTAxODc5._V1_SX300.jpg', 'Pelicula', 13, 'http://www.15minutesmovie.com', 1, NULL),
(28, '21 Jump Street', 'R', '2012-03-16', 110, 'Action,Comedy,Crime,', 25, 'A pair of underachieving cops are sent back to a local high school to blend in and bring down a synthetic drug ring.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3NzQ3OTg3NF5BMl5BanBnXkFtZTcwMjk5OTcxNw@@._V1_SX300.jpg', 'Pelicula', 11, 'http://www.21jumpstreet-movie.com/site/', 1, NULL),
(29, '8 Mile', 'R', '2002-11-08', 110, 'Drama,Musical,', 26, 'A young rapper, struggling with every aspect of his life, wants to make it big but his friends and foes make this odyssey of rap harder than it may seem.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BOWI3MDIzZmYtN2Y3MC00YTljLWFiYmYtNWIzMjg1ZWQ1ODlhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.8-mile.com/', 1, NULL),
(30, 'Eight Below', 'PG', '2006-02-17', 120, 'Adventure,Drama,Family,', 27, 'Brutal cold forces two Antarctic explorers to leave their team of sled dogs behind as they fend for their survival.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjExMjAwNzE0N15BMl5BanBnXkFtZTYwMDY4NDk2._V1_SX300.jpg', 'Pelicula', 15, 'http://www.8belowmovie.com', 1, NULL),
(31, 'A Knight\'s Tale', 'PG_13', '2001-05-11', 132, 'Action,Adventure,Romance,', 28, 'After his master dies, a peasant squire, fueled by his desire for food and glory, creates a new identity for himself as a knight.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTE5OTE4OTE2Nl5BMl5BanBnXkFtZTYwMDkzMTQ3._V1_SX300.jpg', 'Pelicula', 9, 'http://www.aknightstale.com', 1, NULL),
(32, 'Aliens in the Attic', 'PG', '2009-07-31', 86, 'Animation,Adventure,Comedy,', 29, 'A group of kids must protect their vacation home from invading aliens.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk3NTMzNTIxNV5BMl5BanBnXkFtZTcwOTI4ODU1Mg@@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.aliensintheatticmovie.com/', 1, NULL),
(33, 'Along Came Polly', 'PG_13', '2004-01-16', 90, 'Comedy,Romance,', 30, 'A buttoned up newlywed finds his too organized life falling into chaos when he falls in love with an old classmate.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcxMDMwODg3Nl5BMl5BanBnXkFtZTYwMTM4NTY3._V1_SX300.jpg', 'Pelicula', 14, 'http://www.alongcamepolly.com/', 1, NULL),
(34, 'Galaxy Quest', 'PG', '1999-12-25', 102, 'Adventure,Comedy,Sci-Fi,', 31, 'The alumni cast of a space opera television series have to play their roles as the real thing when an alien race needs their help.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA0NjM1ODkyMl5BMl5BanBnXkFtZTcwODY0NDMzMg@@._V1_SX300.jpg', 'Pelicula', 16, 'http://www.amazon.com/exec/obidos/subst/video/misc/dreamworks/galaxy-quest/gq-home.html/103-6831095-1845408', 1, NULL),
(35, 'American Hustle', 'R', '2013-12-20', 138, 'Crime,Drama,', 32, 'A con man, Irving Rosenfeld, along with his seductive partner Sydney Prosser, is forced to work for a wild FBI agent, Richie DiMaso, who pushes them into a world of Jersey powerbrokers and mafia.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNjkxMTc0MDc4N15BMl5BanBnXkFtZTgwODUyNTI1MDE@._V1_SX300.jpg', 'Pelicula', 11, 'http://www.americanhustle-movie.com/', 1, NULL),
(36, 'Babylon A.D.', 'PG_13', '2008-08-29', 90, 'Action,Adventure,Sci-Fi,', 33, 'Veteran-turned-mercenary Toorop takes the high-risk job of escorting a woman from Russia to America. Little does he know that she is host to an organism that a cult wants to harvest in order to produce a genetically modified Messiah.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk5MzQxMzk0Nl5BMl5BanBnXkFtZTcwOTM3NDA3MQ@@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.babylonadmovie.com/', 1, NULL),
(37, 'Bangkok Dangerous', 'R', '2008-09-05', 99, 'Action,Crime,Thriller,', 34, 'A hitman who\'s in Bangkok to pull off a series of jobs violates his personal code when he falls for a local woman and bonds with his errand boy.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk2NjU4MDYwNV5BMl5BanBnXkFtZTcwMDQ5ODg3MQ@@._V1_SX300.jpg', 'Pelicula', 7, 'http://www.bangkokdangerousmovie.net/', 1, NULL),
(38, 'The Twilight Saga: Breaking Dawn - Part 2', 'PG_13', '2012-11-16', 115, 'Adventure,Drama,Fantasy,', 35, 'After the birth of Renesmee, the Cullens gather other vampire clans in order to protect the child from a false allegation that puts the family in front of the Volturi.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyMzUyMzY1OF5BMl5BanBnXkFtZTcwNDQ4ODk1OA@@._V1_SX300.jpg', 'Pelicula', 17, 'http://www.breakingdawn-themovie.com/', 1, NULL),
(39, 'Cellular', 'PG_13', '2004-09-10', 94, 'Action,Crime,Thriller,', 36, 'A young man receives an emergency phone call on his cell phone from an older woman. The catch? The woman claims to have been kidnapped, and the kidnappers have targeted her husband and child next.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMmRmODc1OGEtYzhjOC00Y2FiLWFhNWUtYTJiYjlhMGU0Njk4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'Pelicula', 13, 'http://www.cellularthemovie.com', 1, NULL),
(40, 'Changing Lanes', 'R', '2002-04-12', 98, 'Drama,Thriller,', 37, 'The story of what happens one day in New York when a young lawyer and a businessman share a small automobile accident on F.D.R. Drive and their mutual road rage escalates into a feud.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYjNiMGEwZTAtNDc4Yy00MjcwLWE4ODktNzdkNGEwY2Q0NWIzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 18, 'http://www.changinglanes.com', 1, NULL),
(41, 'Charlie St. Cloud', 'PG_13', '2010-07-30', 99, 'Drama,Fantasy,Romance,', 38, 'Charlies brother, Sam, dies in a car crash that Charlie survives. Charlie is given the gift of seeing his dead brother, but when the girl he falls in love with\'s life is at risk, he must choose between his girlfriend and his brother.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTI4MjkyNDM2NV5BMl5BanBnXkFtZTcwOTExNDc0Mw@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.charliestcloud.com', 1, NULL),
(42, 'Cheaper by the Dozen', 'PG', '2003-12-25', 98, 'Comedy,Family,', 39, 'With his wife doing a book tour, a father of twelve must handle a new job and his unstable brood.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTg0NzYxMjY0Ml5BMl5BanBnXkFtZTcwOTU0NDczMw@@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.cheaperbythedozenmovie.com/', 1, NULL),
(43, 'Coach Carter', 'PG_13', '2005-01-14', 136, 'Biography,Drama,Sport,', 40, 'Controversy surrounds high school basketball coach Ken Carter after he benches his entire team for breaking their academic contract with him.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNWYxZWFiNTItN2FkNS00ZDJmLWE1MWItYjMyMTgyOTI4MmQ4XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 18, 'http://www.coachcartermovie.com/index2.html', 1, NULL),
(44, 'Heaven\'s Gate', 'R', '1980-11-19', 325, 'Adventure,Drama,Western,', 41, 'A dramatization of the real-life Johnson County War in 1890 Wyoming, in which a sheriff born into wealth attempts to protect immigrant farmers from rich cattle interests.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxNDE5MzQ5M15BMl5BanBnXkFtZTcwNTk3MTE3NA@@._V1_SX300.jpg', 'Pelicula', 19, 'http://www.criterion.com/films/28036-heaven-s-gate', 1, NULL),
(45, 'Scary Movie 2', 'R', '2001-07-04', 83, 'Comedy,', 42, 'Four teens are tricked by their professor into visiting a haunted house for a school project.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzQxYjU1OTUtYjRiOC00NDg2LWI4MWUtZGU5YzdkYTcwNTBlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 20, 'http://www.dimensionfilms.com/pls/front_con/dim_movie_page.entryPoint?midStr=1476', 1, NULL),
(46, 'Double Jeopardy', 'R', '1999-09-24', 105, 'Crime,Drama,', 43, 'A woman framed for her husband\'s murder suspects he is still alive, as she has already been tried for the crime, she can\'t be re-prosecuted if she finds and kills him.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BM2UzNzYzMjctYmI0MS00MzQ3LTliMTktOTA1MGU0YTM3NzRjXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 18, 'http://www.doublejeopardymovie.com', 1, NULL),
(47, 'Dumb and Dumber To', 'PG_13', '2014-11-14', 109, 'Comedy,', 44, 'Twenty years since their first adventure, Lloyd and Harry go on a road trip to find Harry\'s newly discovered daughter, who was given up for adoption.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMzA0MzAyMF5BMl5BanBnXkFtZTgwMjMyNjcwMjE@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.dumblr.com/', 1, NULL),
(48, 'Exodus: Gods and Kings', 'PG_13', '2014-12-12', 150, 'Action,Adventure,Drama,', 45, 'The defiant leader Moses rises up against the Egyptian Pharaoh Ramses, setting 600,000 slaves on a monumental journey of escape from Egypt and its terrifying cycle of deadly plagues.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjI3MDY0NjkxNl5BMl5BanBnXkFtZTgwNTM3NTA0MzE@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.exodusgodsandkings.com/', 1, NULL),
(49, 'Fat Albert', 'PG', '2004-12-25', 93, 'Comedy,Family,Fantasy,', 46, 'Fat Albert and the Cosby Kids come to life and step out of their animated, inner-city Philadelphia world.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTg2MzYxMDI2M15BMl5BanBnXkFtZTYwNTAzNTM3._V1_SX300.jpg', 'Pelicula', 8, 'http://www.fatalbertthemovie.com/', 1, NULL),
(50, 'Fifty Shades of Grey', 'R', '2015-02-13', 125, 'Drama,Romance,Thriller,', 47, 'Literature student Anastasia Steele\'s life changes forever when she meets handsome, yet tormented, billionaire Christian Grey.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjE1MTM4NDAzOF5BMl5BanBnXkFtZTgwNTMwNjI0MzE@._V1_SX300.jpg', 'Pelicula', 12, 'http://www.fiftyshadesmovie.com/', 1, NULL),
(51, 'Final Fantasy: The Spirits Within', 'PG_13', '2001-07-11', 106, 'Animation,Action,Adventure,', 48, 'A scientist makes a last stand on Earth with the help of a ragtag team of soldiers against an invasion of alien phantoms.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZWRjZTBlMWQtOGU2OS00NTNiLWEyNDUtNDA1NjI3ODE3OTJhXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'Pelicula', 9, 'http://www.finalfantasy.com', 1, NULL),
(52, 'Foodfight!', 'PG', '2013-02-12', 91, 'Animation,Action,Comedy,', 49, 'The evil Brand X joins a supermarket that becomes a city after closing time.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYwMDY1MDI0NV5BMl5BanBnXkFtZTgwODAyODk3NzE@._V1_SX300.jpg', 'Pelicula', 7, 'http://www.foodfight.com/', 1, NULL),
(53, 'The Revenant', 'R', '2016-01-08', 156, 'Adventure,Drama,Thriller,', 50, 'A frontiersman on a fur trading expedition in the 1820s fights for survival after being mauled by a bear and left for dead by members of his own hunting team.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BY2FmODc2N2QtYmY3MS00YTMwLWI2NGYtZWRmYWVkNjFjZmI0XkEyXkFqcGdeQXVyNTMxMjgxMzA@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.foxmovies.com/movies/the-revenant', 1, NULL),
(54, 'From Hell', 'R', '2001-10-19', 122, 'Horror,Thriller,', 51, 'In Victorian Era London, a troubled clairvoyant police detective investigates the murders by Jack The Ripper.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTM1MjkxNTQxMV5BMl5BanBnXkFtZTYwMDMxNDg2._V1_SX300.jpg', 'Pelicula', 8, 'http://www.fromhellmovie.com', 1, NULL),
(55, 'Get Hard', 'R', '2015-03-27', 100, 'Comedy,Crime,', 52, 'When millionaire James King is jailed for fraud and bound for San Quentin, he turns to Darnell Lewis to prep him to go behind bars.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3OTc1NjM0M15BMl5BanBnXkFtZTgwNjAyMzE1MzE@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.GetHardMovie.com', 1, NULL),
(56, 'The Medallion', 'PG_13', '2003-08-22', 88, 'Action,Comedy,Fantasy,', 53, 'A Hong Kong detective suffers a fatal accident involving a mysterious medallion and is transformed into an immortal warrior with superhuman powers.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZTAxNmQ4ODAtM2IyMy00Yjg5LTgwNDMtODM4MGQ5MGQzNmU0L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 9, 'http://www.GetTheMedallion.com', 1, NULL),
(57, 'G.I. Joe: The Rise of Cobra', 'PG_13', '2009-08-07', 118, 'Action,Adventure,Sci-Fi,', 54, 'An elite military unit comprised of special operatives known as G.I. Joe, operating out of The Pit, takes on an evil organization led by a notorious arms dealer.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQzMTU1NzQwNl5BMl5BanBnXkFtZTcwNDg4NzMzMw@@._V1_SX300.jpg', 'Pelicula', 18, 'http://www.gijoemovie.com/', 1, NULL),
(58, 'Gods of Egypt', 'PG_13', '2016-02-26', 126, 'Action,Adventure,Fantasy,', 55, 'Mortal hero Bek teams with the god Horus in an alliance against Set, the merciless god of darkness, who has usurped Egypt\'s throne, plunging the once peaceful and prosperous empire into chaos and conflict.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNjExODg3MDUzNl5BMl5BanBnXkFtZTgwNjExMjE3NzE@._V1_SX300.jpg', 'Pelicula', 7, 'http://www.godsofegypt.movie/home', 1, NULL),
(59, 'He\'s Just Not That Into You', 'PG_13', '2009-02-06', 129, 'Comedy,Drama,Romance,', 56, 'The Baltimore-set movie of interconnecting story arcs deals with the challenges of reading or misreading human behavior.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTY5MTUyNDgwMF5BMl5BanBnXkFtZTcwNzYzMDQyMg@@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.hesjustnotthatintoyoumovie.com/', 1, NULL),
(60, 'Hugo', 'PG', '2011-11-23', 126, 'Adventure,Drama,Family,', 57, 'In Paris in 1931, an orphan named Hugo Cabret who lives in the walls of a train station is wrapped up in a mystery involving his late father and an automaton.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAzNzk5MzgyNF5BMl5BanBnXkFtZTcwOTE4NDU5Ng@@._V1_SX300.jpg', 'Pelicula', 21, 'http://www.hugomovie.com/', 1, NULL),
(61, 'The Warrior\'s Way', 'R', '2010-12-03', 100, 'Action,Fantasy,Western,', 58, 'A warrior-assassin is forced to hide in a small town in the American Badlands after refusing a mission.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgwNzkzNjA4M15BMl5BanBnXkFtZTcwMzczNDUwNA@@._V1_SX300.jpg', 'Pelicula', 22, 'http://www.iamrogue.com/thewarriorsway', 1, NULL),
(62, 'The Incredible Hulk', 'PG_13', '2008-06-13', 112, 'Action,Adventure,Sci-Fi,', 23, 'Bruce Banner, a scientist on the run from the U.S. Government, must find a cure for the monster he emerges whenever he loses his temper.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUyNzk3MjA1OF5BMl5BanBnXkFtZTcwMTE1Njg2MQ@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.incrediblehulk.com/', 1, NULL),
(63, 'The World Is Not Enough', 'PG_13', '1999-11-19', 128, 'Action,Adventure,Thriller,', 59, 'James Bond uncovers a nuclear plot when he protects an oil heiress from her former kidnapper, an international terrorist who can\'t feel pain.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA0MzUyNjg0MV5BMl5BanBnXkFtZTcwNDY5MDg0NA@@._V1_SX300.jpg', 'Pelicula', 23, 'http://www.jamesbond.com/bond19/index.html', 1, NULL),
(64, 'Johnny en_US', 'PG', '2003-07-18', 87, 'Action,Adventure,Comedy,', 60, 'After a sudden attack on the MI5, Johnny en_US, Britain\'s most confident yet unintelligent spy, becomes Britain\'s only spy.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTg3Njk4MzY3M15BMl5BanBnXkFtZTYwNTQzODI3._V1_SX300.jpg', 'Pelicula', 14, 'http://www.johnny-en_US.com/', 1, NULL),
(65, 'Johnny en_US Reborn', 'PG', '2011-10-21', 101, 'Action,Adventure,Comedy,', 61, 'Johnny en_US goes up against international assassins hunting down the zh_CN premier.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjEzODY2MjU1Nl5BMl5BanBnXkFtZTcwMzc1ODUzNg@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.johnnyen_USreborn.com/', 1, NULL),
(66, 'Journey to the Center of the Earth', 'PG', '2008-07-11', 93, 'Action,Adventure,Family,', 62, 'On a quest to find out what happened to his missing brother, a scientist, his nephew and their mountain guide discover a fantastic and dangerous lost world in the center of the earth.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk1MzY1MzU1MF5BMl5BanBnXkFtZTcwOTQ2NjM3MQ@@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.journey3dmovie.com/', 1, NULL),
(67, 'Kicking & Screaming', 'PG', '2005-05-13', 95, 'Comedy,Family,Romance,', 63, 'Family man Phil Weston, a lifelong victim of his father\'s competitive nature, takes on the coaching duties of a kids\' soccer team, and soon finds that he\'s also taking on his father\'s dysfunctional way of relating...', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTA5Njk1MjEzMzZeQTJeQWpwZ15BbWU3MDY3NjY4MjE@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.kickingandscreamingmovie.com/', 1, NULL),
(68, 'Last Holiday', 'PG_13', '2006-01-13', 112, 'Comedy,', 64, 'Upon learning of a terminal illness, a shy woman (Queen Latifah) decides to sell off all her possessions and live it up at a posh European hotel.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzY4ZjcxOTItNWQwOC00MmMxLTkzMjYtZmQwMTJiMGY5Y2JlXkEyXkFqcGdeQXVyMTAwMzUyOTc@._V1_SX300.jpg', 'Pelicula', 18, 'http://www.lastholidaymovie.com/', 1, NULL),
(69, 'Lone Survivor', 'R', '2014-01-10', 121, 'Action,Biography,Drama,', 65, 'Marcus Luttrell and his team set out on a mission to capture or kill notorious Taliban leader Ahmad Shah, in late June 2005. Marcus and his team are left to fight for their lives in one of the most valiant efforts of modern warfare.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA0NTgwOTk5Ml5BMl5BanBnXkFtZTcwMjE3NDc5OQ@@._V1_SX300.jpg', 'Pelicula', 24, 'http://www.lonesurvivorfilm.com/', 1, NULL),
(70, 'Lord of War', 'R', '2005-09-16', 122, 'Crime,Drama,Thriller,', 66, 'An arms dealer confronts the morality of his work as he is being chased by an Interpol agent.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'Pelicula', 25, 'http://www.lordofwarthemovie.com/', 1, NULL),
(71, 'Love Actually', 'R', '2003-11-14', 135, 'Comedy,Drama,Romance,', 67, 'Follows the lives of eight very different couples in dealing with their love lives in various loosely interrelated tales all set during a frantic month before Christmas in London, England.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTY4NjQ5NDc0Nl5BMl5BanBnXkFtZTYwNjk5NDM3._V1_SX300.jpg', 'Pelicula', 14, 'http://www.loveactually.com/', 1, NULL),
(72, 'Lucy', 'R', '2014-07-25', 89, 'Action,Sci-Fi,Thriller,', 68, 'A woman, accidentally caught in a dark deal, turns the tables on her captors and transforms into a merciless warrior evolved beyond human logic.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODcxMzY3ODY1NF5BMl5BanBnXkFtZTgwNzg1NDY4MTE@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.lucymovie.com/', 1, NULL),
(73, 'Man on a Ledge', 'PG_13', '2012-01-27', 102, 'Action,Crime,Thriller,', 69, 'As a police psychologist works to talk down an ex-con who is threatening to jump from a Manhattan hotel rooftop, the biggest diamond heist ever committed is in motion.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5MTE4MzY2N15BMl5BanBnXkFtZTcwNjMwNDc3Ng@@._V1_SX300.jpg', 'Pelicula', 10, 'http://www.manonaledge.com', 1, NULL),
(74, 'Brüno', 'R', '2009-07-10', 81, 'Comedy,', 70, 'Flamboyant and gay Austrian Brüno looks for new fame in America.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwNDIwNDE5MV5BMl5BanBnXkFtZTcwMDA2MzA1Mg@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.meinspace.com/bruno', 1, NULL),
(75, 'Micmacs', 'R', '2010-06-11', 105, 'Action,Comedy,Crime,', 71, 'A man and his friends come up with an intricate and original plan to destroy two big weapons manufacturers.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgwOTc4OTk3NV5BMl5BanBnXkFtZTcwMzc0MjMzMw@@._V1_SX300.jpg', 'Pelicula', 26, 'http://www.micmacsmovie.com', 1, NULL),
(76, 'All the Pretty Horses', 'PG_13', '2000-12-25', 116, 'Drama,Romance,Western,', 72, 'Two Texas cowboys head to Mexico in search of work, but soon find themselves in trouble with the law after one of them falls in love with a wealthy rancher\'s daughter.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTMzMTMxNTAyMF5BMl5BanBnXkFtZTcwODkwMDAzMQ@@._V1_SX300.jpg', 'Pelicula', 27, 'http://www.miramax.com/mm_front/owa/mp.entryPoint?action=0&midStr=1442', 1, NULL),
(77, 'Miss Congeniality', 'PG_13', '2000-12-22', 109, 'Action,Comedy,Crime,', 73, 'An FBI agent must go undercover in the Miss United States beauty pageant to prevent a group from bombing the event.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNjZlYzA4NTgtOGU0My00ODYwLTk4ZWItYWI4NGQ3NTU1NjI2XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.misscongeniality.net', 1, NULL),
(78, 'Monster-in-Law', 'PG_13', '2005-05-13', 101, 'Comedy,Romance,', 74, 'The love life of Charlotte is reduced to an endless string of disastrous blind dates, until she meets the perfect man, Kevin. Unfortunately, his merciless mother will do anything to destroy their relationship.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYTcwYjA1NGItM2YyYy00MmE4LTkxMzItYWNiZWRkNDFjNmE5L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 13, 'http://www.monsterinlaw.com', 1, NULL),
(79, 'Love in the Time of Cholera', 'R', '2007-11-16', 139, 'Drama,Romance,', 75, 'Florentino, rejected by the beautiful Fermina at a young age, devotes much of his adult life to carnal affairs as a desperate attempt to heal his broken heart.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ3OTE0OTM4N15BMl5BanBnXkFtZTcwNDg3OTI1MQ@@._V1_SX300.jpg', 'Pelicula', 13, 'http://www.myspace.com/litc_film', 1, NULL),
(80, 'The Proposal', 'PG_13', '2009-06-19', 108, 'Comedy,Drama,Romance,', 76, 'A pushy boss forces her young assistant to marry her in order to keep her visa status in the U.S. and avoid deportation to Canada.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU1MzY1ODIyNV5BMl5BanBnXkFtZTcwNDU4NTE3Mg@@._V1_SX300.jpg', 'Pelicula', 4, 'http://www.myspace.com/proposalmovie', 1, NULL),
(81, 'Notting Hill', 'PG_13', '1999-05-28', 124, 'Comedy,Drama,Romance,', 37, 'The life of a simple bookshop owner changes when he meets the most famous film star in the world.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTE5OTkwYzYtNDhlNC00MzljLTk1YTktY2IxZjliZmNjMjUzL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.notting-hill.com', 1, NULL),
(82, 'Rango', 'PG', '2011-03-04', 107, 'Animation,Adventure,Comedy,', 77, 'Rango is an ordinary chameleon who accidentally winds up in the town of Dirt, a lawless outpost in the Wild West in desperate need of a new sheriff.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjE5ODg1NTk3OF5BMl5BanBnXkFtZTcwNzA5NTMyNA@@._V1_SX300.jpg', 'Pelicula', 18, 'http://www.RangoMovie.com/', 1, NULL),
(83, 'Chicken Run', 'G', '2000-06-23', 84, 'Animation,Adventure,Comedy,', 78, 'When a cockerel apparently flies into a chicken farm, the chickens see him as an opportunity to escape their evil owners.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BY2UyYjFkNzAtYzIyMC00MGI1LTlkNDktNzUyOGQ5NTI2ZGFjXkEyXkFqcGdeQXVyNTUyMzE4Mzg@._V1_SX300.jpg', 'Pelicula', 28, 'http://www.reel.com/reel.asp?node=chickenrun', 1, NULL),
(84, 'Revolutionary Road', 'R', '2009-01-23', 119, 'Drama,Romance,', 79, 'A young couple living in a Connecticut suburb during the mid-1950s struggle to come to terms with their personal problems while trying to raise their two children.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTczNDgzMjczOV5BMl5BanBnXkFtZTcwOTU3MzMwMg@@._V1_SX300.jpg', 'Pelicula', 29, 'http://www.revolutionaryroadmovie.com', 1, NULL),
(85, 'Ride Along 2', 'PG_13', '2016-01-15', 102, 'Action,Comedy,', 80, 'As his wedding day approaches, Ben heads to Miami with his soon-to-be brother-in-law James to bring down a drug dealer whos supplying the dealers of Atlanta with product.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU4ODAzMzcxOV5BMl5BanBnXkFtZTgwODkxMDI1NjE@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.ridealong.com/', 1, NULL),
(86, 'Savages', 'R', '2012-07-06', 131, 'Crime,Drama,Thriller,', 81, 'Pot growers Ben and Chon face off against the Mexican drug cartel who kidnapped their shared girlfriend.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk0ODIyNDAyMF5BMl5BanBnXkFtZTcwMTQ5Nzg3Nw@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.savagesfilm.com/', 1, NULL),
(87, 'Scary Movie 4', 'PG_13', '2006-04-14', 83, 'Comedy,', 82, '\"Cindy finds out the house she lives in is haunted by a little boy and goes on a quest to find out who killed him and why. Also, Alien \"\"Tr-iPods\"\" are invading the world and she has to uncover the secret in order to stop them.\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZmFkMzc2NTctN2U1Ni00MzE5LWJmMzMtYWQ4NjQyY2MzYmM1XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg', 'Pelicula', 30, 'http://www.scarymovie.com/', 1, NULL),
(88, 'Scary Movie 3', 'PG_13', '2003-10-24', 84, 'Comedy,', 82, 'Cindy must investigate mysterious crop circles and video tapes, and help the President in preventing an alien invasion.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDE2NTIyMjg2OF5BMl5BanBnXkFtZTYwNDEyMTg3._V1_SX300.jpg', 'Pelicula', 31, 'http://www.scarymovie.com/sm3_home.html', 1, NULL),
(89, 'Scream 3', 'R', '2000-02-04', 116, 'Horror,', 83, 'While Sidney and her friends visit the Hollywood set of Stab 3, the third film based on the Woodsboro murders, a new Ghostface begins to terrorize them once again.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZTQ0NGI1MjQtODA1OS00NGFlLWEzN2QtZjk5MjViYTA0YmM5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 20, 'http://www.scream3.com', 1, NULL),
(90, '28 Days', 'PG_13', '2000-04-14', 103, 'Comedy,Drama,', 84, 'A big-city newspaper columnist is forced to enter a drug and alcohol rehab center after ruining her sisters wedding and crashing a stolen limousine.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDlkMmE5ZTEtNTA0YS00OTBjLTgyYmEtMGExMzJkOTRjNDg4XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 9, 'http://www.sony.com/28days', 1, NULL),
(91, 'Finding Forrester', 'PG_13', '2001-01-12', 136, 'Drama,', 85, 'A young writing prodigy finds a mentor in a reclusive author.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMGQwYzY5ZDktMTI1My00ZjkwLTk3YjMtYWJmYTk2ZmQ0MjdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 9, 'http://www.sony.com/findingforrester', 1, NULL),
(92, 'Curse of the Golden Flower', 'R', '2007-01-12', 114, 'Action,Drama,Romance,', 86, 'During Chinas Tang dynasty the emperor has taken the princess of a neighboring province as wife. She has borne him two sons and raised his eldest. Now his control over his dominion is complete, including the royal family itself.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYjdmN2E4YmEtZTIzMy00ZDA1LTllY2UtNjQ5NTgyNjkxYWUyL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg', 'Pelicula', 32, 'http://www.sonyclassics.com/curseofthegoldenflower/', 1, NULL),
(93, 'Across the Universe', 'PG_13', '2007-10-12', 133, 'Drama,Fantasy,Musical,', 87, 'The music of the Beatles and the Vietnam War form the backdrop for the romance between an upper-class American girl and a poor Liverpudlian artist.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTIyMTUwNzg3Nl5BMl5BanBnXkFtZTcwMjM1MDI1MQ@@._V1_SX300.jpg', 'Pelicula', 2, 'http://www.sonypictures.com/movies/acrosstheuniverse/index.html', 1, NULL),
(94, 'Resident Evil: Extinction', 'R', '2007-09-21', 94, 'Action,Horror,Sci-Fi,', 88, 'Survivors of the Raccoon City catastrophe travel across the Nevada desert, hoping to make it to Alaska. Alice joins the caravan and their fight against the evil Umbrella Corp.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDQ0MWI3MmEtMzM0OC00Y2ViLWE4MDItMzNhNmY1ZTdjMWE2XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 11, 'http://www.sonypictures.com/movies/residentevilextinction/', 1, NULL),
(95, 'The Sweetest Thing', 'R', '2002-04-12', 88, 'Comedy,Romance,', 89, 'A girl finds she is forced to educate herself on the etiquette of wooing the opposite sex when she finally meets Mr. Right.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDIyZTkwOGEtYTFlNC00MTU4LWIyNGItYjBlYmFhNDRmYzcwXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 9, 'http://www.sonypictures.com/movies/thesweetestthing', 1, NULL),
(96, 'Underworld: Evolution', 'R', '2006-01-20', 106, 'Action,Adventure,Fantasy,', 90, 'Picking up directly from the previous film, vampire warrior Selene and the half werewolf Michael hunt for clues to reveal the history of their races and the war between them.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjEzNDY1OTQwOV5BMl5BanBnXkFtZTcwNjcxMTIzMw@@._V1_SX300.jpg', 'Pelicula', 33, 'http://www.sonypictures.com/movies/underworldevolution/', 1, NULL),
(97, 'The Mothman Prophecies', 'PG_13', '2002-01-25', 119, 'Drama,Horror,', 91, 'A reporter is drawn to a small West Virginia town to investigate a series of strange events, including psychic visions and the appearance of bizarre entities.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjVmNDNjYWYtNzk0Mi00ZTU4LTljNDYtNDczZDE4NGMzZmQwXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 34, 'http://www.spe.sony.com/movies/mothman', 1, NULL),
(98, 'Spy Kids 3: Game Over', 'PG', '2003-07-25', 84, 'Action,Adventure,Comedy,', 92, 'Carmens caught in a virtual reality game designed by the Kids new nemesis, the Toymaker. It\'s up to Juni to save his sister, and ultimately the world.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTI4MTQyNTUzMF5BMl5BanBnXkFtZTcwNzE2MDAwMQ@@._V1_SX300.jpg', 'Pelicula', 20, 'http://www.spykids.com', 1, NULL),
(99, 'The Big Year', 'PG', '2011-10-14', 100, 'Comedy,', 93, 'Two bird enthusiasts try to defeat the cocky, cutthroat world record holder in a year-long bird-spotting competition.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MzcwMDcyOV5BMl5BanBnXkFtZTcwNTUwMjk1Ng@@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.thebigyearmovie.com/', 1, NULL),
(100, 'The Conjuring 2', 'R', '2016-06-10', 134, 'Horror,Thriller,', 94, 'Lorraine and Ed Warren travel to north London to help a single mother raising four children alone in a house plagued by a malicious spirit.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZjU5OWVlN2EtODNlYy00MjhhLWI0MDUtMTA3MmQ5MGMwYTZmXkEyXkFqcGdeQXVyNjE5MTM4MzY@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.theconjuring2.com/', 1, NULL),
(101, 'The Croods', 'PG', '2013-03-22', 98, 'Animation,Adventure,Comedy,', 95, 'After their cave is destroyed, a caveman family must trek through an unfamiliar fantastical world with the help of an inventive boy.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyOTc2OTA1Ml5BMl5BanBnXkFtZTcwOTI1MjkzOQ@@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.thecroodsmovie.com/', 1, NULL),
(102, 'The Heat', 'R', '2013-06-28', 117, 'Action,Comedy,Crime,', 96, 'An uptight FBI Special Agent is paired with a foul-mouthed Boston cop to take down a ruthless drug lord.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA2MDQ2ODM3MV5BMl5BanBnXkFtZTcwNDUzMTQ3OQ@@._V1_SX300.jpg', 'Pelicula', 8, 'http://www.theheatmovie.com/#/trailer', 1, NULL),
(103, 'Hulk', 'PG_13', '2003-06-20', 138, 'Action,Sci-Fi,', 97, 'Bruce Banner, a genetics researcher with a tragic past, suffers an accident that causes him to transform into a raging green monster when he gets angry.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNjcxMzZhZTEtMmEwYi00NDJmLWE5ZmUtOWJiMzRmMzEzMTY3L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.thehulk.com/', 1, NULL),
(104, 'The Mechanic', 'R', '2011-01-28', 93, 'Action,Crime,Thriller,', 98, 'Follows an elite hit man as he teaches his trade to an apprentice who has a connection to one of his previous victims.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyMjk1NjI1M15BMl5BanBnXkFtZTcwODcyNjAxNA@@._V1_SX300.jpg', 'Pelicula', 35, 'http://www.themechanicmovie.com/', 1, NULL),
(105, 'The Producers', 'PG_13', '2005-12-25', 134, 'Comedy,Musical,', 99, 'After putting together another Broadway flop, down-on-his-luck producer Max Bialystock teams up with timid accountant Leo Bloom in a get-rich-quick scheme to put on the world\'s worst show.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA3NjAyNzg2OF5BMl5BanBnXkFtZTcwOTIyMDUzMQ@@._V1_SX300.jpg', 'Pelicula', 14, 'http://www.theproducersmovie.com/', 1, NULL),
(106, 'The Social Network', 'PG_13', '2010-10-01', 120, 'Biography,Drama,', 100, 'Harvard student Mark Zuckerberg creates the social networking site that would become known as Facebook, but is later sued by two brothers who claimed he stole their idea, and the co-founder who was later squeezed out of the business.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTM2ODk0NDAwMF5BMl5BanBnXkFtZTcwNTM1MDc2Mw@@._V1_SX300.jpg', 'Pelicula', 9, 'http://www.thesocialnetwork-movie.com/', 1, NULL),
(107, 'The Pledge', 'R', '2001-01-19', 124, 'Crime,Drama,', 101, 'A retiring police chief pledges to catch the killer of a young child.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZTIxNThmMTUtMWQwYi00NjFmLWFiOTAtOWJlY2JiZmFlNTA1XkEyXkFqcGdeQXVyMjA0MzYwMDY@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.warnerbros.com/pages/link/external.jsp?url=http%3a%2f%2fmovies.warnerbros.com%2fthepledge%2f&frompage=movies', 1, NULL),
(108, 'Watchmen', 'R', '2009-03-06', 162, 'Action,Drama,', 102, 'In 1985 where former superheroes exist, the murder of a colleague sends active vigilante Rorschach into his own sprawling investigation, uncovering something that could completely change the course of history as we know it.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BY2IzNGNiODgtOWYzOS00OTI0LTgxZTUtOTA5OTQ5YmI3NGUzXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg', 'Pelicula', 1, 'http://www.watchmenmovie.com/', 1, NULL),
(109, 'The Pelican Brief', 'PG_13', '1993-12-17', 141, 'Crime,Drama,', 103, 'A law student uncovers a conspiracy, putting herself and others in danger.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODE1NDk3Y2YtNTQzYS00ZTA1LTk3ZDAtZjUxNTc2ZDhlOGRlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 36, 'N/A', 1, NULL),
(110, 'The Client', 'PG_13', '1994-07-20', 119, 'Crime,Drama,', 104, 'A young boy who witnessed the suicide of a mafia lawyer hires an attorney to protect him when the District Attorney tries to use him to take down a mob family.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNGNjZWYwZGYtZWIxZC00OTYyLTllYTMtZWNiNmQ0YWUzMjkxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 36, 'N/A', 1, NULL),
(111, 'Patriot Games', 'R', '1992-06-05', 117, 'Action,Thriller,', 105, 'When CIA Analyst Jack Ryan interferes with an IRA assassination, a renegade faction targets him and his family for revenge.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA3OTA0NjI0Nl5BMl5BanBnXkFtZTgwNjUwODQxMTE@._V1_SX300.jpg', 'Pelicula', 18, 'N/A', 1, NULL),
(112, 'Blade', 'R', '1998-08-21', 120, 'Action,Horror,', 106, 'A half-vampire, half-mortal man becomes a protector of the mortal race, while slaying evil vampires.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MzkzNjcxNV5BMl5BanBnXkFtZTcwNzk4NTU0Mg@@._V1_SX300.jpg', 'Pelicula', 13, 'N/A', 1, NULL),
(113, 'Anaconda', 'PG_13', '1997-04-11', 89, 'Action,Adventure,Horror,', 107, '\"A \"\"National Geographic\"\" film crew is taken hostage by an insane hunter, who takes them along on his quest to capture the world\'s largest - and deadliest - snake.\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTMzMTU5NjcxNl5BMl5BanBnXkFtZTcwMzE2NDU2MQ@@._V1_SX300.jpg', 'Pelicula', 37, 'N/A', 1, NULL),
(114, 'The Specialist', 'R', '1994-10-07', 110, 'Action,Crime,Drama,', 107, 'A woman entices a bomb expert she\'s involved with into destroying the mafia that killed her family.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYjMwZDMwZTItMTc2MC00NDRlLWI3YmUtNTg0ZmQ3MzdhNDJmXkEyXkFqcGdeQXVyNjQ2MjQ5NzM@._V1_SX300.jpg', 'Pelicula', 36, 'N/A', 1, NULL),
(115, 'Tin Cup', 'R', '1996-08-16', 135, 'Comedy,Drama,Romance,', 108, 'A washed up golf pro working at a driving range tries to qualify for the US Open in order to win the heart of his succesful rival\'s girlfriend.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDQxNzY1MzItZmU1Mi00MWI3LTk4ZjYtOTBlM2RmYTk1MTJjXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'Pelicula', 38, 'N/A', 1, NULL),
(116, 'Yours, Mine and Ours', 'X', '1968-04-24', 111, 'Comedy,Family,', 109, 'A widower with ten children falls for a widow with eight, and they must decide about forming a huge, unconventional family.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BOTlhNzYyNzctNmYwOS00OGE3LTgyZWQtYzJkNmEzZGY3NjNjXkEyXkFqcGdeQXVyNjE5MjUyOTM@._V1_SX300.jpg', 'Pelicula', 39, 'N/A', 1, NULL),
(117, 'The River Wild', 'PG_13', '1994-09-30', 111, 'Action,Adventure,Crime,', 26, 'Rafting expert Gail takes on a pair of armed killers while navigating a spectacularly violent river.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYWQyYTZjNTYtNGRiMi00ZTVhLTk0ZWEtZDA0OTVmMDk4OGE2XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'Pelicula', 40, 'N/A', 1, NULL),
(118, 'The Indian in the Cupboard', 'PG', '1995-07-14', 96, 'Drama,Family,Fantasy,', 110, 'On his ninth birthday a boy receives many presents. Two of them first seem to be less important: an old cupboard from his brother and a little Indian figure made of plastic from his best ...', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTk0NjQ5NzQxMl5BMl5BanBnXkFtZTcwMDc5NjUyMQ@@._V1_SX300.jpg', 'Pelicula', 37, 'N/A', 1, NULL),
(119, 'Dune', 'PG_13', '1984-12-14', 137, 'Action,Adventure,Sci-Fi,', 111, 'A Duke\'s son leads desert warriors against the galactic emperor and his father\'s evil nemesis when they assassinate his father and free their desert world from the emperor\'s rule.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYTAzYzNlMDMtMGRjYS00M2UxLTk0MmEtYmE4YWZiYmEwOTIwL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNzc5MjA3OA@@._V1_SX300.jpg', 'Pelicula', 40, 'N/A', 1, NULL);
INSERT INTO `producciones` (`id`, `titulo`, `calificacion`, `fecha_lanzamiento`, `duracion`, `genero`, `director`, `guion`, `portada`, `tipo`, `id_productora`, `web`, `disponible`, `valoracion_total`) VALUES
(120, 'Victor Frankenstein', 'PG_13', '2015-11-25', 110, 'Drama,Horror,Sci-Fi,', 112, 'Told from Igor\'s perspective, we see the troubled young assistant\'s dark origins, his redemptive friendship with the young medical student Viktor Von Frankenstein, and become eyewitnesses to the emergence of how Frankenstein became the man - and the legend - we know today.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc2Mjk0MTM0NF5BMl5BanBnXkFtZTgwNjgyOTg1NjE@._V1_SX300.jpg', 'Pelicula', 8, 'N/A', 1, NULL),
(121, 'The Glimmer Man', 'R', '1996-10-04', 91, 'Action,Comedy,Crime,', 113, '\"Two cops, played by Seagal and Wayans, are forced to work together to solve a chain of mysterious killings by a killer nicknamed \"\"The Family Man\"\".\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYzgzZWY4YWMtMTQ4Yi00ZGQ4LTg4YjItNGNhMGM0ZWViNmY3XkEyXkFqcGdeQXVyMTczNjQwOTY@._V1_SX300.jpg', 'Pelicula', 36, 'N/A', 1, NULL),
(122, 'Multiplicity', 'PG_13', '1996-07-17', 117, 'Comedy,Romance,Sci-Fi,', 114, 'A man who never has enough time for the things he wants to do is offered the opportunity to have himself duplicated.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNTI4Zjc4MDMtZGJjMS00ZjhjLWJkYTItNjZhNGFjOTY4Y2E4XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg', 'Pelicula', 37, 'N/A', 1, NULL),
(123, 'The Phantom', 'PG', '1996-06-07', 100, 'Action,Adventure,Comedy,', 115, 'The Phantom, descendent of a line of African superheroes, travels to New York City to thwart a wealthy criminal genius from obtaining three magic skulls which would give him the secret to ultimate power.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMGE3MjRhZjUtZGQ0My00ZGM4LWI4YmMtMDYwM2ZjYTQ1ZWNkL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 41, 'N/A', 1, NULL),
(124, 'Nixon', 'R', '1996-01-05', 192, 'Biography,Drama,History,', 81, 'A biographical story of former U.S. president Richard Milhous Nixon, from his days as a young boy to his eventual presidency which ended in shame.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNzBlOWY0ZmEtZjdkYS00ZGU0LWEwN2YtYzBkNDM5ZDBjMmI1XkEyXkFqcGdeQXVyMTAwMzUyOTc@._V1_SX300.jpg', 'Pelicula', 15, 'N/A', 1, NULL),
(125, 'Deep Rising', 'R', '1998-01-30', 106, 'Action,Adventure,Horror,', 54, 'A group of heavily armed hijackers board a luxury ocean liner in the South Pacific Ocean to loot it, only to do battle with a series of large-sized, tentacled, man-eating sea creatures who have taken over the ship first.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZWU3NTFjYjgtNmZhNi00YTU0LTg4YWQtZTI0YmVmYmExZjM2XkEyXkFqcGdeQXVyNDQwMTQ5ODk@._V1_SX300.jpg', 'Pelicula', 42, 'N/A', 1, NULL),
(126, 'Pinocchio', 'X', '1940-02-23', 88, 'Animation,Comedy,Family,', 116, 'A living puppet, with the help of a cricket as his conscience, must prove himself worthy to become a real boy.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU4Mzk3ODIyOF5BMl5BanBnXkFtZTgwODgyNzk2NjE@._V1_SX300.jpg', 'Pelicula', 43, 'N/A', 1, NULL),
(127, 'Shadow Conspiracy', 'R', '1997-01-31', 103, 'Action,Thriller,', 117, 'Bobby Bishop (Sheen) is a special assistant to the President of the United States. Accidentally, he meets his friend professor Pochenko on the street. Pochenko has time to tell Bishop about...', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA0MDUwODYwOV5BMl5BanBnXkFtZTcwNjY5ODUyMQ@@._V1_SX300.jpg', 'Pelicula', 42, 'N/A', 1, NULL),
(128, 'The Fugitive', 'PG_13', '1993-08-06', 130, 'Action,Crime,Drama,', 118, 'Dr. Richard Kimble, unjustly accused of murdering his wife, must find the real killer while being the target of a nationwide manhunt lead by a seasoned US Marshall.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU2OTkxNDA2OV5BMl5BanBnXkFtZTgwMzg3MjkyMTE@._V1_SX300.jpg', 'Pelicula', 1, 'N/A', 1, NULL),
(129, 'Rambo: First Blood Part II', 'R', '1985-05-22', 96, 'Action,Adventure,Thriller,', 117, 'John Rambo is released from prison by the government for a top-secret covert mission to the last place on Earth he\'d want to return - the jungles of Vietnam.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZWFkY2I1ZDAtNmZhNS00NjVlLWJiMGQtMGQ1ZmM0ZDA5ODg5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 44, 'N/A', 1, NULL),
(130, 'Sleepers', 'R', '1996-10-18', 147, 'Crime,Drama,Thriller,', 119, 'After a prank goes disastrously wrong, a group of boys are sent to a detention center where they are brutalized, over 10 years later, they get their chance for revenge.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc4OTUzNzc0MV5BMl5BanBnXkFtZTgwMjE4ODYxMTE@._V1_SX300.jpg', 'Pelicula', 1, 'N/A', 1, NULL),
(131, 'The Juror', 'R', '1996-02-02', 118, 'Drama,Thriller,', 120, '\"When Annie Laird is selected as a juror in a big Mafia trial, she is forced by someone known as \"\"The Teacher\"\" to persuade the other jurors to vote \"\"not guilty\"\". He threatens to kill her son...\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgwOTc5MjYzNl5BMl5BanBnXkFtZTcwMjYzMTYyMQ@@._V1_SX300.jpg', 'Pelicula', 37, 'N/A', 1, NULL),
(132, 'The Firm', 'R', '1993-06-30', 154, 'Drama,Thriller,', 121, 'A young lawyer joins a prestigious law firm only to discover that it has a sinister dark side.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgxMjM5NDYwM15BMl5BanBnXkFtZTgwODkzMzk5MDE@._V1_SX300.jpg', 'Pelicula', 18, 'N/A', 1, NULL),
(133, 'Boomerang', 'R', '1992-07-01', 117, 'Comedy,Drama,Romance,', 122, 'A successful executive and womanizer finds his lifestyle choices have turned back on him when his new female boss turns out to be an even bigger deviant than he is.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZDZmZDU5MGYtMTU3YS00NDczLWJmOTQtOTdlODk2NmMxZjllXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 18, 'N/A', 1, NULL),
(134, 'Cleopatra', 'G', '1963-07-31', 192, 'Biography,Drama,History,', 123, 'Historical epic. The triumphs and tragedy of the Egyptian queen, Cleopatra.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BY2YyOGFlZWItY2M5OC00NzJhLWJmNDgtZTVjNzIzMDI3YjgyL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_SX300.jpg', 'Pelicula', 8, 'N/A', 1, NULL),
(135, 'The Mirror Has Two Faces', 'PG_13', '1996-11-15', 126, 'Comedy,Drama,Romance,', 124, 'A shy, middle-aged professor enters into a romantic but non-physical relationship with an unlucky-in-love colleague.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYjMxMGVlMDMtNDczOC00YzJiLWIyNWYtNWE2NWZiY2I5Mjg3XkEyXkFqcGdeQXVyNjE5MjUyOTM@._V1_SX300.jpg', 'Pelicula', 37, 'N/A', 1, NULL),
(136, 'Licence to Kill', 'PG_13', '1989-07-14', 133, 'Action,Adventure,Thriller,', 125, 'James Bond goes rogue and sets off to unleash vengeance on a drug lord who tortured his best friend, a C.I.A. agent, and left him for dead and murdered his bride after he helped capture him.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODY3M2I0NGItYzJhNy00M2NiLThhMDgtNjZkNjA1NTQzMDM4XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg', 'Pelicula', 23, 'N/A', 1, NULL),
(137, 'Super Mario Bros.', 'PG', '1993-05-28', 104, 'Adventure,Comedy,Family,', 126, 'Two Brooklyn plumbers, Mario and Luigi, must travel to another dimension to rescue a princess from the evil dictator King Koopa and stop him from taking over the world.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzRmNGY0NTctYTNkNC00M2FkLWI0ZTgtYTE5ODhiZjYxMDkxXkEyXkFqcGdeQXVyNjE5MjUyOTM@._V1_SX300.jpg', 'Pelicula', 5, 'N/A', 1, NULL),
(138, 'The Karate Kid', 'PG', '1984-06-22', 126, 'Action,Drama,Family,', 127, 'A martial arts master agrees to teach karate to a bullied teenager.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNTkzY2YzNmYtY2ViMS00MThiLWFlYTEtOWQ1OTBiOGEwMTdhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 9, 'N/A', 1, NULL),
(139, 'Back to the Future Part II', 'PG', '1989-11-22', 108, 'Adventure,Comedy,Sci-Fi,', 128, 'After visiting 2015, Marty McFly must repeat his visit to 1955 to prevent disastrous changes to 1985...without interfering with his first trip.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZTMxMGM5MjItNDJhNy00MWI2LWJlZWMtOWFhMjI5ZTQwMWM3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 14, 'N/A', 1, NULL),
(140, 'A Time to Kill', 'R', '1996-07-24', 149, 'Crime,Drama,Thriller,', 104, 'In Canton, Mississippi, a fearless young lawyer and his assistant defend a black man accused of murdering two white men who raped his 10-year-old daughter, inciting a revolt by local racist groups.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BOWExZTg4ZWYtOTQxMi00YWZkLTkxYzgtOTg1MTUxNzNiNDcxL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 36, 'N/A', 1, NULL),
(141, 'A League of Their Own', 'PG', '1992-07-01', 128, 'Comedy,Drama,Family,', 129, 'Two sisters join the first female professional baseball league and struggle to help it succeed amidst their own growing rivalry.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODliMGQ1YzEtM2VhZi00MTU5LTllYTUtY2M3MDdjOTE4OGZlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 9, 'N/A', 1, NULL),
(142, 'Back to the Future Part III', 'PG', '1990-05-25', 118, 'Action,Adventure,Comedy,', 128, '\"Enjoying a peaceable existence in 1885, Doctor Emmet Brown is about to be killed by Buford \"\"Mad Dog\"\" Tannen. Marty McFly travels back in time to save his friend.\"', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYjhlMGYxNmMtOWFmMi00Y2M2LWE5NWYtZTdlMDRlMGEzMDA3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'Pelicula', 40, 'N/A', 1, NULL),
(143, 'Bram Stokers Dracula', 'R', '1992-11-13', 128, 'Fantasy,Horror,', 130, 'The centuries old vampire Count Dracula comes to England to seduce his barrister Jonathan Harker\'s fiancée Mina Murray and inflict havoc in the foreign land.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYyOTM5NzU3Nl5BMl5BanBnXkFtZTgwOTQxNjAxNzE@._V1_SX300.jpg', 'Pelicula', 9, 'N/A', 1, NULL),
(145, 'The Last Post', 'R', '2017-10-22', 0, 'Drama,', 131, 'The Last Post is set during the social and political unrest of the mid-sixties, in the simmering heat of Aden, Yemen, and centers on the lives of a unit of Royal Military Police officers and their families.', 'https://images-na.ssl-images-amazon.com/images/I/71xffY0h-iL._SX300_.jpg', 'Serie', 45, 'https://www.bbc.co.uk/mediacentre/mediapacks/the-last-post', 1, NULL),
(146, 'Master Of None', 'R', '2015-10-05', 0, 'Comedy,', 132, 'Comedy following the personal and professional challenges that face a 30-year-old New York actor, whose trials range from the immigrant experience to what pasta he should eat for dinner.', 'https://images-na.ssl-images-amazon.com/images/I/71abI2iL61L._SX300_.jpg', 'Serie', 46, 'https://www.netflix.com/title/80049714', 1, NULL),
(147, 'Girls5eva', 'PG_13', '2021-05-06', 0, 'Comedy,', 133, 'When a one-hit-wonder girl group from the 90\'s gets sampled by a young rapper, its members reunite to give their pop star dreams one more shot. They may be grown women balancing spouses, kids, jobs, debt, aging parents, and shoulder pain, but can\'t they also be Girls5eva?', 'https://m.media-amazon.com/images/I/71n8u2dRk+S._SX400_.jpg', 'Serie', 47, 'https://www.peacocktv.com/watch/asset/tv/girls5eva/8730283206775450112', 1, NULL),
(148, 'The Good Doctor', 'PG_13', '2017-09-25', 0, 'Drama,', 134, 'A talented young surgeon with savant syndrome ruffles feathers while saving lives at a prestigious hospital\'s pediatric surgical unit.', 'https://resizing.flixster.com/1FA52WNhxquNMl9O1F-0MuxXdzg=/206x305/v1.dDsyNjIwNjE7ajsxODgxMzsxMjAwOzIwMDA7MzAwMA', 'Serie', 48, 'https://abc.com/shows/the-good-doctor/', 1, NULL),
(149, 'Mythic Quest', 'R', '2020-02-07', 0, 'Comedy,', 135, '\"\"\"Mythic Quest: Ravens Banquet\"\" follows a team of video game developers as they navigate the challenges of running a popular video game.\"', 'https://resizing.flixster.com/4SVe3XMQ3TBpgnxN9LHSninwrSE=/206x305/v1.dDs2NDY4NjQ7ajsxODgxNzsxMjAwOzIwMDA7MzAwMA', 'Serie', 49, 'N/A', 1, NULL),
(150, 'Invincible', 'X', '2021-03-26', 0, 'Animation,Drama,', 136, 'From The Walking Dead creator Robert Kirkman, and based on the Skybound/Image comic of the same name by Kirkman, Cory Walker, and Ryan Ottley, Invincible is an adult animated superhero show that revolves around seventeen-year-old Mark Grayson (Steven Yeun), who\'s just like every other guy his age -- except that his father is the most powerful superhero on the planet, Omni-Man (J.K. Simmons). But as Mark develops powers of his own, he discovers that his father\'s legacy may not be as heroic as it seems.', 'https://resizing.flixster.com/4FXaPufvKhJnIf4yqChri9uQXeg=/206x305/v1.dDs4NTAwNDU7ajsxODgxOTsxMjAwOzQwNDs2MDg', 'Serie', 50, 'N/A', 1, NULL),
(151, 'The Underground Railroad', 'X', '2021-05-14', 0, 'Drama,', 137, 'From Academy Award® winner Barry Jenkins and based on the Pulitzer Prize winning novel by Colson Whitehead, The Underground Railroad chronicles Cora Randall\'s (newcomer Thuso Mbedu) desperate bid for freedom in the antebellum South. After escaping a Georgia plantation for the rumored Underground Railroad, Cora discovers no mere metaphor, but an actual railroad full of engineers and conductors, and a secret network of tracks and tunnels beneath the Southern soil.', 'https://resizing.flixster.com/FNbnxu5RhhSIGot1GbAIHzlhEhs=/206x305/v1.dDs4NTAwNDQ7ajsxODgxOTsxMjAwOzQwNDs2MDg', 'Serie', 51, 'N/A', 1, NULL),
(152, 'For All Mankind', 'PG_13', '2019-11-01', 0, 'Drama,', 138, 'For All Mankind\' presents an aspirational world where NASA astronauts, engineers and their families find themselves in the center of extraordinary events seen through the prism of an alternate history timeline -- a world in which the USSR beats the US to the moon', 'https://resizing.flixster.com/_Ur8qQFZBCON7kV4SutmuJjb8e4=/206x305/v1.dDs1OTE4MjU7ajsxODgxNjsxMjAwOzIwMDA7MzAwMA', 'Serie', 52, 'N/A', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productores`
--

CREATE TABLE `productores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productores`
--

INSERT INTO `productores` (`id`, `nombre`) VALUES
(1, 'Warner Bros. Pictures'),
(2, 'Sony/Columbia Pictures'),
(3, 'Touchstone Pictures'),
(4, 'Walt Disney Pictures'),
(5, 'Buena Vista'),
(6, 'Hollywood/Buena Vista'),
(7, 'Lionsgate Films'),
(8, '20th Century Fox'),
(9, 'Columbia Pictures'),
(10, 'Summit Entertainment'),
(11, 'Sony Pictures'),
(12, 'Focus Features'),
(13, 'New Line Cinema'),
(14, 'Universal Pictures'),
(15, 'Buena Vista Pictures'),
(16, 'DreamWorks SKG'),
(17, 'Lionsgate/Summit Entertainment'),
(18, 'Paramount Pictures'),
(19, 'MGM/UA'),
(20, 'Dimension Films'),
(21, 'Paramount Studios'),
(22, 'Rogue'),
(23, 'United Artists'),
(24, 'Universal Studios'),
(25, 'Lions Gate'),
(26, 'Sony Pictures Classics'),
(27, 'Miramax'),
(28, 'Dreamworks Pictures'),
(29, 'Paramount Vantage'),
(30, 'Weinstein Co.'),
(31, 'Miramax Films'),
(32, 'Sony Classic Pictures'),
(33, 'Sony/Screen Gems'),
(34, 'Screen Gems'),
(35, 'CBS Films'),
(36, 'Warner Home Video'),
(37, 'Sony Pictures Home Entertainment'),
(38, 'New Line Home Entertainment'),
(39, 'MGM Home Entertainment'),
(40, 'MCA Universal Home Video'),
(41, 'Paramount Home Video'),
(42, 'Hollywood Pictures'),
(43, 'RKO'),
(44, 'TriStar Pictures'),
(45, 'The Forge Entertainment'),
(46, 'Netflix'),
(47, 'Epic'),
(48, 'EnterMedia Content'),
(49, '3 Arts Entertainment'),
(50, 'Skybound'),
(51, 'Plan B Entertainment'),
(52, 'Sony Pictures Television');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temporadas`
--

CREATE TABLE `temporadas` (
  `id_serie` int(11) NOT NULL,
  `id_temporada` int(11) NOT NULL,
  `anyo_lanzamiento` year(4) NOT NULL,
  `guion` varchar(1000) NOT NULL,
  `num_capitulos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `temporadas`
--

INSERT INTO `temporadas` (`id_serie`, `id_temporada`, `anyo_lanzamiento`, `guion`, `num_capitulos`) VALUES
(145, 1, 2017, '\"The Last Post is old fashioned to a fault and features too many anachronisms to claim historical authenticity, but the series does provide a pleasing dose of escapism. \"', 6),
(146, 1, 2015, '\"Exceptionally executed with charm, humor, and heart, Master of None is a refreshingly offbeat take on a familiar premise. \"', 10),
(146, 2, 2017, '\"Master of None\'s second season picks up where its predecessor left off, delivering an ambitious batch of episodes that builds on the show\'s premise while adding surprising twists. \"', 10),
(146, 3, 2021, '\"Anchored by powerful performances from Lena Waithe and Naomi Ackie, Moments in Love is undeniably slow TV, but patient viewers will be rewarded with a surprising and mature season that wears its cinematic inspirations on its sleeve. \"', 5),
(147, 1, 2021, '\"Smart, funny, and just nostalgic enough, Girls5eva\'s intelligent insights are brought to brilliant life by its talented quartet, whose individual gifts come together to make sweet comedic harmony. \"', 8),
(148, 1, 2017, 'On the way to begin his surgical residency at San Jose St. Bonaventure Hospital, Dr. Shaun Murphy witnesses an airport sign fall and shatter glass onto a young boy. With his unique ability to visualize the internal body and using improvised methods and tools, Shaun is able to stabilize the boy. In a hospital board meeting, Dr. Aaron Glassman, president of the hospital, tries to convince the board to hire Shaun, despite his autism. Flashbacks give us a picture of Shaun\'s childhood and his motivation for becoming a doctor.', 18),
(148, 2, 2018, 'In performance reviews, Andrews, now president of the hospital, tells Shaun to learn to communicate, Claire to be more assertive, and Morgan to improve her teamwork. Jared, working his last day before moving to Denver, skips his. Jared and Shaun run a mobile clinic and meet Harry, a mentally unstable homeless man. When Shaun takes Jared\'s advice to spend time with Glassman, who is beginning his cancer treatment with Dr. Blaize (his last hire before being replaced),', 18),
(148, 3, 2019, 'Morgan and Park diagnose elderly patient Harvey with kidney cancer and compete over who will lead the surgery, as new Chief of Surgery Lim will allow third-year residents to do so. Due to Harvey\'s dementia, the two come together to convince his wife to leave the cancer untreated, so that he can enjoy his remaining time. Melendez, Shaun and Claire treat a newlywed bride with extensive cancer. Shaun proposes a radical, high-risk surgery.', 20),
(148, 4, 2020, '\"He hospital struggles against the COVID-19 pandemic and forces changes on the way they live: Shaun and Lea are obliged to remain apart, Park is staying with Shaun, Glassman works from home and Andrews sleeps in his garage to protect his wife. The situation takes its toll on everyone: Shaun struggles with being so far from Lea, Glassman becomes overprotective of Debbie to the point of annoyance and Lim & Claire become short-tempered.', 20),
(149, 1, 2020, 'Is nonetheless hilarious and stands out for exploring the gaming industry with intelligence, thoughtfulness, and sincerity.', 11),
(149, 2, 2021, 'Smartly written, sharply performed, and sentimental without losing its sense of humor, Mythic Quest\'s stellar second season solidifies its place as one of TV\'s best workplace comedies', 9),
(150, 1, 2021, 'With bold animation, bloody action, and an all-star cast led by the charming Steven Yeun, Invincible smartly adapts its source material without sacrificing its nuanced perspective on the price of superpowers', 8),
(151, 1, 2021, 'With a superb ensemble and Barry Jenkins\' singular eye, The Underground Railroad delicately translates its source material into a powerfully humane series that is as challenging as it is necessary', 10),
(152, 1, 2019, 'Though it shoots for the moon and falls somewhere in orbit, For All Mankind\'s impressive vision of history has the potential for real liftoff if it leans into the things that set it apart instead of settling for more of the same', 10),
(152, 2, 2020, 'For All Mankind\'s sophomore flight isn\'t without its hiccups, but compelling character work and a renewed sense of wonder make for thrilling viewing.', 10);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `top10peliculas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `top10peliculas` (
`produccion_id` int(11)
,`produccion_nombre` varchar(200)
,`valoracion_promedio` decimal(14,4)
,`cantidad_valoraciones` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `tipo` enum('usuario','admin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `usuario_insert_audit` AFTER INSERT ON `usuarios` FOR EACH ROW INSERT INTO usuario_auditoria (accion, usuario_id, fecha)
VALUES ('añadir', NEW.id, NOW())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_auditoria`
--

CREATE TABLE `usuario_auditoria` (
  `id` int(11) NOT NULL,
  `accion` varchar(10) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `usuario_id` int(11) DEFAULT NULL,
  `nombre_anterior` varchar(255) DEFAULT NULL,
  `nombre_nuevo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoraciones`
--

CREATE TABLE `valoraciones` (
  `id_produccion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `comentario` varchar(200) DEFAULT NULL,
  `valoracion` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `valoraciones`
--
DELIMITER $$
CREATE TRIGGER `actualiza_valoracion` AFTER INSERT ON `valoraciones` FOR EACH ROW UPDATE producciones SET valoracion_total = 
(SELECT AVG(Valoracion) AS valoracion_total
FROM valoraciones WHERE id_produccion = new.id_produccion) WHERE id = new.id_produccion
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualiza_valoracion2` AFTER DELETE ON `valoraciones` FOR EACH ROW UPDATE producciones SET valoracion_total = 
(SELECT AVG(Valoracion) AS valoracion_total
FROM valoraciones WHERE id_produccion = old.id_produccion) WHERE id = old.id_produccion
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visualizaciones`
--

CREATE TABLE `visualizaciones` (
  `id_usuario` int(11) NOT NULL,
  `id_produccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura para la vista `top10peliculas`
--
DROP TABLE IF EXISTS `top10peliculas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`batoi`@`%` SQL SECURITY DEFINER VIEW `top10peliculas`  AS  select `p`.`id` AS `produccion_id`,`p`.`titulo` AS `produccion_nombre`,avg(`v`.`valoracion`) AS `valoracion_promedio`,count(`v`.`valoracion`) AS `cantidad_valoraciones` from (`producciones` `p` join `valoraciones` `v` on(`p`.`id` = `v`.`id_produccion`)) group by `p`.`id`,`p`.`titulo` having count(`v`.`valoracion`) >= 5 order by avg(`v`.`valoracion`) desc,count(`v`.`valoracion`) desc limit 10 ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actores`
--
ALTER TABLE `actores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `actores_producciones`
--
ALTER TABLE `actores_producciones`
  ADD PRIMARY KEY (`id_produccion`,`id_actor`),
  ADD KEY `id_actor` (`id_actor`);

--
-- Indices de la tabla `directores`
--
ALTER TABLE `directores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `disponibilidad_plataforma`
--
ALTER TABLE `disponibilidad_plataforma`
  ADD PRIMARY KEY (`id_produccion`,`id_plataforma`) USING BTREE,
  ADD KEY `id_plataforma` (`id_plataforma`);

--
-- Indices de la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD PRIMARY KEY (`id_produccion`,`id_usuario`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producciones`
--
ALTER TABLE `producciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_productora` (`id_productora`),
  ADD KEY `director` (`director`),
  ADD KEY `director_2` (`director`);

--
-- Indices de la tabla `productores`
--
ALTER TABLE `productores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `temporadas`
--
ALTER TABLE `temporadas`
  ADD PRIMARY KEY (`id_serie`,`id_temporada`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `usuario_auditoria`
--
ALTER TABLE `usuario_auditoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD PRIMARY KEY (`id_produccion`,`id_usuario`) USING BTREE,
  ADD KEY `id_usuario` (`id_usuario`) USING BTREE;

--
-- Indices de la tabla `visualizaciones`
--
ALTER TABLE `visualizaciones`
  ADD KEY `id_produccion` (`id_produccion`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actores`
--
ALTER TABLE `actores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=551;

--
-- AUTO_INCREMENT de la tabla `directores`
--
ALTER TABLE `directores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=139;

--
-- AUTO_INCREMENT de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `producciones`
--
ALTER TABLE `producciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;

--
-- AUTO_INCREMENT de la tabla `productores`
--
ALTER TABLE `productores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario_auditoria`
--
ALTER TABLE `usuario_auditoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actores_producciones`
--
ALTER TABLE `actores_producciones`
  ADD CONSTRAINT `actores_producciones_ibfk_1` FOREIGN KEY (`id_produccion`) REFERENCES `producciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `actores_producciones_ibfk_2` FOREIGN KEY (`id_actor`) REFERENCES `actores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `disponibilidad_plataforma`
--
ALTER TABLE `disponibilidad_plataforma`
  ADD CONSTRAINT `disponibilidad_plataforma_ibfk_1` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `disponibilidad_plataforma_ibfk_2` FOREIGN KEY (`id_produccion`) REFERENCES `producciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD CONSTRAINT `favoritos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `favoritos_ibfk_2` FOREIGN KEY (`id_produccion`) REFERENCES `producciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producciones`
--
ALTER TABLE `producciones`
  ADD CONSTRAINT `producciones_ibfk_1` FOREIGN KEY (`id_productora`) REFERENCES `productores` (`id`),
  ADD CONSTRAINT `producciones_ibfk_2` FOREIGN KEY (`director`) REFERENCES `directores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `temporadas`
--
ALTER TABLE `temporadas`
  ADD CONSTRAINT `temporadas_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `producciones` (`id`);

--
-- Filtros para la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD CONSTRAINT `valoraciones_ibfk_1` FOREIGN KEY (`id_produccion`) REFERENCES `producciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `valoraciones_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `visualizaciones`
--
ALTER TABLE `visualizaciones`
  ADD CONSTRAINT `visualizaciones_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `visualizaciones_ibfk_2` FOREIGN KEY (`id_produccion`) REFERENCES `producciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
