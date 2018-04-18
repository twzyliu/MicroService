#!/bin/sh

for i in orderService productService priceService cartService inventoryService refundService userService
do
echo "********************$i********************"
cd ../$i
./gradlew fC fM build
cp ./build/distributions/$i.tar ../docker/
cd ../docker
tar xf ./$i.tar
rm ./$i.tar
echo "********************$i********************"
done  
