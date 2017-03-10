 
 *RSA KEY*
  
 - keytool -genkeypair -alias auth -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" -keypass passone -keystore server.jks -storepass passtwo
- keytool -export -keystore server.jks -alias auth -file server.cer
- openssl x509 -inform der -in server.cer -pubkey -noout

