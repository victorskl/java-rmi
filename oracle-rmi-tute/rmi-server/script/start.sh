#!/usr/bin/env bash

java -cp rmi-common-1.0-SNAPSHOT.jar:rmi-server-1.0-SNAPSHOT.jar -Djava.rmi.server.codebase=http://127.0.0.1:8080/ -Djava.security.policy=security.policy rmi.engine.ComputeEngine