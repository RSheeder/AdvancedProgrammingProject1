@echo off
REM Set path to default java 11 install location
REM set PATH=C:\Program Files\Java\jdk-11.0.4\bin

set CLASSPATH=%cd%\lib\derby.jar;%cd%\lib\derbytools.jar;%cd%/lib/derbyoptionaltools.jar;%cd%
javac TestDB.java
java TestDB
PAUSE