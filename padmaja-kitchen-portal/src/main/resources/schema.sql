CREATE TABLE padmaja_kitchen.blog_details (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_name` varchar(45) DEFAULT NULL,
  `blog_image` longblob,
  `CRT_TS` timestamp NULL DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `paragraphOne` varchar(255) DEFAULT NULL,
  `paragraphTwo` varchar(255) DEFAULT NULL,
  `imageOneUrl` varchar(100) DEFAULT NULL,
  `paragraphThree` varchar(255) DEFAULT NULL,
  `imageTwoUrl` varchar(105) DEFAULT NULL,
  `paragraphFour` varchar(255) DEFAULT NULL,
  `paragraphFive` varchar(255) DEFAULT NULL,
  `paragraphSix` varchar(255) DEFAULT NULL,
  `youTubeVideoTitle` varchar(100) DEFAULT NULL,
  `youTubeVideoUrl` varchar(100) DEFAULT NULL,
  `recipeCardTitle` varchar(100) DEFAULT NULL,
  `recipeCardInsideTitle` varchar(100) DEFAULT NULL,
  `ingredientsDetails` varchar(255) DEFAULT NULL,
  `instructionsDetails` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE padmaja_kitchen.video_registration (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(45) DEFAULT NULL,
  `video_url` varchar(45) DEFAULT NULL,
  `video_category` varchar(45) DEFAULT NULL,
  `youtube_id` varchar(45) DEFAULT NULL,
  `CRT_TS` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);