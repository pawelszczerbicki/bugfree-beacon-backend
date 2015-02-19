/**
 * Production environment settings
 *
 * This file can include shared settings for a production environment,
 * such as API keys or remote database passwords.  If you're using
 * a version control solution for your Sails app, this file will
 * be committed to your repository unless you add it to your .gitignore
 * file.  If your repository will be publicly viewable, don't add
 * any private information to this file!
 *
 */

module.exports = {

  /***************************************************************************
   * Set the default database connection for models in the production        *
   * environment (see config/connections.js and config/models.js )           *
   ***************************************************************************/

  models: {
     connections: {
       mongoDB: {
         host: process.env.BEACON_MONGO_HOST,
         port: process.env.BEACON_MONGO_PORT,
         user: process.env.BEACON_MONGO_USER,
         password: process.env.BEACON_MONGO_PASSWORD,
         database: process.env.BEACON_MONGO_DATABASE
       }
     }
  }
};
