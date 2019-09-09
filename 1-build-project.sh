#/bin/bash

cd config-server && mvn clean install
cd ../eureka-naming-server && mvn clean install
cd ../modulo-gestao-ativo && mvn clean install
cd ../modulo-seguranca-comunicacao && mvn clean install
cd ../modulo-simulacao-sensores && mvn clean install
cd ../modulo-usuario && mvn clean install
cd ../zuul-api-gateway && mvn clean install