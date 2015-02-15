module.exports = {

  attributes: {
    uuid: {
      type: 'string',
      required: true,
      unique: true,
      primaryKey: true
    },
    customer: {
      type: 'string',
      required: true,
    },
    tag: {
      type: 'array',
    },
    name: {
      type: 'string',
      required: true
    },
    activeRange: {
      type: 'float'
    },
    content: 'string'
  }
};
