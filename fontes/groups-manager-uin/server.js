const express = require('express');
const app = express();

//indicamos aonde os arquivos gerados pelo build estarao
app.use(express.static(__dirname + '/dist/groups-manager-uin'));

//indicamos que qualquer requisicao ao servidor sera disponibilizado o index
//pois a aplicacao ja sabe tratar as rotas
app.get('*/', function (req, resp) {
  resp.sendFile(__dirname + '/dist/groups-manager-uin/index.html');
});

//porta do servidor
app.listen(4200);
