del -f server.jks
keytool -genkey -v -alias server -keyalg RSA -keysize 2048 -validity 365 -keystore server.jks -storepass 2dmg02

REM keytool -list -v -keystore server.jks -storepass 2dmg02
