# bookshelf-manager
这个是一个有待扩展开发的工程，旨在最终实现可以同时实现书本管理和自习室座位管理的的目的。

This is a project waiting to be developed, witch is aiming to obtain the goal of managing books and self learning seats.

# 更新日志

截止到2023年3月20日10点21分，完成了前6个功能，并且基本实现了目标。

# 主要依赖说明

主要的依赖已经在pom.xml中说明。

没有引入tomcat，运行需要在本地安装tomcat，然后将`tomcat\lib`作为依赖添加给工程。

另外需要：

-   数据库 -- MySQL；
-   Maven

下面是mysql表格的建表语句：

```mysql
# books的建表语句。
# 涉及到了users表格的主键，所以建议在最后创建。

CREATE TABLE `books` (
  `bookid` int NOT NULL AUTO_INCREMENT,
  `bookname` varchar(64) NOT NULL,
  `bookauthor` varchar(64) DEFAULT NULL,
  `bookdescription` varchar(255) DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `userid` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7087461 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

```mysql
# users 的建表语句。

CREATE TABLE `users` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

因为开发的时候用的也是假数据，所以这里不展示数据内容了。

# 功能说明

下面是主要界面：

<img src="C:\Users\zht08\OneDrive\01repo-tian\02notes\mybatis-itheima-note\codes\mybatis-bookshelf-manager\README.assets\image-20230320101959256.png" alt="image-20230320101959256" style="zoom:67%;" />

点击功能超链接，按照说明操作即可。

**特别说明：**

绑定使用人时，需要添加新的使用人和新的book，如果使用已经存在的，会出现MySQL语法错误。
