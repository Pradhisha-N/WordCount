# javawc

The `Java Word Count` ia a Java application built with the purpose of showcasing the usage of some Java 8 features, e.g. Streams, Lambdas. 
This application is very similar to Linux 'wc' tool, which basically display some statistics related to one file (number of lines, words, etc).

## Requirements
- Java 8

## Usage
This application requires to set up JAVA_HOME env variable and you also need [gradle](http://gradle.org/).
But don't worry because you don't need to download Gradle to start using it. This project is configured to use 
the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) which is a
Gradle feature which allows a developer to execute the build without having to manually install Gradle, which also makes your build more reliable
since you don't need to worry about dependencies and versions and, as a developer, you only need to focus on writing your code.

When running `gradlew` command, all the project dependencies will be automatically downloaded and the build process started. 

So, just run `gradlew` for start building your application:
```bash
$ ./gradlew
```

After that, you are ready to run your `javawc` application. Then go to folder `/build/install/JavaWC/bin` and run `./wc <filename>`.

```bash
$ ./wc file.txt
Lines: 16
Words: 16
average letters per word: 5.00
most common letter: l
```

## Generate distribution package (.zip and .tar)
You can find a distribution package in both .zip and .tar format under the `/build/distribution` folder
which contains the source code, documentation, binaries and script files for running this application.

They are organized in the following folders:
- `bin`: script files (.bat or binary)
- `lib`: javawc binaries (.jar & .jar dependencies)
- `src`: source code
- `javadoc`: javadoc


## Project Structure
This project was designed using NetBeans IDE 8.1 with JDK 8.

- The application root package is `com.oracle.javawc`
- main method for running this application as a standalone one can be found in the `com.oracle.javawc.main.Main` class.
- the logic for reading the file from the file system is available in the `com.oracle.javawc.entities.shell.FileLoader` class.
- the logic for calculating the statistics is available in the `com.oracle.javawc.entities.shell.WordCount` class.
