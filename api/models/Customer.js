module.exports = {

  attributes: {
    name: {
      type: 'string',
      requried: true
    },
    description: 'string',
    latitude: 'float',
    longitude: 'float',
    tags: 'array',
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
