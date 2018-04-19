@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  orderService startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and ORDER_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

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
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\orderService.jar;%APP_HOME%\lib\jbcrypt.jar;%APP_HOME%\lib\fastjson-1.2.5.jar;%APP_HOME%\lib\mockserver-netty-3.10.4.jar;%APP_HOME%\lib\httpclient-4.5.5.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.13.jar;%APP_HOME%\lib\slf4j-log4j12-1.7.13.jar;%APP_HOME%\lib\consul-client-0.9.16.jar;%APP_HOME%\lib\mockserver-client-java-3.10.4.jar;%APP_HOME%\lib\mockserver-core-3.10.4.jar;%APP_HOME%\lib\mockserver-logging-3.10.4.jar;%APP_HOME%\lib\logback-classic-1.1.3.jar;%APP_HOME%\lib\slf4j-api-1.7.13.jar;%APP_HOME%\lib\mybatis-3.3.0.jar;%APP_HOME%\lib\guice-bridge-2.4.0-b09.jar;%APP_HOME%\lib\mybatis-guice-3.7.jar;%APP_HOME%\lib\jersey-container-grizzly2-http-2.17.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.17.jar;%APP_HOME%\lib\jersey-server-2.17.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.17.jar;%APP_HOME%\lib\jackson-datatype-joda-2.4.0.jar;%APP_HOME%\lib\grizzly-http-servlet-2.3.16.jar;%APP_HOME%\lib\json-schema-validator-2.2.6.jar;%APP_HOME%\lib\joda-time-2.6.jar;%APP_HOME%\lib\javax.servlet-api-3.0.1.jar;%APP_HOME%\lib\jersey-client-2.17.jar;%APP_HOME%\lib\jersey-media-jaxb-2.17.jar;%APP_HOME%\lib\jersey-common-2.17.jar;%APP_HOME%\lib\jersey-entity-filtering-2.17.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\guice-3.0.jar;%APP_HOME%\lib\jackson-datatype-guava-2.6.3.jar;%APP_HOME%\lib\finagle-native_2.11-6.33.0.jar;%APP_HOME%\lib\finagle-http_2.11-6.33.0.jar;%APP_HOME%\lib\finagle-core_2.11-6.33.0.jar;%APP_HOME%\lib\util-cache_2.11-6.32.0.jar;%APP_HOME%\lib\util-collection_2.11-6.32.0.jar;%APP_HOME%\lib\json-schema-core-1.2.5.jar;%APP_HOME%\lib\uri-template-0.9.jar;%APP_HOME%\lib\jackson-coreutils-1.8.jar;%APP_HOME%\lib\guava-18.0.jar;%APP_HOME%\lib\gson-2.3.jar;%APP_HOME%\lib\mysql-connector-java-5.1.34.jar;%APP_HOME%\lib\netty-codec-http-4.0.34.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.0.34.Final.jar;%APP_HOME%\lib\netty-handler-4.0.34.Final.jar;%APP_HOME%\lib\netty-codec-4.0.34.Final.jar;%APP_HOME%\lib\netty-transport-4.0.34.Final.jar;%APP_HOME%\lib\netty-buffer-4.0.34.Final.jar;%APP_HOME%\lib\netty-common-4.0.34.Final.jar;%APP_HOME%\lib\bcmail-jdk15on-1.52.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.52.jar;%APP_HOME%\lib\bcprov-jdk15on-1.52.jar;%APP_HOME%\lib\janino-2.5.10.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\httpcore-4.4.9.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\util-codec_2.11-6.32.0.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\hk2-locator-2.4.0-b10.jar;%APP_HOME%\lib\hk2-api-2.4.0-b10.jar;%APP_HOME%\lib\hk2-utils-2.4.0-b10.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\javax.inject-2.4.0-b10.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.6.3.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.6.3.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.6.3.jar;%APP_HOME%\lib\jackson-databind-2.6.3.jar;%APP_HOME%\lib\jackson-annotations-2.6.3.jar;%APP_HOME%\lib\jackson-core-2.6.3.jar;%APP_HOME%\lib\grizzly-http-server-2.3.16.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\cglib-2.2.1-v20090111.jar;%APP_HOME%\lib\commons-lang3-3.4.jar;%APP_HOME%\lib\value-2.0.16.jar;%APP_HOME%\lib\jzlib-1.1.3.jar;%APP_HOME%\lib\jsonassert-1.2.3.jar;%APP_HOME%\lib\logback-core-1.1.3.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\jersey-guava-2.17.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\aopalliance-repackaged-2.4.0-b10.jar;%APP_HOME%\lib\javassist-3.18.1-GA.jar;%APP_HOME%\lib\grizzly-http-2.3.16.jar;%APP_HOME%\lib\asm-3.1.jar;%APP_HOME%\lib\util-jvm_2.11-6.32.0.jar;%APP_HOME%\lib\util-logging_2.11-6.32.0.jar;%APP_HOME%\lib\util-app_2.11-6.32.0.jar;%APP_HOME%\lib\util-registry_2.11-6.32.0.jar;%APP_HOME%\lib\util-stats_2.11-6.32.0.jar;%APP_HOME%\lib\util-core_2.11-6.32.0.jar;%APP_HOME%\lib\util-hashing_2.11-6.32.0.jar;%APP_HOME%\lib\util-lint_2.11-6.32.0.jar;%APP_HOME%\lib\util-function_2.11-6.32.0.jar;%APP_HOME%\lib\scala-parser-combinators_2.11-1.0.4.jar;%APP_HOME%\lib\scala-library-2.11.7.jar;%APP_HOME%\lib\json-20090211.jar;%APP_HOME%\lib\msg-simple-1.1.jar;%APP_HOME%\lib\btf-1.2.jar;%APP_HOME%\lib\jsr305-3.0.0.jar;%APP_HOME%\lib\libphonenumber-6.2.jar;%APP_HOME%\lib\mailapi-1.4.3.jar;%APP_HOME%\lib\jopt-simple-4.6.jar;%APP_HOME%\lib\xercesImpl-2.4.0.jar;%APP_HOME%\lib\commons-io-1.3.2.jar;%APP_HOME%\lib\grizzly-framework-2.3.16.jar;%APP_HOME%\lib\jsr166e-1.0.0.jar;%APP_HOME%\lib\netty-3.10.1.Final.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\rhino-1.7R4.jar;%APP_HOME%\lib\activation-1.1.jar;%APP_HOME%\lib\commons-collections-3.2.1.jar

@rem Execute orderService
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %ORDER_SERVICE_OPTS%  -classpath "%CLASSPATH%" com.thoughtworks.ketsu.MainServer %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable ORDER_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%ORDER_SERVICE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
