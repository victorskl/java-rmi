@echo off

REM http://stackoverflow.com/questions/16769729/why-rmi-registry-is-ignoring-the-java-rmi-server-codebase-property

rmiregistry -J-Djava.rmi.server.codebase="http://127.0.0.1:8080/"

pause