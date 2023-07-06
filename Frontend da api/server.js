const http = require('http');
const fs = require('fs');
const path = require('path');

const server = http.createServer((req, res) => {
  let filePath;

  if (req.url === '/' || req.url === '/login.html') {
    filePath = path.join(__dirname, 'login.html');
  } else if (req.url === '/produto.html') {
    // Verificar se o usuário está autenticado antes de redirecionar para a página do produto
    const isAuthenticated = true; // Adicione a lógica de autenticação aqui

    if (isAuthenticated) {
      filePath = path.join(__dirname, 'produto.html');
    } else {
      filePath = path.join(__dirname, 'login.html');
    }
  } else {
    filePath = path.join(__dirname, '404.html');
  }

  fs.readFile(filePath, 'utf-8', (error, content) => {
    if (error) {
      res.writeHead(500);
      res.end('Erro ao carregar o arquivo HTML');
    } else {
      res.writeHead(200, { 'Content-Type': 'text/html' });
      res.end(content);
    }
  });
});

const port = 8081;
server.listen(port, () => {
  console.log(`Servidor executando em http://localhost:${port}`);
});