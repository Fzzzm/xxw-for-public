use test;
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jobName` varchar(255) DEFAULT null COMMENT '��������',
  `jobCompany` varchar(255) DEFAULT NULL COMMENT '��˾����',
  `salary` varchar(255) DEFAULT NULL COMMENT 'нˮ��Χ',
  `minSalary` varchar(255) DEFAULT NULL COMMENT '���н��',
  `maxSalary` varchar(255) DEFAULT NULL COMMENT '���н��',
  `jobAddress` varchar(255) DEFAULT NULL COMMENT '�����ص�',
  `experience` varchar(255) DEFAULT NULL COMMENT '��������',
  `education` varchar(255) DEFAULT NULL COMMENT 'ѧ��Ҫ��',
  `industry` varchar(255) DEFAULT NULL COMMENT '����',
  `growth` varchar(255) DEFAULT NULL COMMENT '�������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;