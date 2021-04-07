##孔航社区

##资料

[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)

[es](https://elasticsearch.cn/explore)

[Github deploy key](https://docs.github.com/en/developers/overview/managing-deploy-keys#deploy-keys)

[Bootstrap](https://docs.github.com/en/developers/apps/creating-an-oauth-app)

[Github OAuth](https://docs.github.com/en/developers/apps/creating-an-oauth-app)

[Spring](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation)

[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#introducing-thymeleaf)

##工具

[Git](https://git-scm.com/downloads)

[Visual Paradigm](https://www.visual-paradigm.com)

[Flyway](https://flywaydb.org/documentation/getstarted/firststeps/maven)

[Lombok](https://projectlombok.org/)

##脚本

```sql
create table USER
(
	ID INT auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);


```
```bash
mvn flyway:migrate
```