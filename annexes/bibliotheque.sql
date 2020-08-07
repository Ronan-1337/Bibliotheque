
-- -----------------------------------------------------
-- Table `livre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `livre` ;
CREATE TABLE IF NOT EXISTS `livre` (
  `idlivre` INT NOT NULL AUTO_INCREMENT,
  `titre` VARCHAR(100) NOT NULL,
  `description` LONGTEXT NULL,
  `isbn` VARCHAR(13) NOT NULL,
  `code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idlivre`),
  UNIQUE (`isbn`),
  UNIQUE (`titre`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `utilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `utilisateur` ;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idutilisateur` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `datenaissance` DATE NULL,
  `role` VARCHAR(20) NULL,
  `pseudo` VARCHAR(45) NOT NULL,
  `motdepasse` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idutilisateur`),
  UNIQUE (`pseudo`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `auteur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `auteur` ;
CREATE TABLE IF NOT EXISTS `auteur` (
  `idauteur` INT NOT NULL AUTO_INCREMENT,
  `auteur` VARCHAR(45) NULL,
  PRIMARY KEY (`idauteur`),
  UNIQUE (`auteur`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `emplacement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emplacement` ;
CREATE TABLE IF NOT EXISTS `emplacement` (
  `idemplacement` INT NOT NULL AUTO_INCREMENT,
  `nomemplacement` VARCHAR(45) NULL,
  PRIMARY KEY (`idemplacement`),
  UNIQUE (`nomemplacement`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `theme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `theme` ;
CREATE TABLE IF NOT EXISTS `theme` (
  `idtheme` INT NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(45) NULL,
  PRIMARY KEY (`idtheme`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exemplaire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplaire` ;
CREATE TABLE IF NOT EXISTS `exemplaire` (
  `idexemplaire` INT NOT NULL AUTO_INCREMENT,
  `disponibilite` BOOLEAN NOT NULL DEFAULT true,
  `fk_idlivre` INT NOT NULL,
  PRIMARY KEY (`idexemplaire`),
  FOREIGN KEY (`fk_idlivre`) REFERENCES `livre`(`idlivre`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `emprunt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emprunt` ;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `idemprunt` INT NOT NULL AUTO_INCREMENT,
  `dateemprunt` DATETIME NULL,
  `fk_idutilisateur` INT NOT NULL,
  `fk_idexemplaire` INT NOT NULL,
  PRIMARY KEY (`idemprunt`),
  FOREIGN KEY (`fk_idutilisateur`) REFERENCES `utilisateur`(`idutilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`fk_idexemplaire`) REFERENCES `exemplaire`(`idexemplaire`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `livre_auteur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `livre_auteur` ;
CREATE TABLE IF NOT EXISTS `livre_auteur` (
  `fk_idlivre` INT NOT NULL,
  `fk_idauteur` INT NOT NULL,
   FOREIGN KEY (`fk_idlivre`) REFERENCES `livre` (`idlivre`) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (`fk_idauteur`) REFERENCES `auteur` (`idauteur`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `livre_themes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `livre_theme` ;
CREATE TABLE IF NOT EXISTS `livre_theme` (
  `fk_idtheme` INT NOT NULL,
  `fk_idlivre` INT NOT NULL,
  FOREIGN KEY (`fk_idtheme`) REFERENCES `theme`(`idtheme`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`fk_idlivre`) REFERENCES `livre`(`idlivre`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `emplacement_livre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emplacement_livre` ;
CREATE TABLE IF NOT EXISTS `emplacement_livre` (
  `fk_idemplacement` INT NOT NULL,
  `fk_idlivre` INT NOT NULL,
  FOREIGN KEY (`fk_idemplacement`) REFERENCES `emplacement`(`idemplacement`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`fk_idlivre`) REFERENCES `livre`(`idlivre`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;



INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(1, 'Pierre', 'Durant', '2016-08-24', 'lectuer', 'pdurant', 'pdurant');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(2, 'John', 'Picsou', '2015-03-10', 'lecteur', 'john', 'john');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(3, 'Balthazar', 'Picsou', '1988-09-12', 'lecteur', 'balthazar', 'balthazar');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(4, 'Sire Emeric', 'McPicsou', '2005-12-10', 'lecteur', 'emeric', 'emeric');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(5, 'Jack', 'McPicsou', '2001-02-15', 'lecteur', 'jack', 'jack');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(6, 'Matilda', 'Picsou', '2015-09-22', 'lecteur', 'matilda', 'matilda');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(7, 'Gédéon', 'Picsou', '2010-11-20', 'lecteur', 'gedeon', 'gedeon');
INSERT INTO utilisateur(idutilisateur, nom, prenom, datenaissance, role, pseudo, motdepasse) VALUES(8, 'Donald', 'Duck', '2009-01-01', 'bibliothécaire', 'donald', 'donald');

INSERT INTO auteur(idauteur, auteur) VALUES(1, 'JD Salinger');
INSERT INTO auteur(idauteur, auteur) VALUES(2, 'F. Scott. Fitzgerald');
INSERT INTO auteur(idauteur, auteur) VALUES(3, 'Jane Austen');
INSERT INTO auteur(idauteur, auteur) VALUES(4, 'Scott Hanselman');
INSERT INTO auteur(idauteur, auteur) VALUES(5, 'Jason N. Gaylord');
INSERT INTO auteur(idauteur, auteur) VALUES(6, 'Pranav Rastogi');
INSERT INTO auteur(idauteur, auteur) VALUES(7, 'Todd Miranda');
INSERT INTO auteur(idauteur, auteur) VALUES(8, 'Christian Wenz');

INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(1, 'Le receveur dans le seigle', 'Le receveur dans le seigle', '9780321543257', '9780201379');
INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(2, 'Neuf histoires', 'Neuf histoires', '978032154333', '9780201333');
INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(3, 'Franny et Zooey', 'Franny et Zooey', '9780321543222', '9780201222');
INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(4, 'Gatsby le magnifique', 'Gatsby le magnifique', '9780321543111', '9780201111');
INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(5, 'Tender id la nuit', 'Tender id la nuit', '9780321543999', '9780201999');
INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(6, 'Fierté et préjugés', 'Fierté et préjugés', '9780321543777', '9780201777');
INSERT INTO livre(idlivre, titre, description, isbn, code) VALUES(7, 'ASP.NET 4.5 professionnel en C # et VB', 'ASP.NET 4.5 professionnel en C # et VB', '9780321543555', '9780201555');

INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(1, 'coul1cas1');
INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(2, 'coul1cas2');
INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(3, 'coul2cas1');
INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(4, 'coul2cas2');
INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(5, 'coul2cas3');
INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(6, 'coul2cas4');
INSERT INTO emplacement(idemplacement, 	nomemplacement) VALUES(7, 'coul2cas5');

INSERT INTO theme(idtheme, theme) VALUES(1, 'Programmation');
INSERT INTO theme(idtheme, theme) VALUES(2, 'Fiction');
INSERT INTO theme(idtheme, theme) VALUES(3, 'Roman');
INSERT INTO theme(idtheme, theme) VALUES(4, 'Policier');
INSERT INTO theme(idtheme, theme) VALUES(5, 'Philosophie');
INSERT INTO theme(idtheme, theme) VALUES(6, 'Histoire');

INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(1,1);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(2,1);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(3,1);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(4,2);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(5,2);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(6,3);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(7,4);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(7,5);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(7,6);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(7,7);
INSERT INTO livre_auteur(fk_idlivre , 	fk_idauteur) VALUES(7,8);

INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(1, 7);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(2, 4);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(3, 5);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(3, 1);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(4, 5);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(5, 6);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(6, 3);
INSERT INTO livre_theme(fk_idtheme, fk_idlivre) VALUES(6, 2);

INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(1,1);
INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(2,2);
INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(3,3);
INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(4,4);
INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(5,5);
INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(6,6);
INSERT INTO emplacement_livre(fk_idemplacement, fk_idlivre) VALUES(7,7);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(1, 0, 1);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(2, 0, 1);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(3, 0, 1);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(4, 0, 1);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(5, 1, 1);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(6, 1, 1);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(7, 0, 2);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(8, 0, 2);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(9, 1, 2);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(10, 1, 2);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(11, 1, 2);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(12, 1, 2);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(13, 1, 3);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(14, 1, 3);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(15, 1, 3);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(16, 1, 3);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(17, 1, 3);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(18, 1, 3);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(19, 1, 4);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(20, 1, 4);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(21, 1, 4);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(22, 1, 4);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(23, 1, 4);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(24, 1, 4);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(25, 1, 5);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(26, 1, 5);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(27, 1, 5);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(28, 1, 5);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(29, 1, 5);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(30, 1, 5);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(31, 1, 6);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(32, 1, 6);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(33, 1, 6);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(34, 1, 6);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(35, 1, 6);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(36, 1, 6);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(37, 1, 6);

INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(38, 0, 7);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(39, 1, 7);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(40, 1, 7);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(41, 1, 7);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(42, 1, 7);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(43, 1, 7);
INSERT INTO exemplaire(idexemplaire, disponibilite, fk_idlivre) VALUES(44, 1, 7);

INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(1, '2020-08-19 00:39:30', 1, 1);
INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(2, '2020-08-19 00:39:30', 2, 2);
INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(3, '2020-08-19 00:39:30', 3, 3);
INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(4, '2020-08-19 00:39:30', 4, 4);
INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(5, '2020-08-19 00:39:30', 4, 8);
INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(6, '2020-08-19 00:39:30', 3, 7);
INSERT INTO emprunt(idemprunt, dateemprunt, fk_idutilisateur, fk_idexemplaire) VALUES(7, '2020-08-19 00:39:30', 3, 38);





