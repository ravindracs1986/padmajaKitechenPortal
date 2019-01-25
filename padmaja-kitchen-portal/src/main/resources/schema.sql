CREATE TABLE job_portal.education (
  `Education_id` int(10) unsigned NOT NULL,
  `Degree` varchar(45) DEFAULT NULL,
  `Field_of_Study` varchar(45) DEFAULT NULL,
  `School_or_college` varchar(45) DEFAULT NULL,
  `From_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL
) ;

CREATE TABLE job_portal.authority (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ;

CREATE TABLE job_portal.job_tags (
  `job_tag_id` int(11) NOT NULL,
  `Job_tags` varchar(45) DEFAULT NULL,
  `jobs_details_id` int(11) DEFAULT NULL,
  `job_tag_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`job_tag_id`)
);


CREATE TABLE job_portal.jobs_details (
  `jobs_details_id` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `job_tags` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `application_email` varchar(45) DEFAULT NULL,
  `closing_date` date DEFAULT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `company_website` varchar(45) DEFAULT NULL,
  `company_discription` varchar(200) DEFAULT NULL,
  `jd_file` blob,
  PRIMARY KEY (`jobs_details_id`)
);
CREATE TABLE `job_portal.jobs_details_tag` (
  `jobs_details_id` int(11) NOT NULL,
  `job_tag_id` int(11) NOT NULL,
  PRIMARY KEY (`jobs_details_id`,`job_tag_id`),
  KEY `FK_JOB_TAG` (`job_tag_id`),
  CONSTRAINT `FK_JOBS_DETAILS` FOREIGN KEY (`jobs_details_id`) REFERENCES `jobs_details` (`jobs_details_id`),
  CONSTRAINT `FK_JOB_TAG` FOREIGN KEY (`job_tag_id`) REFERENCES `job_tags` (`job_tag_id`)
);

CREATE TABLE job_portal.profile (
  `userId` int(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `userType` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `otp` varchar(45) DEFAULT NULL,
  `logo` mediumblob,
  `CRT_TS` timestamp NULL DEFAULT NULL
);

CREATE TABLE job_portal.profile_dtl (
  `profile_dtl_id` int(11) NOT NULL,
  `profession_title` varchar(45) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `Web` varchar(45) DEFAULT NULL,
  `pre_hour` varchar(45) DEFAULT NULL,
  `Age` varchar(45) DEFAULT NULL,
  `resume` blob,
  `cover_later` blob,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`profile_dtl_id`)
) ;

CREATE TABLE job_portal.skills(
  `Skills_id` int(11) NOT NULL,
  `Skill_Name` varchar(45) DEFAULT NULL,
  `Skill_percentage` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Skills_id`)
);

CREATE TABLE job_portal.users (
  `id` int(10) unsigned NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `family_name` varchar(50) DEFAULT NULL,
  `e_mail` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `language` char(2) DEFAULT NULL,
  `id_picture` int(11) DEFAULT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `burth_date` date DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  UNIQUE KEY `login` (`login`)
);


CREATE TABLE job_portal.users_authority (
  `id` int(10) unsigned NOT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `id_authority` bigint(20) DEFAULT NULL
);

CREATE TABLE job_portal.work_experience (
  `Work_Experience_id` int(10) unsigned NOT NULL,
  `Company_Name` varchar(45) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `Date_Form` date DEFAULT NULL,
  `Date_To` date DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Work_Experience_id`)
);