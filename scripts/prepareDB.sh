#!/bin/bash

SERVER_URL=http://bejkon.herokuapp.com

echo '[*] Wiping customers ... '
curl -XDELETE $SERVER_URL/customer/1
curl -XDELETE $SERVER_URL/customer/2

echo '[*] Putting new customers ...'
curl -XPOST -H "Content-type: application/json" $SERVER_URL/customer -d '
{
        "name": "MEGAZORD",
        "email": "lord@megazord.com",
        "password": "reptails"
}
'

curl -XPOST -H "Content-type: application/json" $SERVER_URL/customer -d '
{
        "name": "Pralki",
        "email": "reklama@pralki.com",
        "password": "wizir"
}
'
