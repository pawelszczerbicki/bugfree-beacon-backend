module.exports = {

  attributes: {
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
