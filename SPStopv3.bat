@echo off

::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
title SQL 서비스 상태변경
:LOOP
echo =================================================
echo    옵션을 선택해주세요.
echo    "stop | disable | enable | start"
echo    "oracle | maria"
echo =================================================
color 0E
set /p Option=옵션입력:
set /p applyDB=적용DB:

if /i "%Option%" == "stop" goto:STOP
if /i "%Option%" == "disable" goto:DISABLE
if /i "%Option%" == "enable" goto:ENABLE
if /i "%Option%" == "start" goto:START

cls
goto LOOP
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

:STOP
echo SQL서비스들을 멈춥니다
if %applyDB% == oracle (
	net stop OracleOraDb11g_home1ClrAgent
	net stop OracleOraDb11g_home1TNSListener
	net stop OracleServiceORCL
	net stop OracleJobSchedulerORCL
	net stop OracleDBConsoleorcl
	net stop OracleVssWriterORCL
)
if %applyDB% == maria (
	net stop MariaDB
	)
goto:EXIT

:DISABLE
echo SQL서비스들을 사용 안 함으로 설정합니다
if %applyDB% == oracle (
	sc config OracleOraDb11g_home1ClrAgent start= disabled                      
	sc config OracleOraDb11g_home1TNSListener start= disabled
	sc config OracleServiceORCL start= disabled
	sc config OracleJobSchedulerORCL start= disabled
	sc config OracleDBConsoleorcl start= disabled
	sc config OracleVssWriterORCL start= disabled
)
if %applyDB% == maria (
	sc config MariaDB start= disabled
)
goto:EXIT


:ENABLE
echo SQL서비스들을 사용함으로 설정합니다
if %applyDB% == oracle (
	sc config OracleOraDb11g_home1ClrAgent start= demand
	sc config OracleOraDb11g_home1TNSListener start= demand
	sc config OracleServiceORCL start= demand
	sc config OracleJobSchedulerORCL start= demand
	sc config OracleDBConsoleorcl start= demand
	sc config OracleVssWriterORCL start= demand
)
if %applyDB% == maria (
	sc config MariaDB start= demand
)
goto:EXIT


:START
echo SQL서비스들을 시작합니다
if %applyDB% == oracle (
	sc start OracleOraDb11g_home1ClrAgent
	sc start OracleOraDb11g_home1TNSListener
	sc start OracleServiceORCL
	sc start OracleJobSchedulerORCL
	sc start OracleDBConsoleorcl
	sc start OracleVssWriterORCL
)
if %applyDB% == maria (
	sc start MariaDB
)
goto:EXIT


:EXIT
echo 작업이 완료되었습니다.
set /p oneMore=추가 작업이 있으신가요(y/n):
if /i %oneMore% == y (goto:LOOP)
pause
