package vn.iostar;

public class Snippet {
	<project xmlns="https://maven.apache.org/POM/4.0.0"
		xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="https://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
		<modelVersion>4.0.0</modelVersion>
		<groupId>vn.iotstar</groupId>
		<artifactId>SignIn</artifactId>
		<version>1.1.0</version>
		<packaging>war</packaging>
		<build>
			<pluginManagement>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.13.0</version>
						<configuration>
							<!-- put your configurations here -->
							<source>17</source>
							<target>17</target>
						</configuration>
					</plugin>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-war-plugin</artifactId>
						<version>3.4.0</version>
						<configuration>
							<webappDirectory></webappDirectory>
						</configuration>
					</plugin>
				</plugins>
			</pluginManagement>
		</build>
		<dependencies>
			<!--
			https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api -->
			<dependency>
				<groupId>jakarta.servlet</groupId>
				<artifactId>jakarta.servlet-api</artifactId>
				<version>6.1.0</version>
				<scope>provided</scope>
			</dependency>
			<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
			<dependency>
				<groupId>mysql</groupId>
				<artifactId>mysql-connector-java</artifactId>
				<version>8.0.33</version>
			</dependency>
			<!--
			https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api -->
			<dependency>
				<groupId>jakarta.servlet.jsp.jstl</groupId>
				<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
				<version>3.0.2</version>
			</dependency>
			<!--
			https://mvnrepository.com/artifact/jakarta.servlet.jsp/jakarta.servlet.jsp-api -->
			<dependency>
				<groupId>jakarta.servlet.jsp</groupId>
				<artifactId>jakarta.servlet.jsp-api</artifactId>
				<version>4.0.0</version>
				<scope>provided</scope>
			</dependency>
			<!--
			https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl -->
			<dependency>
				<groupId>org.glassfish.web</groupId>
				<artifactId>jakarta.servlet.jsp.jstl</artifactId>
				<version>3.0.1</version>
			</dependency>
		</dependencies>
	</project>
}

