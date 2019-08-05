#/bin/bash

cd config-server && mvn clean install
cd ../employee-api && mvn clean install

cd ..
