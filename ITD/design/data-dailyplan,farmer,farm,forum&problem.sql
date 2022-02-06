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


-- Farmer Data;
insert into farmer(farmerid, name, phonenumber, password) values("1", "Dream","00000001","00000001");
insert into farmer(farmerid, name, phonenumber, password) values("2", "Kumar","00000002","00000002");
insert into farmer(farmerid, name, phonenumber, password) values("3", "Manohar Lal Khattar","00000003","00000003");
insert into farmer(farmerid, name, phonenumber, password) values("4", "Manoharlal","00000004","00000004");
insert into farmer(farmerid, name, phonenumber, password) values("5", "Raj Lal Vasani","00000005","00000005");
insert into farmer(farmerid, name, phonenumber, password) values("6", "Anand","00000006","00000006");
insert into farmer(farmerid, name, phonenumber, password) values("7", "Anil","00000007","00000007");
insert into farmer(farmerid, name, phonenumber, password) values("8", "Bharat","00000008","00000008");
insert into farmer(farmerid, name, phonenumber, password) values("9", "Dinesh","00000009","00000009");
insert into farmer(farmerid, name, phonenumber, password) values("10", "Ganesh","00000010","00000010");
insert into farmer(farmerid, name, phonenumber, password) values("11", "Jayant","00000011","00000011");
insert into farmer(farmerid, name, phonenumber, password) values("12", "Kishore","00000012","00000012");
insert into farmer(farmerid, name, phonenumber, password) values("13", "Krishna","00000013","00000013");
insert into farmer(farmerid, name, phonenumber, password) values("14", "Naresh","00000014","00000014");
insert into farmer(farmerid, name, phonenumber, password) values("15", "Nirmal","00000015","00000015");
insert into farmer(farmerid, name, phonenumber, password) values("16", "Raj","00000016","00000016");
insert into farmer(farmerid, name, phonenumber, password) values("17", "Rakesh","00000017","00000017");
insert into farmer(farmerid, name, phonenumber, password) values("18", "Sanjay","00000018","00000018");
insert into farmer(farmerid, name, phonenumber, password) values("19", "Vijay","00000019","00000019");
insert into farmer(farmerid, name, phonenumber, password) values("20", "Virendra","00000020","00000020");
insert into farmer(farmerid, name, phonenumber, password) values("21", "Ansuya2","00000021","00000021");
insert into farmer(farmerid, name, phonenumber, password) values("22", "Bimla","00000022","00000022");
insert into farmer(farmerid, name, phonenumber, password) values("23", "Indira","00000023","00000023");
insert into farmer(farmerid, name, phonenumber, password) values("24", "Jyoti","00000024","00000024");
insert into farmer(farmerid, name, phonenumber, password) values("25", "Kamla","00000025","00000025");
insert into farmer(farmerid, name, phonenumber, password) values("26", "Nita","00000026","00000026");
insert into farmer(farmerid, name, phonenumber, password) values("27", "Pushpa","00000027","00000027");
insert into farmer(farmerid, name, phonenumber, password) values("28", "Rama","00000028","00000028");
insert into farmer(farmerid, name, phonenumber, password) values("29", "Rupa","00000029","00000029");
insert into farmer(farmerid, name, phonenumber, password) values("30", "Vanita","00000030","00000030");
insert into farmer(farmerid, name, phonenumber, password) values("31", "Kumar","00000031","00000031");
insert into farmer(farmerid, name, phonenumber, password) values("32", "Parkash","00000032","00000032");
insert into farmer(farmerid, name, phonenumber, password) values("33", "Chander","00000033","00000033");
insert into farmer(farmerid, name, phonenumber, password) values("34", "Lal","00000034","00000034");
insert into farmer(farmerid, name, phonenumber, password) values("35", "Nath","00000035","00000035");
insert into farmer(farmerid, name, phonenumber, password) values("36", "Das","00000036","00000036");
insert into farmer(farmerid, name, phonenumber, password) values("37", "Datt","00000037","00000037");
insert into farmer(farmerid, name, phonenumber, password) values("38", "Dev","00000038","00000038");
insert into farmer(farmerid, name, phonenumber, password) values("39", "Kumari","00000039","00000039");
insert into farmer(farmerid, name, phonenumber, password) values("40", "Rani","00000040","00000040");
insert into farmer(farmerid, name, phonenumber, password) values("41", "Lakshmi","00000041","00000041");
insert into farmer(farmerid, name, phonenumber, password) values("42", "Devi","00000042","00000042");
insert into farmer(farmerid, name, phonenumber, password) values("43", "Chopra","00000043","00000043");
insert into farmer(farmerid, name, phonenumber, password) values("44", "Desai","00000044","00000044");
insert into farmer(farmerid, name, phonenumber, password) values("45", "Gupta","00000045","00000045");
insert into farmer(farmerid, name, phonenumber, password) values("46", "Parekh","00000046","00000046");
insert into farmer(farmerid, name, phonenumber, password) values("47", "Patel","00000047","00000047");
insert into farmer(farmerid, name, phonenumber, password) values("48", "Vadgama","00000048","00000048");
insert into farmer(farmerid, name, phonenumber, password) values("49", "Rakesh","00000049","00000049");
insert into farmer(farmerid, name, phonenumber, password) values("50", "Narendra","00000050","00000050");

-- bind farmer and farm
insert into farmer_farm (farm, farmer)
	select farmid, farmerid from farm join farmer on farmer.phonenumber = farm.farmer;
    
    
-- Farm Data    
insert into farm(acreage, farmer, area) values("1321", "00000001", "1");
insert into farm(acreage, farmer, area) values("1323", "00000002", "1");
insert into farm(acreage, farmer, area) values("1324", "00000003", "1");
insert into farm(acreage, farmer, area) values("1325", "00000004", "1");
insert into farm(acreage, farmer, area) values("1326", "00000005", "2");
insert into farm(acreage, farmer, area) values("1326", "00000006", "2");
insert into farm(acreage, farmer, area) values("1326", "00000007", "3");
insert into farm(acreage, farmer, area) values("1326", "00000008", "4");
insert into farm(acreage, farmer, area) values("1326", "00000009", "4");
insert into farm(acreage, farmer, area) values("1326", "00000010", "5");
insert into farm(acreage, farmer, area) values("1326", "00000011", "5");
insert into farm(acreage, farmer, area) values("1326", "00000012", "6");
insert into farm(acreage, farmer, area) values("1326", "00000013", "6");
insert into farm(acreage, farmer, area) values("1326", "00000014", "6");
insert into farm(acreage, farmer, area) values("1326", "00000015", "7");
insert into farm(acreage, farmer, area) values("1326", "00000016", "8");
insert into farm(acreage, farmer, area) values("1326", "00000017", "9");
insert into farm(acreage, farmer, area) values("1326", "00000018", "9");
insert into farm(acreage, farmer, area) values("1326", "00000019", "10");
insert into farm(acreage, farmer, area) values("1326", "00000020", "10");
insert into farm(acreage, farmer, area) values("1326", "00000021", "10");
insert into farm(acreage, farmer, area) values("1326", "00000022", "10");
insert into farm(acreage, farmer, area) values("1326", "00000023", "11");
insert into farm(acreage, farmer, area) values("1326", "00000024", "11");
insert into farm(acreage, farmer, area) values("1326", "00000025", "12");
insert into farm(acreage, farmer, area) values("1326", "00000026", "12");
insert into farm(acreage, farmer, area) values("1326", "00000027", "13");
insert into farm(acreage, farmer, area) values("1326", "00000028", "13");
insert into farm(acreage, farmer, area) values("1326", "00000029", "14");
insert into farm(acreage, farmer, area) values("1326", "00000030", "15");
insert into farm(acreage, farmer, area) values("1326", "00000031", "16");
insert into farm(acreage, farmer, area) values("1326", "00000032", "17");
insert into farm(acreage, farmer, area) values("1326", "00000033", "18");
insert into farm(acreage, farmer, area) values("1326", "00000034", "18");
insert into farm(acreage, farmer, area) values("1326", "00000035", "19");
insert into farm(acreage, farmer, area) values("1326", "00000036", "20");
insert into farm(acreage, farmer, area) values("1326", "00000037", "21");
insert into farm(acreage, farmer, area) values("1326", "00000038", "22");
insert into farm(acreage, farmer, area) values("1326", "00000039", "23");
insert into farm(acreage, farmer, area) values("1326", "00000040", "24");
insert into farm(acreage, farmer, area) values("1326", "00000041", "25");
insert into farm(acreage, farmer, area) values("1326", "00000042", "26");
insert into farm(acreage, farmer, area) values("1326", "00000043", "27");
insert into farm(acreage, farmer, area) values("1326", "00000044", "28");
insert into farm(acreage, farmer, area) values("1326", "00000045", "29");
insert into farm(acreage, farmer, area) values("1326", "00000046", "30");
insert into farm(acreage, farmer, area) values("1326", "00000047", "31");
insert into farm(acreage, farmer, area) values("1326", "00000048", "32");
insert into farm(acreage, farmer, area) values("1326", "00000049", "33");
insert into farm(acreage, farmer, area) values("1326", "00000050", "33");


-- Forum Data;
insert into forum(forumid) values("1");

insert into post(postid, title, content, time, farmer, forum) values("1", "title1", "content1","2022-02-01 12:23:44","1","1");
insert into post(postid, title, content, time, farmer, forum) values("2", "title2", "content2","2022-02-01 14:23:44","2","1");
insert into post(postid, title, content, time, farmer, forum) values("3", "title3", "content3","2022-02-01 16:23:44","3","1");
insert into post(postid, title, content, time, farmer, forum) values("4", "title4", "content4","2022-02-01 18:23:44","4","1");
insert into post(postid, title, content, time, farmer, forum) values("5", "title4", "content4","2022-02-01 19:23:44","5","1");
insert into post(postid, title, content, time, farmer, forum) values("6", "title4", "content4","2022-02-01 21:23:44","6","1");
insert into post(postid, title, content, time, farmer, forum) values("7", "title4", "content4","2022-02-01 22:25:44","7","1");
insert into post(postid, title, content, time, farmer, forum) values("8", "title4", "content4","2022-02-01 23:23:44","8","1");
insert into post(postid, title, content, time, farmer, forum) values("9", "title4", "content4","2022-02-02 18:23:44","9","1");

insert into comment(content, time, farmer, post) values("comment1", "2022-02-01 13:45:44","1","1");
insert into comment(content, time, farmer, post) values("comment2", "2022-02-01 13:46:44","2","1");
insert into comment(content, time, farmer, post) values("comment3", "2022-02-01 13:48:44","3","1");
insert into comment(content, time, farmer, post) values("comment4", "2022-02-01 13:50:44","4","1");
insert into comment(content, time, farmer, post) values("comment5", "2022-02-01 14:45:44","5","1");
insert into comment(content, time, farmer, post) values("comment6", "2022-02-01 15:45:44","6","1");
insert into comment(content, time, farmer, post) values("comment7", "2022-02-01 15:45:44","7","1");
insert into comment(content, time, farmer, post) values("comment8", "2022-02-01 15:45:44","8","1");
insert into comment(content, time, farmer, post) values("comment9", "2022-02-01 15:45:44","9","1");
insert into comment(content, time, farmer, post) values("comment10", "2022-02-01 15:45:44","10","1");

insert into comment(content, time, farmer, post) values("comment1", "2022-02-01 13:45:44","1","2");
insert into comment(content, time, farmer, post) values("comment2", "2022-02-01 13:46:44","2","2");
insert into comment(content, time, farmer, post) values("comment3", "2022-02-01 13:48:44","3","2");
insert into comment(content, time, farmer, post) values("comment4", "2022-02-01 13:50:44","4","2");
insert into comment(content, time, farmer, post) values("comment5", "2022-02-01 14:45:44","5","2");
insert into comment(content, time, farmer, post) values("comment6", "2022-02-01 15:45:44","6","2");
insert into comment(content, time, farmer, post) values("comment7", "2022-02-01 15:45:44","7","2");
insert into comment(content, time, farmer, post) values("comment8", "2022-02-01 15:45:44","8","2");
insert into comment(content, time, farmer, post) values("comment9", "2022-02-01 15:45:44","9","2");
insert into comment(content, time, farmer, post) values("comment10", "2022-02-01 15:45:44","10","2");

insert into comment(content, time, farmer, post) values("comment1", "2022-02-01 13:45:44","1","3");
insert into comment(content, time, farmer, post) values("comment2", "2022-02-01 13:46:44","2","3");
insert into comment(content, time, farmer, post) values("comment3", "2022-02-01 13:48:44","3","3");
insert into comment(content, time, farmer, post) values("comment4", "2022-02-01 13:50:44","4","3");
insert into comment(content, time, farmer, post) values("comment5", "2022-02-01 14:45:44","5","3");
insert into comment(content, time, farmer, post) values("comment6", "2022-02-01 15:45:44","6","3");
insert into comment(content, time, farmer, post) values("comment7", "2022-02-01 15:45:44","7","3");
insert into comment(content, time, farmer, post) values("comment8", "2022-02-01 15:45:44","8","3");
insert into comment(content, time, farmer, post) values("comment9", "2022-02-01 15:45:44","9","3");
insert into comment(content, time, farmer, post) values("comment10", "2022-02-01 15:45:44","10","3");

insert into comment(content, time, farmer, post) values("comment1", "2022-02-01 13:45:44","1","4");
insert into comment(content, time, farmer, post) values("comment2", "2022-02-01 13:46:44","2","4");
insert into comment(content, time, farmer, post) values("comment3", "2022-02-01 13:48:44","3","4");
insert into comment(content, time, farmer, post) values("comment4", "2022-02-01 13:50:44","4","4");
insert into comment(content, time, farmer, post) values("comment5", "2022-02-01 14:45:44","5","4");
insert into comment(content, time, farmer, post) values("comment6", "2022-02-01 15:45:44","6","4");
insert into comment(content, time, farmer, post) values("comment7", "2022-02-01 15:45:44","7","4");
insert into comment(content, time, farmer, post) values("comment8", "2022-02-01 15:45:44","8","4");
insert into comment(content, time, farmer, post) values("comment9", "2022-02-01 15:45:44","9","4");
insert into comment(content, time, farmer, post) values("comment10", "2022-02-01 15:45:44","10","4");

insert into comment(content, time, farmer, post) values("comment1", "2022-02-01 13:45:44","1","5");
insert into comment(content, time, farmer, post) values("comment2", "2022-02-01 13:46:44","2","5");
insert into comment(content, time, farmer, post) values("comment3", "2022-02-01 13:48:44","3","5");
insert into comment(content, time, farmer, post) values("comment4", "2022-02-01 13:50:44","4","5");
insert into comment(content, time, farmer, post) values("comment5", "2022-02-01 14:45:44","5","5");
insert into comment(content, time, farmer, post) values("comment6", "2022-02-01 15:45:44","6","5");
insert into comment(content, time, farmer, post) values("comment7", "2022-02-01 15:45:44","7","5");
insert into comment(content, time, farmer, post) values("comment8", "2022-02-01 15:45:44","8","5");
insert into comment(content, time, farmer, post) values("comment9", "2022-02-01 15:45:44","9","5");
insert into comment(content, time, farmer, post) values("comment10", "2022-02-01 15:45:44","10","5");


-- Problem Data, only for "1" Farmer; 
insert into problem(title, request,farmer) values("problem1", "content1","1");
insert into problem(title, request,farmer) values("problem2", "content2","1");
insert into problem(title, request,farmer) values("problem3", "content3","1");
insert into problem(title, request,farmer) values("problem4", "content4","1");
insert into problem(title, request,farmer) values("problem5", "content5","1");
insert into problem(title, request,farmer) values("problem6", "content6","1");
insert into problem(title, request,farmer) values("problem7", "content7","1");
insert into problem(title, request,farmer) values("problem8", "content8","1");
insert into problem(title, request,farmer) values("problem9", "content9","1");
insert into problem(title, request,farmer) values("problem10", "content10","1");