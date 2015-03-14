module.exports = {

  attributes: {
    uuid: {
      type: 'string',
      required: true,
    },
    major: {
      type: 'integer',
      required: true
    },
    minor: {
      type: 'integer',
      required: true
    },
    customer: {
      type: 'string',
      required: true,
    },
    name: {
      type: 'string',
      required: true
    },
    imageUrl: 'string',
    pushText: 'string'
  }
};
