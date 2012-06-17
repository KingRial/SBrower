SBrowser v0.0.1
=================
"SBrowser" is an experimental websocket server on a browser.
It uses Java Webbit (https://github.com/webbit/webbit) as a bridge between websockets and the javascript on the server.
In this experiment the server just echoes back the message it receives.
Java 1.7 must be installed.

License
-------
Copyright 2012, Riccardo Re

Dual licensed under the MIT or GPL Version 2 licenses.

<http://jquery.org/license>

Notes
-----
While playing with Javascript, HTML5, CSS3 and Canvas to create a ridicolous Tic Tac Toe browser game, I wanted to add multiplayer using websockets to echange datas between clients.
Having a server built just for this wasn't acceptable, so I dedided to do a little experiment and use a Java application as a bridge between a server browser and all the other client browsers.
I know, I know, it's a little insane :P
But I liked the idea and... this is the test source code!

Just open at least two tabs: one with the server html and the other with the client html and write something.
The message will be received from the server and echoed back to the client.

Special Thanks to:
https://github.com/webbit/webbit

Change Log
----------
 * __0.0.1__
  - Commited on Git Hub first release