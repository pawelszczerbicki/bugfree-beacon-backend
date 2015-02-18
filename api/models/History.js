module.exports = {

  attributes: {
    imei: {
      type: 'string',
      required: true,
      size: 15
    },
    beacon_uuid : {
      type: 'string',
      required: true
    },
    ad_content: 'string'
  }
};
