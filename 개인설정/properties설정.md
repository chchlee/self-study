# properties 설정

## application.properties 서버 포트

```properties
server.port = 8080

# 서버와 클라이언트가 커넥션을 맺고, 응답하지 않으면 끊게 설정. timeout 30s 설정
server.tomcat.connection-timeout = 30s

# 스레드 풀의 최대값과 최솟값 설정. 런타임 도중 필요한 스레드를 생성하는 시간과 비용이 높아 보통 같게 사용할 때가 많음.
server.tomcat.threads.max = 100
server.tomcat.threads.min-spare = 100

# 톰캣 서버의 엑세스 로그 사용 여부
server.tomcat.access.log.enabled = true

# 톰캣 액세스 로그의 파일 이름 수정
server.tomcat.access.suffix = log
server.tomcat.access.prefix = access.log

# 날짜가 지난 톰캣 액세스 로그에 타임 스탬프 추가
server.tomcat.access.rename-on-rotate = true
```

## paging 파라미터의 이름을 변경하는 application.properties 설정

```properties
# HTTP 파라미터 이름인 page 대신 pageNumber로 변경할 수 있는 설정
spring.data.web.pageable.page-parameter = pageNumber

# HTTP 파라미터 이름인 size 대신 pageSize로 변경할 수 있는 설정
spring.data.web.pageable.size-parameter = pageSize

# HTTP 파라미터 이름인 sort 대신 sortOrder로 변경할 수 있는 설정
spring.data.web.sort.sort-parameter = sortOrder

# 기본 페이지 크기 설정. 페이지 크기에 대응되는 파라미터가 없다면 20개가 기본
spring.data.web.pageable.default-page-size = 20

# 한 번에 조회할 수 있는 페이지 크기 최댓값 설정
spring.data.web.pageable.max-page-size = 2000

# 페이지 파라미터는 기본 0으로 시작하지만(개발자의 고질병. 0으로 시작 숫자 1로 시작하고 싶으면 true로)
spring.data.web.pageable.one-indexed-parameters = false
```

## JPA application.properties 설정

```properties
# MySQL8 설정
spring.datasource.url=jdbc:mysql://localhost:3306/스키마명?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=아이디
spring.datasource.password=비밀번호
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA 설정
# Hibernate가 실행하는 SQL 쿼리를 콘솔에 출력
spring.jpa.show-sql=true

# Hibernate가 사용하는 데이터베이스 유형을 지정 (여기서는 MySQL 8)
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# Hibernate가 사용할 데이터베이스 플랫폼을 지정 (여기서는 MySQL)
spring.jpa.database=mysql

# 데이터베이스 초기화 방법 설정 ('none'은 아무런 작업도 수행하지 않음)
spring.jpa.hibernate.ddl-auto=none

# Hibernate의 네이밍 전략 설정 (CamelCase를 underscore 형태로 변환)
spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy

# Hibernate의 물리 네이밍 전략 설정 (엔티티의 필드명을 그대로 테이블의 컬럼명으로 사용)
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

# JPA가 데이터베이스 DDL을 자동 생성하지 않게 설정
spring.jpa.generate-ddl=false

# Hibernate가 콘솔에 출력하는 SQL의 가독성을 높여주는 설정
spring.jpa.properties.hibernate.format_sql=true

# Hibernate가 지연 로딩을 사용하여 트랜잭션 밖에서도 엔티티를 로드할 수 있게 해주는 설정 (성능 이슈를 야기할 수 있음)
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true

```

### 참고

```
none : DB구조는 변경되지 않음
update : 변경된 스키마만 적용
create : 시작될 때만 drop하고 다시 생성
create-drop : 시작과 종료에서 모두 drop
(hibernate 4)

spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy

(hibernate 5)

spring.jpa.hibernate.naming.implicit-strategy

=org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
```

## application.properties에서 Hikari DataSource 설정

```properties
## DataSource Type Configuration. 어떤 구현체를 사용할지 명시적으로 설정. Hikari를 사용
spring.datasource.type=com.zaxxer.hikari.HikariDataSource

## Hikari DataSource Configuration

### MySQL 서버의 시간대역을 설정하는 것으로 시간대 설정
spring.datasource.hikari.jdbc-url=jdbc:mysql://127.0.0.1:3306/account-mysql?serverTimeZone = UTC
spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver

spring.datasource.hikari.username=root
spring.datasource.hikari.password=password

### Connection 객체를 받아오는 최대 대기 시간. 스프링 트랙잭션 모듈이 이 시간동안 Connection 객체를 받아오지 못하면 예외(SQLException) 발생
spring.datasource.hikari.connection-timeout=5000

### HikariDataSource의 데이터베이스 커넥션 풀에서 관리할 수 있는 최대 커넥션 개수
spring.datasource.hikari.maximum-pool-size=5
spring.datasource.hikari.max-lifetime=18000000
spring.datasource.hikari.idle-timeout=600000

# spring.datasource.hikari.connection-test-query = select 1
```

## application-test-h2.properties 설정

```properties
spring.main.web-application-type = none

## JPA configuration
spring.jpa-open-in-view = false
spring.jpa.show.sql = true
spring.jpa.properties.hibernate.format_sql = true
spring.jpa.properties.hibernate.generate_statistics = true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto = create
```

```java
@DataJpaTest
@TestPropertiesSource(locations="classpath:application-test-h2.properties")
class HelloTest {
  ...
}
```

