module.exports = {

  attributes: {
    imei: {
      type: 'string',
      size: 15
    },
    date: {
      type: 'datetime',
      required: true
    },
    beacon_uuid : {
      type: 'string',
      required: true
    },
    ad_content: 'string'
  }
};
