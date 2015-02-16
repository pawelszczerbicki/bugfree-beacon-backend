# Bugfree Beacon Backend

A [Sails](http://sailsjs.org) application running as backend server storing informations about beacons, customers and users ...

#Deploy
    push to branch master

#Caution! Please use DEV as default branch
    push to master only in case of deploy. Before deploy merge dev to master

#Prerequisites
    sudo npm -g install sails
    npm install

Local MongoDb instance (without login and password)

#Fire project
    sails lift

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

    $ curl -XGET localhost:1337/customer?name=pepco

Response:

    [{
          "name": "PEPCO",
          "email": "ceo@pepco.pl",
          "password": "shoes",
          "createdAt": "2015-02-16T16:53:28.248Z",
          "updatedAt": "2015-02-16T16:53:28.248Z",
          "id": "54e2208858b262dc8ae5058b"
    }]

### Update customer
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
...
