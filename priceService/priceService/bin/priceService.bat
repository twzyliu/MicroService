@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  priceService startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and PRICE_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\priceService.jar;%APP_HOME%\lib\jbcrypt.jar;%APP_HOME%\lib\httpclient-4.5.5.jar;%APP_HOME%\lib\slf4j-api-1.7.13.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.13.jar;%APP_HOME%\lib\slf4j-log4j12-1.7.13.jar;%APP_HOME%\lib\mybatis-3.3.0.jar;%APP_HOME%\lib\guice-bridge-2.4.0-b09.jar;%APP_HOME%\lib\mybatis-guice-3.7.jar;%APP_HOME%\lib\jersey-server-2.17.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.17.jar;%APP_HOME%\lib\jackson-datatype-joda-2.4.0.jar;%APP_HOME%\lib\jersey-container-grizzly2-http-2.17.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.17.jar;%APP_HOME%\lib\grizzly-http-servlet-2.3.16.jar;%APP_HOME%\lib\joda-time-2.6.jar;%APP_HOME%\lib\javax.servlet-api-3.0.1.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\guice-3.0.jar;%APP_HOME%\lib\guava-18.0.jar;%APP_HOME%\lib\consul-client-0.9.16.jar;%APP_HOME%\lib\gson-2.3.jar;%APP_HOME%\lib\mysql-connector-java-5.1.34.jar;%APP_HOME%\lib\httpcore-4.4.9.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\jersey-common-2.17.jar;%APP_HOME%\lib\jersey-client-2.17.jar;%APP_HOME%\lib\jersey-media-jaxb-2.17.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\javax.inject-2.4.0-b10.jar;%APP_HOME%\lib\hk2-locator-2.4.0-b10.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\jersey-entity-filtering-2.17.jar;%APP_HOME%\lib\grizzly-http-server-2.3.16.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\cglib-2.2.1-v20090111.jar;%APP_HOME%\lib\commons-lang3-3.0.jar;%APP_HOME%\lib\jackson-datatype-guava-2.6.3.jar;%APP_HOME%\lib\value-2.0.16.jar;%APP_HOME%\lib\jersey-guava-2.17.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\aopalliance-repackaged-2.4.0-b10.jar;%APP_HOME%\lib\hk2-utils-2.4.0-b10.jar;%APP_HOME%\lib\javassist-3.18.1-GA.jar;%APP_HOME%\lib\grizzly-http-2.3.16.jar;%APP_HOME%\lib\asm-3.1.jar;%APP_HOME%\lib\grizzly-framework-2.3.16.jar;%APP_HOME%\lib\hk2-api-2.4.0-b10.jar;%APP_HOME%\lib\jackson-annotations-2.6.3.jar;%APP_HOME%\lib\jackson-core-2.6.3.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.6.3.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.6.3.jar;%APP_HOME%\lib\jackson-databind-2.6.3.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.6.3.jar

@rem Execute priceService
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %PRICE_SERVICE_OPTS%  -classpath "%CLASSPATH%" com.thoughtworks.ketsu.MainServer %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable PRICE_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%PRICE_SERVICE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
