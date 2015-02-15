module.exports.connections = {

  /***************************************************************************
  *                                                                          *
  * MongoDB is the leading NoSQL database.                                   *
  * http://en.wikipedia.org/wiki/MongoDB                                     *
  *                                                                          *
  * Run: npm install sails-mongo                                             *
  *                                                                          *
  ***************************************************************************/
  localMongoDatabase: {
    adapter: 'sails-mongo',
    host: 'localhost',
    port: 27017,
    database:'beacon'
  },

  productionMongoDatabase: {
    adapter: 'sails-mongo',
    host: 'localhost',
    port: process.env.BEACON_MONGO_PORT,
    user: process.env.BEACON_MONGO_USER,
    password: process.env.BEACON_MONGO_PASSWORD,
    database: process.env.BEACON_MONGO_DATABASE
  }
};
