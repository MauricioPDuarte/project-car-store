-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: car_store
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adicional`
--

DROP TABLE IF EXISTS `adicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adicional` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adicional`
--

LOCK TABLES `adicional` WRITE;
/*!40000 ALTER TABLE `adicional` DISABLE KEYS */;
INSERT INTO `adicional` VALUES (1,'IPVA Pago'),(2,'Blindado'),(3,'Aceita troca'),(4,'Uníco dono'),(5,'Garantia de fábrica');
/*!40000 ALTER TABLE `adicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adicional_veiculo`
--

DROP TABLE IF EXISTS `adicional_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adicional_veiculo` (
  `veiculo_id` int(11) NOT NULL,
  `adicional_id` int(11) NOT NULL,
  KEY `FK9g07g989b2782m4dc036yo28t` (`adicional_id`),
  KEY `FK8xac4c6fj011nip1qeidbm0x4` (`veiculo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adicional_veiculo`
--

LOCK TABLES `adicional_veiculo` WRITE;
/*!40000 ALTER TABLE `adicional_veiculo` DISABLE KEYS */;
INSERT INTO `adicional_veiculo` VALUES (1,1),(1,2),(1,3),(2,1),(3,4),(3,3),(3,5),(4,1),(4,2),(4,3),(4,5),(5,1),(5,2),(6,2),(6,3),(6,4),(7,1),(7,3),(8,1),(8,2),(8,4),(9,1),(9,2),(9,4),(9,5),(9,3),(10,1),(10,2),(11,2);
/*!40000 ALTER TABLE `adicional_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cambio`
--

DROP TABLE IF EXISTS `cambio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cambio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cambio`
--

LOCK TABLES `cambio` WRITE;
/*!40000 ALTER TABLE `cambio` DISABLE KEYS */;
INSERT INTO `cambio` VALUES (1,'Automática'),(2,'Manual'),(3,'CVT'),(4,'Automátizada');
/*!40000 ALTER TABLE `cambio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colaborador`
--

DROP TABLE IF EXISTS `colaborador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colaborador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_78aqrtg2ah8awl76h22m0iubj` (`email`) USING HASH
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colaborador`
--

LOCK TABLES `colaborador` WRITE;
/*!40000 ALTER TABLE `colaborador` DISABLE KEYS */;
INSERT INTO `colaborador` VALUES (1,'prussdev@gmail.com','Mauricio Pruss Duarte','$2a$10$15Pg6zUOAPFuyJq.lJrqnOHHOZVhssCgy5DGG5K59gjHUDZ5Lk6Yy'),(2,'prussdesign@gmail.com','Carlos da Silva','$2a$10$ya1oRnZd5RoNvRQYKQ3Fq./dys4SL1kC1mnb/VUNqtbmeq1xNzHBu'),(3,'julia.prussduarte@hotmail.com','Julia Pruss Duarte','$2a$10$oFWVrU4ey4dZfSdxtj1LuOtl00QEyEPUZha6HiOfy8erqJ4CakdAO');
/*!40000 ALTER TABLE `colaborador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combustivel`
--

DROP TABLE IF EXISTS `combustivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combustivel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combustivel`
--

LOCK TABLES `combustivel` WRITE;
/*!40000 ALTER TABLE `combustivel` DISABLE KEYS */;
INSERT INTO `combustivel` VALUES (1,'Gasolina'),(2,'Álcool'),(3,'Diesel'),(4,'Elétrico'),(5,'Gasolina e álcool'),(6,'Gasolina e elétrico'),(7,'Gasolina, álcool e gás natural'),(8,'Gasolina e gás natural'),(9,'Álcool e gás natural');
/*!40000 ALTER TABLE `combustivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cor`
--

DROP TABLE IF EXISTS `cor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cor`
--

LOCK TABLES `cor` WRITE;
/*!40000 ALTER TABLE `cor` DISABLE KEYS */;
INSERT INTO `cor` VALUES (1,'Preto'),(2,'Branco'),(3,'Azul'),(4,'Bege'),(5,'Prata');
/*!40000 ALTER TABLE `cor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Dodge'),(2,'Fiat'),(3,'Ford'),(4,'Volkswagen'),(5,'Chevrolet'),(6,'Hyundai'),(7,'BMW');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `marca_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKllxq2dldvhxvb5q9csar7vdfy` (`marca_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'Journey',1),(2,'Durango',1),(3,'Grand Siena',2),(4,'Polo',4),(5,'Fusion',3),(6,'Focus',3),(7,'Spin',5),(8,'HB20',6),(9,'X1',7),(10,'Elantra',6);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcional`
--

DROP TABLE IF EXISTS `opcional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcional` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcional`
--

LOCK TABLES `opcional` WRITE;
/*!40000 ALTER TABLE `opcional` DISABLE KEYS */;
INSERT INTO `opcional` VALUES (1,'Airbag'),(2,'Alarme'),(3,'Ar quente'),(4,'Banco com regulagem de altura'),(5,'CD Player'),(6,'Rádio'),(7,'Computador de bordo'),(8,'Controle de tração'),(9,'Desembaçador traseiro'),(10,'Ar condicionado'),(11,'Encosto de cabeça traseiro'),(12,'Freio ABS'),(13,'Controle automático de velocidade'),(14,'Retrovisores elétricos'),(15,'Rodas de liga leve'),(16,'Travas elétricas'),(17,'Vidros elétricos'),(18,'Volante com regulagem de altura'),(19,'Bancos de couro'),(20,'Direção hidraulica'),(21,'GPS'),(22,'Sensor de chuva'),(23,'Teto solar');
/*!40000 ALTER TABLE `opcional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcional_veiculo`
--

DROP TABLE IF EXISTS `opcional_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcional_veiculo` (
  `veiculo_id` int(11) NOT NULL,
  `opcional_id` int(11) NOT NULL,
  KEY `FKknsgtpeg2v4bfrq4ctphsra1y` (`opcional_id`),
  KEY `FKkm22h99q6u65ufkxqkuewk333` (`veiculo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcional_veiculo`
--

LOCK TABLES `opcional_veiculo` WRITE;
/*!40000 ALTER TABLE `opcional_veiculo` DISABLE KEYS */;
INSERT INTO `opcional_veiculo` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,6),(2,7),(2,8),(2,9),(2,10),(3,11),(3,12),(3,13),(3,14),(3,15),(3,1),(4,16),(4,17),(4,18),(4,19),(4,20),(5,21),(5,22),(5,23),(5,10),(5,12),(6,17),(6,3),(6,23),(6,15),(6,19),(7,1),(7,2),(7,9),(7,15),(7,17),(8,8),(8,2),(8,12),(8,20),(8,23),(9,23),(9,22),(9,7),(9,21),(9,17),(10,9),(10,10),(10,23),(10,11),(10,14),(11,1),(11,2),(11,6);
/*!40000 ALTER TABLE `opcional_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfis`
--

DROP TABLE IF EXISTS `perfis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfis` (
  `colaborador_id` int(11) NOT NULL,
  `perfis` int(11) DEFAULT NULL,
  KEY `FK16dlx5cpu6an0rexk1u73angk` (`colaborador_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfis`
--

LOCK TABLES `perfis` WRITE;
/*!40000 ALTER TABLE `perfis` DISABLE KEYS */;
INSERT INTO `perfis` VALUES (1,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `perfis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `thumbnail` bit(1) NOT NULL,
  `veiculo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKch87db08789t8e8gbscuf44kd` (`veiculo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Hatchback'),(2,'Sedan'),(3,'SUV'),(4,'Picape'),(5,'Minivan'),(6,'Esportivo');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(11) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `km_rodado` bigint(20) DEFAULT NULL,
  `num_portas` int(11) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `preco` double NOT NULL,
  `cambio_id` int(11) DEFAULT NULL,
  `combustivel_id` int(11) DEFAULT NULL,
  `cor_id` int(11) DEFAULT NULL,
  `tipo_id` int(11) DEFAULT NULL,
  `versao_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9oqfwf9cyveabervs3rehqoxn` (`cambio_id`),
  KEY `FKihb01yj2n4gg0x1lf9flfax34` (`combustivel_id`),
  KEY `FKkhe718h5b5wwhpigmicb15dns` (`cor_id`),
  KEY `FK8gfif71x78blemkq737naj0ni` (`tipo_id`),
  KEY `FK21upnqvntwd833oq5crfl57ht` (`versao_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,2019,'Veiculo em ótimo estado, nunca foi batido!',45000,4,'UTY-4343',25000.2,1,1,1,3,20),(2,2017,'Já teve 3 donos, já foi batido',200000,4,'ADY-4244',33000.2,2,8,2,1,11),(3,2014,'Carro super confortavel!',83456,4,'JKY-2763',36500.7,4,1,3,2,31),(4,2012,'Carro em perfeito estado, fazer as trocas dos pneus.',120000,4,'JCE-8242',55000.2,2,7,4,3,2),(5,2019,'Carro era utilizado para fazer offroad.',92000,4,'HFT-3232',120000.2,3,3,5,4,48),(6,2019,'Carro era utilizado para fazer fretes, nos correios. Carro faz um barulho na roda dianteira',82450,4,'GFE-3434',126000.2,3,7,1,5,84),(7,2009,'Carro em perfeito estado, utilizado apenas por uma familia',10300,4,'HHE-2224',226000.2,4,4,4,1,90),(8,2014,'Em ótimas condições',2000,4,'KHK-7524',23609.3,3,6,3,2,137),(9,2017,'Carro precisa ser reparado algumas partes da lataria',89600,4,'GSK-6424',63604.64,1,1,2,1,101),(10,2020,'Só comprar e andar',2000,4,'LSK-9824',90000.64,1,8,1,1,126),(11,2020,'Muito bom!',9000,4,'LGK-5824',99000.64,2,1,4,6,28);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `versao`
--

DROP TABLE IF EXISTS `versao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `versao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `modelo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnw4cw299lfoqdxn2is52u6s9t` (`modelo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `versao`
--

LOCK TABLES `versao` WRITE;
/*!40000 ALTER TABLE `versao` DISABLE KEYS */;
INSERT INTO `versao` VALUES (1,'JOURNEY RT 2.7 V6 185CV AUT.',1),(2,'JOURNEY SXT 2.7 V6 185CV AUT.',1),(3,'JOURNEY SE 2.7 V6 185CV AUT.',1),(4,'JOURNEY SXT 3.6 V6 AUT.',1),(5,'JOURNEY RT  3.6 V6 AUT.',1),(6,'JOURNEY CROSSROAD 3.6 V6 AUT.',1),(7,'JOURNEY RT 3.6 AWD V6 AUT.',1),(8,'DURANGO CREW 3.6 24V 4X4 AUT.',2),(9,'DURANGO CITADEL 3.6 24V 4X4 AUT.',2),(10,'DURANGO LIMITED 3.6 24V 4X4 AUT.',2),(11,'GRAND SIENA ESSENCE 1.6 FLEX 16V',3),(12,'GRAND SIENA TETRAFUEL 1.4 EVO F. FLEX 8V',3),(13,'GRAND SIENA ATTRAC. 1.4 EVO F.FLEX 8V',3),(14,'GRAND SIENA ESSENCE DUAL. 1.6 FLEX 16V',3),(15,'GRAND SIENA ESSEN.SUBLIME 1.6 FLEX',3),(16,'GRAND SIENA ESSEN.SUBLIME DUAL. 1.6 FLEX',3),(17,'GRAND SIENA ESSEN. ITALIA DUAL. 1.6 FLEX',3),(18,'GRAND SIENA ESSENCE ITALIA 1.6 FLEX 16V',3),(19,'GRAND SIENA ATTRACTIVE 1.0 FLEX 8V 4P',3),(20,'FUSION HYBRID 2.5 16V 193CV AUT.',5),(21,'FUSION SEL 2.3 16V  162CV AUT.',5),(22,'FUSION SEL 2.5 16V 173CV AUT.',5),(23,'FUSION SEL 3.0 V6  24V 243CV AUT.',5),(24,'FUSION SEL 3.0 V6 AWD 24V 243CV AUT.',5),(25,'FUSION TITANIUM 2.0 GTDI ECO. AWD AUT.',5),(26,'FUSION TITANIUM 2.0 GTDI ECO. FWD AUT.',5),(27,'FUSION 2.5L I-VCT FLEX AUT.',5),(28,'FUSION TITANIUM HYBRID 2.0 145CV AUT.',5),(29,'FUSION SE 2.5 I-VCT FLEX 16V AUT.',5),(30,'FUSION SEL 2.0 ECOBO. 16V 248CV AUT.',5),(31,'FUSION HYBRID 2.5 16V 193CV AUT.',6),(32,'FUSION SEL 2.3 16V  162CV AUT.',6),(33,'FUSION SEL 3.0 V6  24V 243CV AUT.',6),(34,'FUSION SEL 3.0 V6 AWD 24V 243CV AUT.',6),(35,'FUSION TITANIUM 2.0 GTDI ECO. FWD AUT.',6),(36,'FUSION 2.5L I-VCT FLEX AUT.',6),(37,'FUSION TITANIUM HYBRID 2.0 145CV AUT.',6),(38,'FUSION SE 2.5 I-VCT FLEX 16V AUT.',6),(39,'FUSION SEL 2.0 ECOBO. 16V 248CV AUT.',6),(40,'FUSION SEL 3.0 V6  24V 243CV AUT.',6),(41,'FUSION SEL 3.0 V6 AWD 24V 243CV AUT.',6),(42,'FUSION TITANIUM 2.0 GTDI ECO. AWD AUT.',6),(43,'FUSION TITANIUM 2.0 GTDI ECO. FWD AUT.',6),(44,'FUSION 2.5L I-VCT FLEX AUT.',6),(45,'FUSION TITANIUM HYBRID 2.0 145CV AUT.',6),(46,'FUSION SE 2.5 I-VCT FLEX 16V AUT.',6),(47,'FUSION SEL 2.0 ECOBO. 16V 248CV AUT.',6),(48,'POLO BLUEMOTION 1.6 TOTAL FLEX 8V 5P',4),(49,'POLO GT 2.0 MI TOTAL FLEX 8V 5P',4),(50,'POLO 1.0 MI 79CV 16V 5P',4),(51,'POLO 1.6 E-FLEX 8V 5P',4),(52,'POLO 1.6 MI/ S.OURO 1.6MI 101CV 8V 5P',4),(53,'POLO 1.6 MI/S.OURO 1.6 MI TOT.FLEX 8V 5P',4),(54,'POLO 2.0 MI 116CV 8V 5P',4),(55,'POLO CLASSIC 1.0 MI 16V  65CV 4P',4),(56,'POLO CLASSIC/ SPECIAL 1.8 MI',4),(57,'POLO GTI 1.8 MI 150CV 20V TURBO 3P',4),(58,'POLO I MOTION 1.6 TOTAL FLEX  5P',4),(59,'POLO NEXT 1.6 MI 101CV 8V 5P',4),(60,'POLO SPORTLINE 1.6 MI TOTAL FLEX 8V 5P',4),(61,'POLO SPORTLINE I MOTION 1.6 T.FLEX 5P',4),(62,'POLO SED. COMFORT. 1.6 MI TOT. FLEX 8V',4),(63,'POLO SED./SED. COMF. 2.0/2.0 FLEX 8V 4P',4),(64,'POLO SED.COMFORT. I MOTION 1.6 T.FLEX 4P',4),(65,'POLO SEDAN 1.6 MI 101CV 8V 4P',4),(66,'POLO SEDAN 1.6 MI TOTAL FLEX 8V 4P',4),(67,'POLO SEDAN EVIDENCE 1.6 MI T.FLEX 8V 4P',4),(68,'POLO SEDAN I MOTION  1.6 TOTAL FLEX  4P',4),(69,'POLO SPORTLINE 2.0 MI TOTAL FLEX 8V 5P',4),(70,'POLO 1.6 MI FLEX 8V 4P',4),(71,'POLO 1.0 FLEX 12V 5P',4),(72,'POLO 1.6 MSI FLEX 16V 5P',4),(73,'POLO COMFORT. 200 TSI 1.0 FLEX 12V AUT.',4),(74,'POLO HIGHLINE 200 TSI 1.0 FLEX 12V AUT.',4),(75,'POLO 1.6 MSI TOTAL FLEX 16V 5P AUT',4),(76,'POLO SENSE 200 TSI 1.0 FLEX 12V AUT(PCD)',4),(77,'SPIN LTZ 1.8 8V ECONO.FLEX 5P AUT.',7),(78,'SPIN LT 1.8 8V ECONO.FLEX 5P MEC.',7),(79,'SPIN LTZ 1.8 8V ECONO.FLEX 5P MEC.',7),(80,'SPIN LT 1.8 8V ECONO.FLEX 5P AUT.',7),(81,'SPIN LS 1.8 8V ECONO.FLEX 5P MEC.',7),(82,'SPIN ADVANTAGE 1.8 8V ECONO.FLEX 5P AUT.',7),(83,'SPIN ADVANTAGE 1.8 8V ECONO.FLEX 5P MEC.',7),(84,'SPIN ACTIV 1.8 8V ECONO. FLEX 5P AUT.',7),(85,'SPIN ACTIV 1.8 8V ECONO. FLEX 5P MEC.',7),(86,'SPIN ACTIV7 1.8 8V ECONO.FLEX 5P AUT.',7),(87,'SPIN PREMIER 1.8 8V ECONO.FLEX 5P AUT.',7),(88,'SPIN PREMIER 1.8 8V ECONO.FLEX 5P MEC.',7),(89,'HB20 C./C.PLUS/C.STYLE 1.6 FLEX 16V MEC.',8),(90,'HB20 PREMIUM 1.6 FLEX 16V MEC.',8),(91,'HB20 COMF./C.PLUS/C.STYLE 1.0 FLEX 12V',8),(92,'HB20 C.STYLE/C.PLUS 1.6 FLEX 16V AUT.',8),(93,'HB20 PREMIUM 1.6 FLEX 16V AUT.',8),(94,'HB20 COPA DO MUNDO 1.0 FLEX 12V MEC.',8),(95,'HB20 COPA DO MUNDO 1.6 FLEX 16V AUT.',8),(96,'HB20 COPA DO MUNDO 1.6 FLEX 16V MEC.',8),(97,'HB20 FOR YOU 1.0 FLEX 12V 5P',8),(98,'HB20 S FOR YOU 1.0 FLEX 12V 4P',8),(99,'HB20 SPICY 1.0 FLEX 12V MEC.',8),(100,'HB20 SPICY 1.6 FLEX 16V AUT.',8),(101,'HB20 SPICY 1.6 FLEX 16V MEC.',8),(102,'HB20 R SPEC 1.6 AUTOMATICO.',8),(103,'HB20 R SPEC 1.6 MANUAL',8),(104,'HB20 R SPEC 1.6 FLEX 16V AUT.',8),(105,'HB20 R SPEC 1.6 FLEX 16V MEC.',8),(106,'HB20 COMFORT PLUS 1.0 TB FLEX 12V MEC.',8),(107,'HB20 COMFORT STYLE 1.0 TB FLEX 12V MEC.',8),(108,'HB20 OCEAN 1.0 FLEX 12V 5P MEC.',8),(109,'HB20 OCEAN 1.6 FLEX 16V 5P AUT.',8),(110,'HB20 OCEAN 1.6 FLEX 16V 5P MEC.',8),(111,'1.0 OCEAN',8),(112,'COMFORT STYLE 1.0 TURBO',8),(113,'R-SPEC 1.6 AUTOMATICO',8),(114,'R-SPEC 1.6 MANUAL',8),(115,'HB20 5 ANOS 1.0 FLEX 12V MEC.',8),(116,'HB20 5 ANOS 1.6 FLEX 16V AUT.',8),(117,'HB20 R SPEC LIMITED 1.6 FLEX 16V AUT.',8),(118,'HB20 1 MILLION 1.6 FLEX 16V AUT.',8),(119,'HB20 UNIQUE 1.0 FLEX 12V MEC.',8),(120,'ELANTRA GL',10),(121,'ELANTRA GLS 1.6',10),(122,'ELANTRA GLS 1.8 16V',10),(123,'ELANTRA GLS 2.0 16V AUT.',10),(124,'ELANTRA GLS 2.0 16V MEC.',10),(125,'ELANTRA WAGON 1.8 16V',10),(126,'ELANTRA GLS 2.0 16V FLEX AUT.',10),(127,'ELANTRA GLS 1.8 16V MEC.',10),(128,'ELANTRA GLS 1.8 16V AUT.',10),(129,'ELANTRA 2.0 16V FLEX AUT.',10),(130,'ELANTRA SPECIAL EDIT. 2.0 16V FLEX AUT.',10),(131,'ELANTRA GLS 2.0 16V MEC.',9),(132,'ELANTRA WAGON 1.8 16V',9),(133,'ELANTRA GLS 2.0 16V FLEX AUT.',9),(134,'ELANTRA GLS 1.8 16V MEC.',9),(135,'ELANTRA GLS 1.8 16V AUT.',9),(136,'ELANTRA 2.0 16V FLEX AUT.',9),(137,'ELANTRA SPECIAL EDIT. 2.0 16V FLEX AUT.',9);
/*!40000 ALTER TABLE `versao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-11 21:44:10
