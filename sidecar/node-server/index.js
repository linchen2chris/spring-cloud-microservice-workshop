var http = require("http");
var url = require("url");

const server = http.createServer(function(req, res) {
	const pathname = url.parse(req.url).pathname;

	res.writeHead(200, { 'Content-Type': 'application/json; charset=utf-8'});
	if (pathname === "/") {
		res.end(JSON.stringify({"index": "welcome!"}));
	} else if (pathname === "/health") {
		res.end(JSON.stringify({"status": "UP"}));
	}
	res.end("404");
});

server.listen(8002, function() {
	console.log("Line 8", "listening on localhost: 8002");
});
