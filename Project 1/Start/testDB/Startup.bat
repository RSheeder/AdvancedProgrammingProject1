@echo off
set CLASSPATH=%cd%\lib\derby.jar;%cd%\lib\derbytools.jar;%cd%/lib/derbyoptionaltools.jar;%cd%
javac TestDB.java
java TestDB
PAUSE