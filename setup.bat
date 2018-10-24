FOR /F "tokens=*" %%g IN ('dir "c:\Program Files\Java\jdk1.8*" /b /s') do (SET VAR=%%g)
setx -m JAVA_HOME "%VAR%"
set path = "%VAR%\bin"
shutdown.exe /r /t 00