# pom.xml 추가설정

## querydsl

```xml
//의존성 부분
<dependency>
  <groupId>com.querydsl</groupId>
  <artifactId>querydsl-apt</artifactId>
  <scope>provided</scope>
</dependency>
<dependency>
  <groupId>com.querydsl</groupId>
  <artifactId>querydsl-jpa</artifactId>
</dependency>
//플러그인 부분

<plugin>
  <groupId>com.mysema.maven</groupId>
  <artifactId>apt-maven-plugin</artifactId>
  <version>1.1.3</version>
  <executions>
    <execution>
    <goals>
      <goal>process</goal>
    </goals>
    <configuration>
      <outputDirectory>target/generated-sources/java</outputDirectory>
      <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
      <options>
      <querydsl.entityAccessors>true</querydsl.entityAccessors>
      </options>
    </configuration>
    </execution>
  </executions>
</plugin>
```
