READ ME
Contributions:

Name: Simon Lay StudentId:s3658769
In charge of: Sprites/loading sprites to board
Contribution: I have implemented the Assets and sprites for the game which required the development
of the sprite sheet and cropping them then incorporating each into the board,
i've also made the methods to print the board and the method to print out the walls,
players, monsters onto the game client gui. It would also update each sprite on the board depending on the
frames per second.

Name: Ben O'Sullivan StudentId:s3662617
In charge of: Server and Networking
Contribution: I have implemented a server that communicates via RMI that enables many clients to connect to
one server so as to enable realtime connections across all clients.
 I created MonsterServer, the related interfaces, the related handlers,
the GameLoop, and implemented the BoardPiece heirarchy, including Entity, Monster, and Player.

I have also created the base of the project and initialised all possible test cases for team members
to work with.
-(written by team members since Ben is currently on holiday!)

Name: Boxuan Lu StudentId:s3654900
In charge of: player movement
Contribution: I take charge of player movement due to what user input.
The main thing that I've done is to calculate if the move user want to make is valid or not.
If it is a valid move, process the move and assign the new position value to user.
If it is not valid, keep to player at the position and wait for next player input

Name: Tanzim Shahriar StudentId: s3642965
In charge of: Monster Movement/AI
Contribution: I have worked on the monster's movement based on the player,monster and wall instances present in board.
The algorithm used to find the closest path is a* algorithm and its written in PathFinder and Position class.
To update monster's position moveTowardsClosestPlayer is called in GameLoop in the server.
The findPath() method in Pathfinder class finds the shortest path from a player and the monster that is passed in as
argument and returns the size of that path. The monster class calls findPath() for all players and stores the
sizes of those paths. The shortest player is found in the getNearestPlayer() method in Monster
class. And then finally the monster position is updated


Name: Tristan Mitchell StudentId:





