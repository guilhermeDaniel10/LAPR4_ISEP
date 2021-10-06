#!/bin/bash
STOREPASS="forgotten"
for ENT in server_J client1_J client2_J client3_J client4_J; do
 rm -f ${ENT}.jks ${ENT}.pem
 echo -e "${ENT}\nDEI\nISEP\nPORTO\nPORTO\nPT\nyes" | keytool -genkey -v -alias ${ENT} -keyalg RSA -keysize 2048 \
	-validity 365 -keystore ${ENT}.jks -storepass ${STOREPASS}
 keytool -exportcert -alias ${ENT} -keystore ${ENT}.jks -storepass ${STOREPASS} -rfc -file ${ENT}.pem
done
for ENT in server2_J client5_J client6_J client7_J client8_J; do
 rm -f ${ENT}.jks ${ENT}.pem
 echo -e "${ENT}\nDEI\nISEP\nPORTO\nPORTO\nPT\nyes" | keytool -genkey -v -alias ${ENT} -keyalg RSA -keysize 2048 \
	-validity 365 -keystore ${ENT}.jks -storepass ${STOREPASS}
 keytool -exportcert -alias ${ENT} -keystore ${ENT}.jks -storepass ${STOREPASS} -rfc -file ${ENT}.pem
done
for ENT in server3_J client9_J client10_J client11_J client12_J; do
 rm -f ${ENT}.jks ${ENT}.pem
 echo -e "${ENT}\nDEI\nISEP\nPORTO\nPORTO\nPT\nyes" | keytool -genkey -v -alias ${ENT} -keyalg RSA -keysize 2048 \
	-validity 365 -keystore ${ENT}.jks -storepass ${STOREPASS}
 keytool -exportcert -alias ${ENT} -keystore ${ENT}.jks -storepass ${STOREPASS} -rfc -file ${ENT}.pem
done
for ENT in server4_J client13_J client14_J client15_J client16_J; do
 rm -f ${ENT}.jks ${ENT}.pem
 echo -e "${ENT}\nDEI\nISEP\nPORTO\nPORTO\nPT\nyes" | keytool -genkey -v -alias ${ENT} -keyalg RSA -keysize 2048 \
	-validity 365 -keystore ${ENT}.jks -storepass ${STOREPASS}
 keytool -exportcert -alias ${ENT} -keystore ${ENT}.jks -storepass ${STOREPASS} -rfc -file ${ENT}.pem
done
####
echo "Creating trust relations"
### IMPORTING TRUSTED CERTIFICATES
### (Every client trusts server_J)
for ENT in client1_J client2_J client3_J client4_J; do
 echo "yes"|keytool -import -alias ${ENT} -keystore server_J.jks -file ${ENT}.pem -storepass ${STOREPASS}
 echo "yes"|keytool -import -alias server_J -keystore ${ENT}.jks -file server_J.pem -storepass ${STOREPASS}
done
echo "############################################################################"
keytool -list -keystore server_J.jks -storepass ${STOREPASS}
echo "############################################################################"
#######
for ENT in client5_J client6_J client7_J client8_J; do
 echo "yes"|keytool -import -alias ${ENT} -keystore server2_J.jks -file ${ENT}.pem -storepass ${STOREPASS}
 echo "yes"|keytool -import -alias server2_J -keystore ${ENT}.jks -file server2_J.pem -storepass ${STOREPASS}
done
echo "############################################################################"
keytool -list -keystore server2_J.jks -storepass ${STOREPASS}
echo "############################################################################"
#######
for ENT in client9_J client10_J client11_J client12_J; do
 echo "yes"|keytool -import -alias ${ENT} -keystore server3_J.jks -file ${ENT}.pem -storepass ${STOREPASS}
 echo "yes"|keytool -import -alias server3_J -keystore ${ENT}.jks -file server3_J.pem -storepass ${STOREPASS}
done
echo "############################################################################"
keytool -list -keystore server3_J.jks -storepass ${STOREPASS}
echo "############################################################################"
#######
for ENT in client13_J client14_J client15_J client16_J; do
 echo "yes"|keytool -import -alias ${ENT} -keystore server4_J.jks -file ${ENT}.pem -storepass ${STOREPASS}
 echo "yes"|keytool -import -alias server4_J -keystore ${ENT}.jks -file server4_J.pem -storepass ${STOREPASS}
done
echo "############################################################################"
keytool -list -keystore server4_J.jks -storepass ${STOREPASS}
echo "############################################################################"
#######
