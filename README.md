# README #

This README documents a chess library for chess board infrastructure.

### What is this repository for? ###

* a library for chess board infrastructure
* Version 5.4.0

### How do I get set up? ###

* This library will be included as a dependency

### Who do I talk to? ###

* Repo owner or admin

# graph #

The rules of chess (also known as the laws of chess) are rules governing the play of the game of chess.
Chess is a board game utilizing a chessboard.

For chess players there is no need for a definition of a chessboard: it is a two-dimensional grid.
But examining variants of chess the grid disappears and a tessalation of the plane replaces the grid.
The square as a location of a chess piece becomes a node of a graph. With this kind of view also the
restriction of two dimensions disappears.

For basic moves a rook moves any number of vacant squares in a horizontal or vertical direction.
In grid view a rook move will be described by changes of the coordinates (file, rank): while horizontal
means, file will be constant, vertical means rank will be constant.
For the graph view a move in a direction is a movement along a line and a line is an ordered set of nodes
without tees or branches. The ordered list of nodes is the concept of a line with a discrete set of nodes.
If a piece is located on a square, this means, the peace can move along a line of nodes.
If a piece can move into different directions there is a bundle of lines to move along.

graph is a layer of chess383 to provide the bundle of lines to move along.

# graph is a library for a generalized chess board. #

