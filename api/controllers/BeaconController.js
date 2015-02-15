module.exports = {
  hi: function (req, res) {
    console.log(Customer)
    Customer.create({name: "name", email: "some@some.pl", password: "some"}).exec(function (err, customer) {
      console.log(err)
      console.log(customer);
    });
    return res.json("Hi there ")
  }
};
