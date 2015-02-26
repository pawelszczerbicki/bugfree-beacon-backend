# API
According to [Blueprint API](https://github.com/balderdashy/sails-docs/tree/master/reference/blueprint-api).

## Customer
### Add new customer

    curl -XPOST -H "Content-type: application/json" localhost:1337/customer/ -d '
    {
      "name": "Mariolka Fryzjer",
      "description": "Fryzjer Mariolka najlepszy na świecie. Idzicie tylko tutaj",
      "latitude" : 51.114571 ,
      "longitude" : 17.030698,
      "tags": ["uroda", "usługa"],
      "email": "mariolka@fryzjer.pl",
      "password": "supersecrethash"
    }
    '
### Find customers
    curl -XGET localhost:1337/customer


####Filtering:

    curl -XGET localhost:1337/customer?name=BIGBUT

### Update customerų
    curl -XPUT -H "Content-type: application/json" localhost:1337/customer/54e2239c58b262dc8ae5058c -d '
    {
      "password": "bigszu"
    }
    '
### Remove customer
    $ curl -XDELETE localhost:1337/customer/54e2239c58b262dc8ae5058c

## Beacon
### Add new beacon
    curl -XPOST -H "Content-type: application/json" localhost:1337/beacon -d '
    {
      "uuid": "B9407F30-F5F8-466E-AFF9-25556B57FE6D",
      "major": 36077,
      "minor": 12917,
      "customer": "54eea176504df2cb0380cb26",
      "name": "Witryna",
      "image_url": "http://img01.imgsinemalar.com/images/group_image_buyuk/8329/Kel-AdamJohnny-Sins-1.jpg",
      "push_text" : "Strzyżenie na łyso za 4 zł!"
    }
    '


### Retrieving examples
#### By UUID, minor & major
    curl -X GET http://localhost:1337/beacon?uuid=B9407F30-F5F8-466E-AFF9-25556B57FE6D&major=58599&minor=39914

#### By customer
    curl -XGET localhost:1337/beacon?customer=54e0a15f3cc63e9a83f5ca43

## History
Every time a beacon is discovered by application - store this information

    curl -XPOST -H "Content-type: application/json" localhost:1337/history -d '
    {
        "beacon_uuid": "54e4be1631ae00bc06cc04fc",
        "imei": "356938035643809",
        "content": "This is exactly what was displayed on users device"
    }
    '
