# Brelaz-Dsatur
Reference : ["New Methods to Color the Vertices of a Graph" by Daniel Bre1az] (https://pdfs.semanticscholar.org/fbf8/150f45d4358926e40f7005a2f493f39803ae.pdf)
1.The adjacency degree of a vertex is the number of vertices to which it is adjacent.
2.The saturation degree of a vertex is the number of different colors to which it is adjacent.
#Algorithm
Dsatur(𝐺 = (𝑉, 𝐸))
Arrange the vertices by decreasing order of adjacency degrees.
Mark all vertices as colorless (e.g. by assigning color 0 to all of them).
Color a vertex of maximal adjacency degree with color 1.
Repeat
  Choose a vertex with a maximal saturation degree;
  if there is more than one choice choose among them any vertex of maximal adjacency degree.
  Color the chosen vertex with the least possible (lowest numbered) color.
Until all vertices are colored.
End Dsatur

#Files
1.TCSS543 : contains the main method which calls the generate graph class to generate a graph 
with given number of nodes and density.Four groups of density are available 
Group 1(0.73-0.82), Group 2(0.61-0.72),Group 3(0.44-0.59), Group 4(0.26-0.34). After generating graph
the brelaz algorithm is implemented.
2.Node : Attributes of nodes in graph are stored.
3.Generate Graph: It will generate graph according to the given number of nodes and density.

#How to Execute
Run TCSS543.java which will return the minimum number of colors needed for the generated graph.
