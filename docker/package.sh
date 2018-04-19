#!/bin/sh

# for i in order product price cart inventory refund user
for i in order
do
echo "********************$i********************"
cd ../$i"Service"
export DB_HOST=$i"Mysql"
gradle fC fM build
cp ./build/distributions/$i"Service".tar ../docker/
cd ../docker
tar xf ./$i"Service".tar
rm ./$i"Service".tar
echo "********************$i********************"
done  
