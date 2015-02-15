module.exports = {

  attributes: {
    uuid: {
      type: 'string',
      primaryKey: true,
      required: true,
      unique: true
    },
    name: 'string',
    email: {
      type: 'email',
      required: true
    },
    password: {
      type: 'string',
      required: true
    }
  }
};
