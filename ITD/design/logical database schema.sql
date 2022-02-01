-- db name: dream

create table `area` (
    `areaid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `coords` varchar(1000) NOT NULL,
    `image` varchar(30),
    
    PRIMARY KEY (`areaid`)
);

create table `farmer` (
    `farmerid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `phonenumber` varchar(45) NOT NULL,
    `password` varchar(45) NOT NULL,
    `performance` int default -1,

    PRIMARY KEY (`farmerid`),
    UNIQUE KEY `farmerphonenumber_UNIQUE` (`phonenumber`)
);

create table `policymaker` (
    `policymakerid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `email` varchar(45) NOT NULL,
    `password` varchar(45) NOT NULL,

    PRIMARY KEY (`policymakerid`),
    UNIQUE KEY `pmemail_UNIQUE` (`email`)
);

create table `agronomist` (
    `agronomistid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `email` varchar(45) NOT NULL,
    `password` varchar(45) NOT NULL,
    `area` int(11),

    PRIMARY KEY (`agronomistid`),
    UNIQUE KEY `agemail_UNIQUE` (`email`),
    CONSTRAINT `fk_agronomist_area` FOREIGN KEY (`area`) REFERENCES `area`(`areaid`)
);

create table `farm` (
    `farmid` int(11) NOT NULL AUTO_INCREMENT,
    `location` varchar(45) NOT NULL,
    `acreage` DECIMAL(9 , 2 ) NOT NULL,
    `farmer` varchar(45),
    `area` int(11),

    PRIMARY KEY (`farmid`),
    CONSTRAINT `fk_farm_farmer` FOREIGN KEY (`farmer`) REFERENCES `farmer`(`phonenumber`),
    CONSTRAINT `fk_farm_area` FOREIGN KEY (`area`) REFERENCES `area`(`areaid`)
);

create table `problem` (
    `problemid` int(11) NOT NULL AUTO_INCREMENT,
    `request` nvarchar(2000) NOT NULL,
    `requestime` DATETIME,
    `answer` nvarchar(2000),
    `answertime` DATETIME,
    `feedback` int(11),
    `feedbacktime` DATETIME,
    `farmer` int(11),
    `agronomist` int(11),

    PRIMARY KEY (`problemid`),
    CONSTRAINT `fk_problem_farmer` FOREIGN KEY (`farmer`) REFERENCES `farmer`(`farmerid`),
    CONSTRAINT `fk_problem_agronomist` FOREIGN KEY (`agronomist`) REFERENCES `agronomist`(`agronomistid`)
);

create table `report` (
    `reportid` int(11) NOT NULL AUTO_INCREMENT,
    `type` varchar(45) NOT NULL,
    `amount` DECIMAL(9 , 2 ) NOT NULL,
    `startime` DATE NOT NULL,
    `endtime` DATE NOT NULL,
    `acreage` DECIMAL(9 , 2 ) NOT NULL,
    `farmer` int(11) NOT NULL,

    PRIMARY KEY (`reportid`),
    CONSTRAINT `fk_report_farmer` FOREIGN KEY (`farmer`) REFERENCES `farmer`(`farmerid`)
);

create table `dailyplan` (
    `dailyplanid` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(45) NOT NULL,
    `date` DATE NOT NULL,
    `content` nvarchar(2000) NOT NULL,
    `status` int(11),
    `deviation` nvarchar(2000),
    `agronomist` int(11) NOT NULL,

    PRIMARY KEY (`dailyplanid`),
	UNIQUE KEY `dailyplantitle_UNIQUE` (`title`),
    UNIQUE KEY `dailyplandate_UNIQUE` (`date`),
    
    CONSTRAINT `fk_dailyplan_agronomist` FOREIGN KEY (`agronomist`) REFERENCES `agronomist`(`agronomistid`)
);

create table `farmerInDailyPlan` (
    `dailyplanid` int(11) NOT NULL,
    `farmerid` int(11) NOT NULL,

    PRIMARY KEY (`dailyplanid`, `farmerid`),
    CONSTRAINT `fk_farmerInDailyPlan_farmer` FOREIGN KEY (`farmerid`) REFERENCES `farmer`(`farmerid`),
    CONSTRAINT `fk_farmerInDailyPlan_dailyplan` FOREIGN KEY (`dailyplanid`) REFERENCES `dailyplan`(`dailyplanid`)
);

create table `forum` (
    `forumid` int(11) NOT NULL AUTO_INCREMENT,

    PRIMARY KEY (`forumid`)
);

create table `post` (
    `postid` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(45) NOT NULL,
    `content` nvarchar(2000) NOT NULL,
    `time` DATETIME NOT NULL,
    `farmer` int(11) NOT NULL,
    `forum` int(11) NOT NULL,

    PRIMARY KEY (`postid`),

    CONSTRAINT `fk_post_farmer` FOREIGN KEY (`farmer`) REFERENCES `farmer`(`farmerid`),
    CONSTRAINT `fk_post_forum` FOREIGN KEY (`forum`) REFERENCES `forum`(`forumid`)
);

create table `comment` (
    `commentid` int(11) NOT NULL AUTO_INCREMENT,
    `content` nvarchar(2000) NOT NULL,
    `time` DATETIME NOT NULL,
    `farmer` int(11) NOT NULL,
    `post` int(11) NOT NULL,

    PRIMARY KEY (`commentid`),

    CONSTRAINT `fk_comment_farmer` FOREIGN KEY (`farmer`) REFERENCES `farmer`(`farmerid`),
    CONSTRAINT `fk_comment_post` FOREIGN KEY (`post`) REFERENCES `post`(`postid`)
);