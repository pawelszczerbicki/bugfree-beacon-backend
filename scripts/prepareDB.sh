curl -XPOST -H "Content-type: application/json" localhost:1337/customer/ -d '
{
  "name": "Mariolka Fryzjer",
  "description": "Fryzjer Mariolka najlepszy na świecie. Idzicie tylko tutaj",
  "latitude" : 51.114571 ,
  "longitude" : 17.030698,
  "tags": ["uroda", "usługa"],
  "email": "mariolka@fryzjer.pl",
  "password": "supersecrethash"
}
'

curl -XPOST -H "Content-type: application/json" localhost:1337/customer/ -d '
{
  "name": "BIGBUT",
  "description": "W BIGBUT kupisz drogo naprawdę super duże buty",
  "latitude" : 51.106751,
  "longitude" : 17.030322,
  "tags": ["moda", "sklep", "buty"],
  "email": "adam@bigbut.pl",
  "password": "supersecrethash"
}
'

curl -XPOST -H "Content-type: application/json" localhost:1337/beacon -d '
{
  "uuid": "B9407F30-F5F8-466E-AFF9-25556B57FE6D",
  "major": 36077,
  "minor": 12917,
  "customer": "54eea176504df2cb0380cb26",
  "name": "Witryna",
  "image_url": "http://img01.imgsinemalar.com/images/group_image_buyuk/8329/Kel-AdamJohnny-Sins-1.jpg",
  "push_text" : "Strzyżenie na łyso za 4 zł!"
}
'

curl -XPOST -H "Content-type: application/json" localhost:1337/beacon -d '
{
  "uuid": "B9407F30-F5F8-466E-AFF9-25556B57FE6D",
  "major": 58599,
  "minor": 39914,
  "customer": "54eea22f504df2cb0380cb27",
  "name": "Witryna",
  "image_url": "http://cdn.frontpagemag.com/wp-content/uploads/2013/03/0-big_shoe.jpg",
  "push_text" : "Rabat 20% z tą notyfikacją"
}
'

curl -XPOST -H "Content-type: application/json" localhost:1337/beacon -d '
{
  "uuid": "B9407F30-F5F8-466E-AFF9-25556B57FE6D",
  "major": 37751,
  "minor": 33470,
  "customer": "54eea22f504df2cb0380cb27",
  "name": "Kasa",
  "image_url": "https://janetnewenham.files.wordpress.com/2013/09/800px-big-shoe-tricycles-vehicle.jpg",
  "push_text" : "Dziękujemy za zakupy. Zobacz na fajny obrazek :)"
}
'
