@echo off
rem remade by JSM
rem actualizar previamente %CLASSPATH% e %PATH% para acesso a ANTLR & JAVA*...:
rem set CLASSPATH=C:\...\LPROG-ANTLR; C:\...\LPROG-ANTLR\antlr-4.9.2-complete.jar

rem início
set param1=%1
set param2=%2
set param3=%3
if [%1] equ [] (
	set /p param1="Qual o nome da gramatica.G4? "
)
if [%2] equ [] (
	set /p param2="Qual a regra inicial? "
)
if [%3] equ [] (
	set /p param3="Ficheiro de entrada.TXT ou vazio para input online? "
)

java org.antlr.v4.Tool %param1%.g4 -o tmp\
javac tmp\%param1%*.java

If not [%param3%]==[] ( 
	java -cp "%CLASSPATH%;.\tmp" org.antlr.v4.gui.TestRig %param1% %param2% -gui %param3%.txt 
) Else (
	echo escrever expressoes {CTRL+Z para terminar}:
 	java -cp "%CLASSPATH%;.\tmp" org.antlr.v4.gui.TestRig %param1% %param2% -gui )
)
