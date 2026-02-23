var express = require('express');
var app = express();

var PORT = 8080;

app.use(express.static('public'));

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
})