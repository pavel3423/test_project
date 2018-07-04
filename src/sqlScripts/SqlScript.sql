DROP DATABASE IF EXISTS `test_project`;
CREATE DATABASE IF NOT EXISTS `test_project`;
USE `test_project`;

DROP TABLE IF EXISTS `tasks`;
CREATE TABLE IF NOT EXISTS `tasks` (
  `task_id` int(11) NOT NULL,
  `action` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `executions`;
CREATE TABLE IF NOT EXISTS `executions` (
  `execution_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`execution_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `executions_tasks`;
CREATE TABLE IF NOT EXISTS `executions_tasks` (
  `execution_execution_id` int(11) NOT NULL,
  `tasks_task_id` int(11) NOT NULL,
  UNIQUE KEY `UK_9hnssdktipj8874ivftccopi3` (`tasks_task_id`),
  KEY `FKnilboixvsrkf4jljmu879y8hd` (`execution_execution_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;