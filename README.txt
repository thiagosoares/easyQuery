k
To run with Eclipse/IntelliJ, add the eclipselink.jar to the build path if you see the message of missing EclipseLink provider.

To generate the jar, run the maven command: mvn clean package
To generate the cobertura report, run the manven command: mvn clean cobertura:cobertura