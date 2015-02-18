# API
According to [Blueprint API](https://github.com/balderdashy/sails-docs/tree/master/reference/blueprint-api).

## Customer
### Add new customer
    curl -XPOST -H "Content-type: application/json" localhost:1337/customer -d '
    {
            "name": "PEPCO",
            "email": "ceo@pepco.pl",
            "password": "shoes"
    }
    '

Response:

    {
      "name": "PEPCO",
      "email": "ceo@pepco.pl",
      "password": "shoes",
      "createdAt": "2015-02-16T16:53:28.248Z",
      "updatedAt": "2015-02-16T16:53:28.248Z",
      "id": "54e2208858b262dc8ae5058b"
    }
### Find customers
    curl -XGET localhost:1337/customer

Response:

    [
    {
        "name": "name",
        "email": "some@some.pl",
        "password": "some",
        "createdAt": "2015-02-15T13:38:39.005Z",
        "updatedAt": "2015-02-15T13:38:39.005Z",
        "id": "54e0a15f3cc63e9a83f5ca43"
    },
    {
          "name": "PEPCO",
          "email": "ceo@pepco.pl",
          "password": "shoes",
          "createdAt": "2015-02-16T16:53:28.248Z",
          "updatedAt": "2015-02-16T16:53:28.248Z",
          "id": "54e2208858b262dc8ae5058b"
    }
    ]

####Filtering:

    curl -XGET localhost:1337/customer?name=pepco

Response:

    [{
          "name": "PEPCO",
          "email": "ceo@pepco.pl",
          "password": "shoes",
          "createdAt": "2015-02-16T16:53:28.248Z",
          "updatedAt": "2015-02-16T16:53:28.248Z",
          "id": "54e2208858b262dc8ae5058b"
    }]

### Update customerų
    curl -XPUT -H "Content-type: application/json" localhost:1337/customer/54e2239c58b262dc8ae5058c -d '
    {
      "password": "bigszu"
    }
    '

Response:

    {
      "name": "PEPCO",
      "email": "ceo@pepco.pl",
      "password": "bigszu",
      "createdAt": "2015-02-16T17:06:36.941Z",
      "updatedAt": "2015-02-16T17:08:55.654Z",
      "id": "54e2239c58b262dc8ae5058c"
    }
### Remove customer
    $ curl -XDELETE localhost:1337/customer/54e2239c58b262dc8ae5058c

Response:

    {
      "name": "PEPCO",
      "email": "ceo@pepco.pl",
      "password": "bigszu",
      "createdAt": "2015-02-16T17:06:36.941Z",
      "updatedAt": "2015-02-16T17:08:55.654Z",
      "id": "54e2239c58b262dc8ae5058c"
    }

## Beacon
### Add new beacon
    curl -XPOST -H "Content-type: application/json" localhost:1337/beacon -d '
    {
      "uuid": "54e4be1631ae00bc06cc04fc",
      "customer": "54e0a15f3cc63e9a83f5ca43",
      "name": "Shoe Beacon",
      "tag": ["shoes","limited"],
      "activeRange": 2.5,
      "content": "Hey Man. Buy me!"
    }
    '

Response:

    {
      "uuid": "54e4be1631ae00bc06cc04fc",
      "customer": "54e0a15f3cc63e9a83f5ca43",
      "name": "Shoe Beacon",
      "tag": [
        "shoes",
        "limited"
      ],
      "activeRange": 2.5,
      "content": "Hey Man. Buy me!",
      "createdAt": "2015-02-18T16:30:14.345Z",
      "updatedAt": "2015-02-18T16:30:14.345Z",
      "id": "54e4bf04f31efdc606a060d3"
    }

### Retrieving examples
#### By UUID
    curl -XGET localhost:1337/beacon/54e4be1631ae00bc06cc04fc
#### By customer
    curl -XGET localhost:1337/beacon?customer=54e0a15f3cc63e9a83f5ca43
#### By tag
    curl -XGET localhost:1337/beacon?tag=limited

## History
Every time a beacon is discovered by application - store this information

    curl -XPOST -H "Content-type: application/json" localhost:1337/history -d '
    {
        "beacon_uuid": "54e4be1631ae00bc06cc04fc",
        "imei": "356938035643809",
        "content": "This is exactly what was displayed on users device"
    }
    '

Response:

    {
      "beacon_uuid": "54e4be1631ae00bc06cc04fc",
      "imei": "356938035643809",
      "content": "This is exactly what was displayed on users device",
      "createdAt": "2015-02-18T16:53:40.184Z",
      "updatedAt": "2015-02-18T16:53:40.184Z",
      "id": "54e4c3946ed93c1a077c7e80"
    }
