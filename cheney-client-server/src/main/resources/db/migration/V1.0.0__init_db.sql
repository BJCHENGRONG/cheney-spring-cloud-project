CREATE DATABASE IF NOT EXISTS `mybatis_plus` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

/**
1、文件脚本默认在resources.db.migration目录下
2、文件命名规则：
    前缀：V用于版本化、U用于撤销、R可重复迁移
    版本：带点或下划线的版本根据需要分开，可重复迁移不需要
    分隔符：__默认两个下划线
    说明：sql描述
    后缀：.sql
*/

--
-- USE
-- `aj_report`;
--
-- CREATE TABLE `flyway_schema_history`
-- (
--     `installed_rank` int(11) NOT NULL,
--     `version`        varchar(50)            DEFAULT NULL,
--     `description`    varchar(200)  NOT NULL,
--     `type`           varchar(20)   NOT NULL,
--     `script`         varchar(1000) NOT NULL,
--     `checksum`       int(11) DEFAULT NULL,
--     `installed_by`   varchar(100)  NOT NULL,
--     `installed_on`   timestamp     NOT NULL DEFAULT current_timestamp(),
--     `execution_time` int(11) NOT NULL,
--     `success`        tinyint(1) NOT NULL,
--     PRIMARY KEY (`installed_rank`),
--     KEY              `flyway_schema_history_s_idx` (`success`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
-- insert into `flyway_schema_history`(`installed_rank`, `version`, `description`, `type`, `script`, `checksum`,
--                                     `installed_by`, `installed_on`, `execution_time`, `success`)
-- values (1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'admin', now(), 0, 1);
