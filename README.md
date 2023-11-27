# CellExercise
My pet project about the some frameworks in Java


## Status CI Integration
 
[] TODO in CircleCI

## Getting started

### Prerequisites

* Java 1.8 or more
* IDE or text editor
* Maven 

### Installing

* Clone the project with _git-clone_ (or download directly it)
* Have fun!


## Running the tests

* Run _mvn test_

### How to use

You can call the Controller using the script CMD in the directory _/src/test/resources_

* curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8081/orderedCellEvent

The other service is not yet implemented because of the bug in running that blocked the application. The deatils are below in the section "Problem in running"

### Coding styles sheets

* Please read the file [CONTRIBUTING.md](http://github.com/alepuzio/My-Vertx-Kata/CONTRIBUTING.md)

## Deployment

* Clone the project with _git clone_
* Install the artifact with _mvn clean install_
* Run the application with __java -jar $ABSOLUTE_PATH_TO_TARGET_DIRECTORY/CellExercise-0.0.1-SNAPSHOT.jar__
* The database is H2 running in memory, no external db engine is needed. 


### Problem in running

Unfortunately, the application is not runnable because a problem with the ORM Hibernate when it works with the H2 database of the application.

Running the _mvn spring-boot:run_, the console shows the message below

```
023-11-27T00:35:27.669+01:00 ERROR 8280 --- [           main] j.LocalContainerEntityManagerFactoryBean : Failed to initialize JPA EntityManagerFactory: Could not determine recommended JdbcType for Java type 'net.alepuzio.cellexercise.persistence.entity.Cell'
2023-11-27T00:35:27.670+01:00  WARN 8280 --- [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Could not determine recommended JdbcType for Java type 'net.alepuzio.cellexercise.persistence.entity.Cell'
2023-11-27T00:35:27.670+01:00  INFO 8280 --- [           main] o.s.j.d.e.EmbeddedDatabaseFactory        : Shutting down embedded database: url='jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false'
2023-11-27T00:35:27.677+01:00  INFO 8280 --- [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2023-11-27T00:35:27.691+01:00  INFO 8280 --- [           main] .s.b.a.l.ConditionEvaluationReportLogger : 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2023-11-27T00:35:27.713+01:00 ERROR 8280 --- [           main] o.s.boot.SpringApplication               : Application run failed
>CUT
Caused by: org.hibernate.type.descriptor.java.spi.JdbcTypeRecommendationException: Could not determine recommended JdbcType for Java type 'net.alepuzio.cellexercise.persistence.entity.Cell'
	at org.hibernate.type.descriptor.java.spi.UnknownBasicJavaType.getRecommendedJdbcType(UnknownBasicJavaType.java:37) ~[hibernate-core-6.3.1.Final.jar:6.3.1.Final]
	at org.hibernate.boot.model.process.internal.InferredBasicValueResolver.from(InferredBasicValueResolver.java:195) ~[hibernate-core-6.3.1.Final.jar:6.3.1.Final]
	at org.hibernate.mapping.BasicValue.resolution(BasicValue.java:459) ~[hibernate-core-6.3.1.Final.jar:6.3.1.Final]
	at org.hibernate.mapping.BasicValue.buildResolution(BasicValue.java:427) ~[hibernate-core-6.3.1.Final.jar:6.3.1.Final]
	at org.hibernate.mapping.BasicValue.resolve(BasicValue.java:314) ~[hibernate-core-6.3.1.Final.jar:6.3.1.Final]
 ```

The origin of the problem is like to be in some annotations inside the Entity class for the relationship between tables.

The entity of the table Cell ha 2 relationship OneTOOne with the table _CellWithRadius_ and _CellWithPower_ (the alternative is to use one table for the Cell with Power and Cell with Radius, but this means to add two columns that will be never either popolated, because if a Cell use the Power to calculate the Force the the same Cell can't use the Radius and viceversa).

The database H2 is running correctly, populating the db using the scripts inside the directory _src/man/resources/h2_, one for the schema and one for the data.



### Built with:

* [Eclipse](http://www.eclipse.org) - most famous IDE for Java programming language
* [Maven](http://www.maven.org) - tool to create artifacts of the project
* [JUnit](http://www.junit.org) - most famous library about the unit testing


## Contributing

* Please read the [Contributing.md](http://github.com/alepuzio/My-Vertx-Kata/CONTRIBUTING.md) for the details about the code of conduct and the process for submitting pull requests.

## Versioning

* We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/alepuzio/My-Vertx-Kata/tags). 

## Authors

* **Alessandro Puzielli** - *creator* - [Alepuzio](https://github.com/alepuzio)
* See also the list of [contributors](https://github.com/alepuzio/My-Vertx-Kata/graphs/contributor) in this project.

## License

* This project is licensed under the BSD License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* **PurpleBooth** - to publish an [excellent template](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2) of README that I used in this project 
* **Yegor256** - to write the post [Elegant READMEs](https://www.yegor256.com/2019/04/23/elegant-readme.html) about the README file and the [An Open Code Base Is Not Yet an Open Source Project](https://www.yegor256.com/2018/05/08/open-source-attributes.html) for the Open Source projects