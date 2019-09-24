@echo off
javac TestDB.java
set CLASSPATH=%cd%\lib\derby.jar;%cd%\lib\derbytools.jar;%cd%/lib/derbyoptionaltools.jar;%cd%
java TestDB
PAUSE