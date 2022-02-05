/*
-- Query: SELECT * FROM dream.dailyplan
LIMIT 0, 1000

-- Date: 2022-02-05 00:31
*/
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag01@email.com', 'ag01', '12345678', 1);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag02@email.com', 'ag02', '12345678', 2);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag03@email.com', 'ag03', '12345678', 3);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag04@email.com', 'ag04', '12345678', 4);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag05@email.com', 'ag05', '12345678', 5);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag06@email.com', 'ag06', '12345678', 6);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag07@email.com', 'ag07', '12345678', 7);
INSERT INTO AGRONOMIST (EMAIL, NAME, PASSWORD, area) VALUES ('ag08@email.com', 'ag08', '12345678', 8);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (1,'Dailyplan2211','2020-01-01','1、Basic information\r\nFarmer name:  Zhang\r\nPhone Number：3425708\r\nArea ID： 1\r\nFarm ID:  4\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：partly cloudy\r\nTemperature forecast：42.8-53.6℉\r\nSoil Moisure：\r\n\r\n3、last visit report\r\n3.1 There are lesions, lesions of different shapes.\r\n3.2 There are mildew or powdery substances on the lesions; different colors, no odor.\r\n\r\n4、Analyze result\r\nbacterial disease\r\n\r\n5、Visit goal\r\n the bacteria-carrying plants should be collected and brought to the laboratory for pathological analysis.',1,'1、data deviation\r\nWeather forecast：sunny\r\nTemperature forecast：55.2-72.5℉\r\nSoil Moisture：132mm\r\n\r\n2、Farmer interview\r\nAt first, Zhang thought that the shrinkage of the leaves was due to insufficient fertilizer. After increasing the fertilizer for a week, he found that the situation became worse, and more and more surrounding plants also showed similar symptoms.',1);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (2,'Dailyplan2212','2020-01-02','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',1,'1、data deviation\r\nWeather forecast：sunny\r\nTemperature forecast：55.2-60.2℉\r\nSoil Moisture：150mm\r\n\r\n2、Farmer interview\r\nThe farmer in charge of this area wants to try cross-planting peppers in the open space of the farmland, and hopes to get the advice of the agronomist',2);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (3,'Dailyplan2213','2020-01-03','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',0,null,3);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (4,'Dailyplan2214','2020-01-04','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',1,'no abnormality',4);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (5,'Dailyplan2215','2020-01-05','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',1,'no abnormality',5);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (6,'Dailyplan2216','2020-01-06','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',0,null,6);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (7,'Dailyplan2217','2020-01-07','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',0,null,7);
INSERT INTO `dailyplan` (`dailyplanid`,`title`,`date`,`content`,`status`,`deviation`,`agronomist`) VALUES (8,'Dailyplan8','2020-01-08','1、Basic information\r\nFarmer name:  maria\r\nPhone Number：3425709\r\nArea ID： 2\r\nFarm ID:  1\r\nLocation：link\r\n\r\n2、Data forecast\r\nWeather forecast：sunny\r\nTemperature forecast：46.8-58.6℉\r\nSoil Moisture：155mm\r\n\r\n3、last visit report\r\nAll indicators are normal, and the crops are in good condition.\r\n\r\n4、Analyze result\r\nnull\r\n5、Visit goal\r\nRegular return visit and observation',1,'no abnormality',8);
