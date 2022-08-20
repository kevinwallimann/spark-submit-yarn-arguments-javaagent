# Spark Submit Yarn Arguments Java Agent

## Overview
This Java agent can be used to print the arguments passed to YARN when submitting the application using spark-submit.
The output is printed to stdout.

## Usage
Compile the agent with
```
mvn clean package
``` 

Then, use it with a spark-submit by setting the `SPARK_SUBMIT_OPTS` env variable like this:

```
SPARK_SUBMIT_OPTS="-javaagent:<project-dir>/target/spark-submit-yarn-arguments-javaagent-<version>.jar" spark-submit.sh ...
```
