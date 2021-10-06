REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.spd.communicationprotocol\target\base.app.spd.communicationprotocol-1.4.0-SNAPSHOT.jar;base.app.spd.communicationprotocol\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eapli.base.app.spd.communicationprotocol.MotorFluxoAtividades