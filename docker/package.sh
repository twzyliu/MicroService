#!/bin/sh

while [ `curl mysql:3306 2>/dev/null || echo "sleep"` ]; do
	sleep 1;
done
sleep 3;
for i in order product price cart inventory refund user
do
	echo "********************${i}********************"
	cd ../${i}Service
	export DB_ON_CREATE_DB=${i}_d
	export DB_HOST=mysql
	gradle fM build
	cp ./build/distributions/${i}Service.tar ../docker/
	cd ../docker
	tar xf ./${i}Service.tar
	rm ./${i}Service.tar
	echo "********************${i}********************"
done  
