 
# RSA KEY

#### key 만들기   
keytool -genkeypair -alias auth -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" -keypass passone -keystore server.jks -storepass passtwo

#### 인증키 만들기
keytool -export -keystore server.jks -alias auth -file server.cer

### 인증키 내용 보기 
openssl x509 -inform der -in server.cer -pubkey -noout

