module.exports.connections = {
  localMongoDatabase: {
    adapter: 'sails-mongo',
    host: 'localhost',
    port: 27017,
    database:'beacon'
  },

  productionMongoDatabase: {
    adapter: 'sails-mongo',
    host: process.env.BEACON_MONGO_HOST,
    port: process.env.BEACON_MONGO_PORT,
    user: process.env.BEACON_MONGO_USER,
    password: process.env.BEACON_MONGO_PASSWORD,
    database: process.env.BEACON_MONGO_DATABASE
  }
};
